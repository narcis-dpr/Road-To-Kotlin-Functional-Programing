package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.validation

import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.Error
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.ResultAp
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.Success
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.errorMap
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.successMap
import com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.example.fp.lib.curry

interface Semigroup<T> {
    operator fun plus(rh: T): T
}

data class ValidationExceptionComposite(
    private val errors: List<ValidationException>
) : Exception(), Semigroup<ValidationExceptionComposite> {
    override fun plus(rh: ValidationExceptionComposite): ValidationExceptionComposite =
        ValidationExceptionComposite(this.errors + rh.errors)

    override fun getLocalizedMessage(): String {
        return errors.joinToString { it.localizedMessage }
    }

}

infix fun <E, T, R> ResultAp<E, (T) -> R>.applsg(a: ResultAp<E, T>) where E : Throwable, E : Semigroup<E> =
    a.apsg(this)

fun <E, T, R> ResultAp<E, T>.apsg(
    fn: ResultAp<E, (T) -> R>
): ResultAp<E, R> where E : Throwable, E : Semigroup<E> = when (fn) {
    is Error -> when (this) {
        is Error -> Error(this.error + fn.error)
        is Success -> Error(fn.error)
    }

    is Success -> successMap(fn.value)
}

fun validateNameSg(name: String): ResultAp<ValidationExceptionComposite, String> =
    if (name.length > 4) {
        Success(name)
    } else {
        Error(ValidationExceptionComposite(listOf(ValidationException("Invalid name"))))
    }

fun validateEmailSg(email: String): ResultAp<ValidationExceptionComposite, String> =
    if (email.contains("@")) {
        Success(email)
    } else {
        Error(ValidationExceptionComposite(listOf(ValidationException("Invalid email"))))
    }

fun main() {
    val userBuilder = ::User.curry()
    val userApplicative = ResultAp.success(userBuilder)
    val idAp = ResultAp.success(1)

    (userApplicative appl
            idAp appl
            validateName("") appl
            validateEmail(""))
        .errorMap {
            println("Error: $it"); it
        }
        .successMap {
            println("Success $it")
        }

}