package com.jp.customsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import com.jp.customsnackbar.databinding.ActivityMainBinding
import com.jp.customsnackbarlibrary.CustomSnackBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(activityMainBinding.root)


        button.setOnClickListener {
            CustomSnackBar.make(
                activityMainBinding.root,
                "Hello",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}