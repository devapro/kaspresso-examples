plugins {
    id("com.android.test")
    id("kotlin-android")
}

android {
    namespace = "com.kaspersky.ui.tests"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    targetProjectPath = ":app"
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))

    implementation("junit:junit:4.13.2")
    implementation("androidx.test.ext:junit:1.1.5")
    implementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.test:runner:1.5.2")
    implementation("androidx.test:rules:1.5.0")
    // Kotlin extensions for androidx.test.ext.junit
    implementation("androidx.test.ext:junit-ktx:1.1.5")


    implementation("androidx.compose.ui:ui-test-android:1.6.0")
    implementation("androidx.compose.ui:ui-test-junit4:1.6.0")
    implementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.fragment:fragment-testing:1.6.2")
    implementation("androidx.test.ext:junit-ktx:1.1.5")

    implementation("com.kaspersky.android-components:kaspresso:1.5.3")

    implementation("com.kaspersky.android-components:kaspresso-compose-support:1.5.3")

    implementation("androidx.compose.ui:ui-test:1.6.0")
}