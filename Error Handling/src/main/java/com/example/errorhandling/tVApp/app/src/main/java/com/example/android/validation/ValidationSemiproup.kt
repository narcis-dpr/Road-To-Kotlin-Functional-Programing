package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.validation

import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.Error
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.ResultAp
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.Success
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.successMap

interface Semigroup<T> {
    operator fun plus(rh: T): T
}

data class ValidationExceptionComposite(
    private val errors: List<ValidationException>
): Exception(), Semigroup<ValidationExceptionComposite> {
    override fun plus(rh: ValidationExceptionComposite): ValidationExceptionComposite =
        ValidationExceptionComposite(this.errors + rh.errors)

    override fun getLocalizedMessage(): String {
        return errors.joinToString { it.localizedMessage }
    }

}

fun <E, T, R> ResultAp<E, T>.apsg(
    fn: ResultAp<E, (T) -> R>
): ResultAp<E, R> where E: Throwable, E: Semigroup<E> = when(fn) {
    is Error -> when(this) {
        is Error -> Error(this.error + fn.error)
        is Success -> Error(fn.error)
    }
    is Success -> successMap(fn.value)
}