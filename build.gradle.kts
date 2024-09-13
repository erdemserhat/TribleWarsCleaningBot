plugins {
    kotlin("jvm") version "2.0.0"
    application
}

group = "com.erdemserhat"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.seleniumhq.selenium:selenium-java:4.9.0")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.9.0")
    implementation("org.slf4j:slf4j-simple:2.0.0")
    // Kotlin Coroutines Bağımlılıkları
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    //implementation("org.opencv:opencv:4.5.3") // OpenCV'nin uygun sürümünü ekleyin

}



application {
    mainClass.set("com.erdemserhat.MainKt") // Ana sınıfınızın tam adını buraya yazın
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.erdemserhat.MainKt"
    }
    from(sourceSets.main.get().output)
    from(configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE // Çakışan dosyaları dışla
}