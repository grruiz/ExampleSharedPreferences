package com.rafaelgalvezruiz.examplesharedpreferences

import android.content.Context

class Prefs(val context: Context) {
    val SHARED_NAME = "MyDataBase"
    val SHARED_USER_NAME = "username"
    val SHARED_VIP = "vip"
    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    //Guardamos los datos que nos pasa el usuario
    fun saveName(name: String) {
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveVIP(vip: Boolean) {
        storage.edit().putBoolean(SHARED_VIP, vip).apply()
    }

    //Recuperamos los datos que nos pide el usuario
    fun getName(): String {
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getVIP(): Boolean {
        return storage.getBoolean(SHARED_VIP, false)!!
    }

    fun wipe(){
        storage.edit().clear().apply()
    }
}