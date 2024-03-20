pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "kotlin functional programing"
include(":app")
include(":fundamentals")
include(":ExpressionEvaluationLaziness")
include(":Higher Order Function")
include(":Immuttability and Recursion")
include(":Functional Data Structure")
include(":Composition")
include(":Data Type")
include(":Algebraic Data Types")
include(":Functors")
include(":Monoids")
include(":Monads")
include(":Exception Handling")
