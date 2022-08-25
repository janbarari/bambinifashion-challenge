import org.gradle.api.artifacts.VersionCatalog

@Suppress("UnstableApiUsage")
fun VersionCatalog.getDependency(alias: String): String {
    val dep = findDependency(alias).get().get()
    return "${dep.module.group}:${dep.module.name}:${dep.versionConstraint.displayName}"
}

@Suppress("UnstableApiUsage")
fun VersionCatalog.getVersion(alias: String): String {
    return findVersion(alias).get().displayName
}

@Suppress("UnstableApiUsage")
fun VersionCatalog.getBundle(alias: String): List<String> {
    val result = mutableListOf<String>()
    findBundle(alias).get().get().forEach { dep ->
        result.add("${dep.module.group}:${dep.module.name}:${dep.versionConstraint.displayName}")
    }
    return result
}
