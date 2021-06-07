package com.atriz.core_presentation.activity

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val navController: NavController

    fun navigate(directions: NavDirections) {
        navController.navigate(directions)
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
