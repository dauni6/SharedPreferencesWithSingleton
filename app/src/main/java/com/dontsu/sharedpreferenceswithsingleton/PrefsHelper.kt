package com.dontsu.sharedpreferenceswithsingleton

import android.content.Context
import android.content.SharedPreferences

class PrefsHelper {

    companion object {
        private var prefs: SharedPreferences? = null
        private var prefsHelper: PrefsHelper? = null
        val PREF_NAME = "pref" //이 이름으로 xml파일이 만들어짐

        const val Food1 = "Food1"
        const val Food2 = "Food2"
        const val Food3 = "Food3"
        const val Food4 = "Food4"

        fun getInstance(context: Context): PrefsHelper? {
        if (prefsHelper == null) {
            prefsHelper = PrefsHelper()
        }
        if (prefs == null) {
            prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }

        return prefsHelper
    }
}

    fun putString(key: String, value: String) {
        prefs!!.edit().apply {
            putString(key, value)
        }.apply() //반드시 Editor.apply() 해줘야 데이터가 저장된다.
    }

    fun getString(key: String, defValue: String): String {
        return prefs?.getString(key, defValue)!!
    }

}
