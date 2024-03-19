package com

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.learning.mymoviecatalog.MainActivity
import com.learning.mymoviecatalog.R


class Splaschscreen : AppCompatActivity() {

    private val splashTimeOut: Long = 3000 // Durasi tampilan splash (dalam milidetik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splaschscreen) // Layout splash screen

        Handler().postDelayed({
            // Kode ini akan dijalankan setelah tampilan splashTimeOut
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup SplashScreenActivity agar tidak dapat dikembali
        }, splashTimeOut)
    }
}