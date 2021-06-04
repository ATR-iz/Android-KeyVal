private object StorageVersions {
    const val CRYPTO = "1.0.0-beta01"
    const val ROOM = "2.2.6"
}

object StorageDependency {
    const val CRYPTO = "androidx.security:security-crypto:${StorageVersions.CRYPTO}"

    const val ROOM = "androidx.room:room-runtime:${StorageVersions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${StorageVersions.ROOM}"
    const val ROOM_EXTENSIONS = "androidx.room:room-ktx:${StorageVersions.ROOM}"
}
