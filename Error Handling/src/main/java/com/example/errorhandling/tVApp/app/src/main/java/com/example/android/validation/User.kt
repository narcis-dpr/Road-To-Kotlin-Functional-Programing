package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.validation

import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.Error
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.ResultAp
import com.example.errorhandling.tVApp.app.src.main.java.com.example.android.applicative.Success

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
