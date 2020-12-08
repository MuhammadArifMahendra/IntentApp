package com.mahendra.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahendra.intentapp.model.User
import kotlinx.android.synthetic.main.activity_produk.*

class ParcleActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcle)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        txt_nama.text = user.produk
        txt_berat.text = user.berat
        txt_detail.text = user.detail

        btn_back.setOnClickListener {
            val backItem = Intent(this@ParcleActivity, MainActivity::class.java)
            startActivity(backItem)
        }
    }
}
