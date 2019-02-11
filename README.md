# Overview of this fork

This project is a fork of the fasterXML's jackson-dataformat-xml project. This adds support for XmlPull parser which is similar to the java Stax api.

By adding this support, it is possible to use this library in Android.

Currently supported only on 2.9.6 version. Checkout branch jackson-dataformat-xml-2.9.6-XmlPull and build the jar.

3x version not supported as it uses java 1.8 features that are not available in Android.

You need to manually download and place dependent jars (see below gradle sample for files required under lib folder)

Your app.gradle should look like the following:

```gradle
apply plugin: 'com.android.application'

android {
    compileSdkVersion 27
    defaultConfig {
        applicationId "com.example.testjacksonxml"
        minSdkVersion 21
        targetSdkVersion 27
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:27.1.1'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'com.android.support:design:27.1.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    implementation files('libs/jackson-annotations-2.9.6.jar')
    implementation files('libs/jackson-core-2.9.6.jar')
    implementation files('libs/jackson-databind-2.9.6.jar')
    implementation files('libs/jackson-dataformat-xml-2.9.6.jar')
    implementation files('libs/jackson-module-jaxb-annotations-2.9.6.jar')
    implementation files('libs/slf4j-api-1.7.13.jar')
}

```
