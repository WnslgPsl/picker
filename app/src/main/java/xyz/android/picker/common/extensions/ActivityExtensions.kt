package xyz.android.picker.common.extensions

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(@IdRes frameId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(frameId, fragment).commit()
}

fun AppCompatActivity.replaceFragmentWithBackStack(@IdRes frameId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(frameId, fragment)
        .addToBackStack(null)
        .commit()
}