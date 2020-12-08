package com.mahendra.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_produk.*

class ProdukActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PRODUK = "extra_produk"
        const val EXTRA_BERAT = "extra_berat"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk)

        txt_nama.text = intent.getStringExtra(EXTRA_PRODUK)
        txt_berat.text = intent.getStringExtra(EXTRA_BERAT)
        txt_detail.text = intent.getStringExtra(EXTRA_DETAIL)

        btn_back.setOnClickListener {
            val backItem = Intent(this@ProdukActivity, MainActivity::class.java)
            startActivity(backItem)
        }
    }
}