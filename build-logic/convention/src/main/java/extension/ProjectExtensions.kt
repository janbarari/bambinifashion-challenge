import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler

@Suppress("UnstableApiUsage")
fun Project.versionCatalog(name: String = "libs"): VersionCatalog {
    return (extensions.getByType(VersionCatalogsExtension::class.java)).named(name)
}

fun DependencyHandler.implementation(dependencyNotation: String) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.debugImplementation(dependencyNotation: String) {
    add("debugImplementation", dependencyNotation)
}