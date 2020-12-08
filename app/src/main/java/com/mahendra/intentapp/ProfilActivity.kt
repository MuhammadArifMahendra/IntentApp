package com.mahendra.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class ProfilActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_profil)

            val btn_back = findViewById<Button>(R.id.btn_back)
            btn_back.setOnClickListener {
                val backIntent = Intent(this@ProfilActivity, MainActivity::class.java )
                startActivity(backIntent)
            }

        }
}