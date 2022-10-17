package br.edu.infnet.app_quiz_assessment.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.app_quiz_assessment.R

fun AppCompatActivity.getSharedPrefs(): SharedPreferences {
    return getSharedPreferences(
        getString(R.string.my_preference_name),
        Context.MODE_PRIVATE
    )
}

fun AppCompatActivity.saveLoginToSharedPrefs(value: String) {
    val sharedPrefs = getSharedPrefs()
    val editor = sharedPrefs.edit()
    editor.putString(
        getString(R.string.name_key),
        value
    )
    editor.apply()
}

fun AppCompatActivity.getLoginFromSharedPrefs(): String {
    val sharedPrefs = getSharedPrefs()
    return sharedPrefs.getString(
        getString(R.string.name_key),
        ""
    ) ?: ""
}