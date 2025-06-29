package com.detribes.koklin_lesson

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SixthTaskPrefs<T>(
    private val prefs: SharedPreferences,
    private val key: String,
    private val defaultValue: T
) : ReadWriteProperty<Any?, T> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return when (defaultValue) {
            is Int -> prefs.getInt(key, defaultValue)
            is Boolean -> prefs.getBoolean(key, defaultValue)
            is Float -> prefs.getFloat(key, defaultValue)
            is Long -> prefs.getLong(key, defaultValue)
            is String -> prefs.getString(key, defaultValue) ?: defaultValue
            else -> throw IllegalArgumentException("Unsupported type: ${defaultValue!!::class}")
        } as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        with(prefs.edit()) {
            when (value) {
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                is String -> putString(key, value)
                else -> throw IllegalArgumentException("Unsupported type: ${value!!::class}")
            }
            apply()
        }
    }
}