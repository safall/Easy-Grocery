Easy Grocery is a Compose Multiplatform project targeting Android, iOS. 

### Language and Tools Used
 - Kotlin
 - Kotlin Corooutines
 - Kotlinx Serialization
 - Koin
 - Jetpack Compose
 - Multiplatform Settings

### Getting Started


* [/iosApp](./iosApp/iosApp) iOS App Entry point
* [/composeApp](./composeApp) Android App Entry point

  - [commonMain](./composeApp/src/commonMain/kotlin) - All common code/logics shared between android + iOS
  - [iosMain](./composeApp/src/iosMain/kotlin) - iOS platform specific codes 
  - [androidMain](./composeApp/src/androidMain/kotlin) - Android platform specific codes 


### Build and Run Android + iOS Application

* Running Android App:
  - Download IntelliJ Idea / Ultimate
  - Install Kotlin Multiplatform Plugin
  - Open the cloned project

   
* Running iOS App:
  - Download Xcode
  - Clone the repository
  - Open this [/iosApp](./iosApp) directory on the root project path
    
---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
