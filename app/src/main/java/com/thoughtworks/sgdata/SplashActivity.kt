package com.thoughtworks.sgdata

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.thoughtworks.sgdata.feature.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(this.javaClass.name, "---------------------------- onCreate")
    }

    override fun onStart() {
        super.onStart()

        Log.w(this.javaClass.name, "---------------------------- onStart")
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({ showMainScreen() }, 1000)
        Log.e(this.javaClass.name, "---------------------------- onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.e(this.javaClass.name, "---------------------------- onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e(this.javaClass.name, "---------------------------- onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e(this.javaClass.name, "---------------------------- onDestroy")
    }

    private fun showMainScreen() {
        startActivity(
            Intent(this, MainActivity::class.java)
                .setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
                            or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            or Intent.FLAG_ACTIVITY_NO_ANIMATION
                )
        )
    }
}
