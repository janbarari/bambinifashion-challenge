import com.android.build.gradle.LibraryExtension
import extension.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionLibrary : Plugin<Project> {

    @Suppress("UnstableApiUsage")
    override fun apply(project: Project) {
        project.plugins.apply("com.android.library")
        project.plugins.apply("org.jetbrains.kotlin.android")

        project.extensions.configure<LibraryExtension> {
            compileSdk = 33
            defaultConfig.targetSdk = 33
            defaultConfig.minSdk = 25

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }

            buildFeatures {
                viewBinding = true
            }

        }

        project.dependencies.add(
            "testImplementation", project.versionCatalog().getDependency("test-junit")
        )

    }

}
