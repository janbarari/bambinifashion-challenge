enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "BambiniFashion"

include(":app")

include(":home")
include(":designers")
include(":bag")
include(":search")
include(":menu")

include(":database")
include(":network")
include(":datastore")
include(":architecture")
include(":designsystem")
