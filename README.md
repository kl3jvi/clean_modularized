![clean_modularized](https://raw.githubusercontent.com/kl3jvi/clean_modularized/master/assets/header.png)<br>

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.6.10-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-4-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-7-blue?style=flat)](https://gradle.org)

This is a sample project that presents a modern approach to [Android](https://en.wikipedia.org/wiki/Android_(operating_system)) application development.

The goal of the project is to combine popular libraries/tools and demonstrate best developement practices by utilizing up to date tech-stack and presenting modern Android application [Architecture](#architecture) that is modular, scalable, maintainable, and testable. This application may look simple,
but it has all the pieces that will provide the rock-solid foundation for the larger app suitable for bigger teams
and long [application lifecycle](https://en.wikipedia.org/wiki/Application_lifecycle_management).

This project is being maintained to match industry standards. 

## Project characteristics and tech-stack

<img src="https://raw.githubusercontent.com/kl3jvi/clean_modularized/master/assets/Screenshot_20220318_171359.png" width="336" align="right" hspace="20">

This project takes advantage of best practices, many popular libraries and tools in the Android ecosystem. Most of the libraries are in the stable version unless there is a good reason to use non-stable dependency.

* Tech-stack
    * [100% Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - in-app navigation
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
        * [Room](https://developer.android.com/jetpack/androidx/releases/room) - store offline cache
    * [Koin](https://insert-koin.io/) - dependency injection
    * [Coil](https://github.com/coil-kt/coil) - image loading library
    * [Lottie](http://airbnb.io/lottie) - animation library
    * [Stetho](http://facebook.github.io/stetho/) - application debugging
* Modern Architecture
    * Clean Architecture (at feature module level)
    * Single activity architecture using [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)
    * MVVM + MVI (presentation layer)
    * [Dynamic feature modules](https://developer.android.com/studio/projects/dynamic-delivery)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation))
    * [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions
* CI
  * [GitHub Actions](https://github.com/features/actions)
  * Automatic PR verification including tests, linters and 3rd online tools
* Testing
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit 5](https://junit.org/junit5/) via
    [android-junit5](https://github.com/mannodermaus/android-junit5))
    * [UT Tests](https://en.wikipedia.org/wiki/Graphical_user_interface_testing) ([Espresso](https://developer.android.com/training/testing/espresso))
    * [Mockk](https://mockk.io/) - mocking framework
    * [Kluent](https://github.com/MarkusAmshove/Kluent) - assertion framework
* UI
    * [Material design](https://material.io/design)
    * Reactive UI
* Static analysis tools
    * [Ktlint](https://github.com/pinterest/ktlint) - validate code formating
    * [Detekt](https://github.com/arturbosch/detekt#with-gradle) - verify complexity look for and code smell
* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    * Custom tasks
    * Plugins ([SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args),
    [android-junit5](https://github.com/mannodermaus/android-junit5))
    * [Dependency locks](https://docs.gradle.org/current/userguide/dependency_locking.html)
    * [Versions catalog](https://docs.gradle.org/7.0-milestone-1/userguide/platforms.html)

## Architecture

Feature related code is placed inside one of the feature modules.
We can think about each feature as the reusable component, equivalent of [microservice](https://en.wikipedia.org/wiki/Microservices) or private library.

The modularized code-base approach provides few benefits:
- better [separation of concerns](https://en.wikipedia.org/wiki/Separation_of_concerns). Each module has a clear API., Feature related classes live in different modules and can't be referenced without explicit module dependency.
- features can be developed in parallel eg. by different teams
- each feature can be developed in isolation, independently from other features
- faster compile time

## Package Structures

```
com.kl3jvi.mvvm_template # Root Package
├─ app              
├─ buildSrc           
├─ feature_home
└──feature_favorites
```
