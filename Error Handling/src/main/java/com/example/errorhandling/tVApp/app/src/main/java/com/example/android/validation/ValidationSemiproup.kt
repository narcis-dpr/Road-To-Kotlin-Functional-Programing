package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.validation

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