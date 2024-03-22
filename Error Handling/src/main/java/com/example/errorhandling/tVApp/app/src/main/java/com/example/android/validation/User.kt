package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.validation

import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.Error
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.ResultAp
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.Success
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.ap
import com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.raywenderlich.fp.lib.curry

data class User(
    val id: Int,
    val name: String,
    val email: String
)

class ValidationException(msg: String) : Exception(msg)

fun validateName(name: String): ResultAp<ValidationException, String> = if (name.length > 4) {
    Success(name)
} else {
    Error(ValidationException("invalid name"))
}

fun validateEmail(email: String): ResultAp<ValidationException, String> = if (email.contains("@")) {
    Success(email)
} else {
    Error(ValidationException("Invalid email"))
}

fun main() {
    val userBuilder = ::User.curry()
    val userApplicative = ResultAp.success(userBuilder)
    val idAp = ResultAp.success(1)
    validateEmail("max@maxcaril.it")
        .ap(validateName("").ap(idAp.ap(userApplicative)))
}