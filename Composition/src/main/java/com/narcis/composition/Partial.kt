package com.narcis.composition

fun interface Logger { // Logger interface with log operation
    fun log(msg: String)
}

fun interface Calculator { // calculator as an interface for the multiply operation
    fun multiply(a: Double, b: Double): Double
}

fun interface DB { // simulating a database for persisting a value
    fun save(result: Double)
}

fun interface CalculatorFactory { // as a factory method
    fun create(db: DB, logger: Logger): Calculator
}

val calculatorFactoryImpl = CalculatorFactory { db, logger -> // implementation of factory
    object : Calculator {
        override fun multiply(a: Double, b: Double): Double {
            val result = a * b
            db.save(result)
            logger.log("$a * $b = $result")
            return result
        }
    }
}

fun main() {
    val db = DB {
        println("Saving value: $it")
    }

    val simpleLogger = Logger {
        println("Logging $it")
    }

    val fileLogger = Logger {
        println("Logging on File: $it")
    }
    val calculator1 = calculatorFactoryImpl.create(db, simpleLogger)
    val calculator2 = calculatorFactoryImpl.create(db, fileLogger)

    println(calculator1.multiply(2.0, 3.0))
    println(calculator2.multiply(2.0, 3.0))


    val partialFactory = calculatorFactoryImpl::create.curry() // apply curry to the create function of calculatorFactoryImpl
    val partialFactoryWithDb = db pipe partialFactory
    val calculator12 = partialFactoryWithDb(simpleLogger)
    val calculator22 = partialFactoryWithDb(fileLogger)
    println(calculator12.multiply(2.0, 3.0))
    println(calculator22.multiply(2.0, 3.0))
}