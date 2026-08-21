# XR Native Android Settings

Package:

    com.contextsmali.xrandroidnativesettings

## Build configuration

- Android Gradle Plugin: 9.3.0
- Gradle: 9.5.0
- Kotlin: 2.3.21
- Compile SDK: 37
- Target SDK: 36
- Minimum SDK: 23
- Build Tools: 36.0.0

## Local requirements

## GitHub Actions

Every push to `main` or `master` triggers the build.

You can also manually start it from:

GitHub -> Actions -> Build Android APK -> Run workflow

The debug APK is created at:

    app/build/outputs/apk/debug/app-debug.apk

The APK is uploaded as a GitHub Actions artifact.

Download it from:

GitHub -> Actions -> Build Android APK -> android-apk

## Local build

Windows:

    gradlew.bat assembleDebug

Linux/macOS:

    ./gradlew assembleDebug
