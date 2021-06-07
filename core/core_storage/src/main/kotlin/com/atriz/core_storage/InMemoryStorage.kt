package com.atriz.core_storage

import java.util.concurrent.ConcurrentHashMap

class InMemoryStorage {

    private val cacheMap = ConcurrentHashMap<String, Any>()

    fun set(key: InMemoryKey, value: Any) {
        cacheMap[key.name] = value
    }

    fun <T> get(key: InMemoryKey, defaultValue: T): T {
        return get(key) ?: defaultValue
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: InMemoryKey): T {
        val value = cacheMap[key.name]
        if (value === null) {
            throw NullPointerException("value with key=${key.name} is null")
        }
        return value as T
    }

    fun isKeyExist(key: InMemoryKey) = cacheMap.containsKey(key.name)

    fun removeValue(key: InMemoryKey) {
        cacheMap.remove(key.name)
    }

    fun clear() {
        cacheMap.clear()
    }
}
