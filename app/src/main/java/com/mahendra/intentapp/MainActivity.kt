package com.mahendra.intentapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mahendra.intentapp.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_profile.setOnClickListener {
            val profile = Intent(this@MainActivity,ProfilActivity::class.java)
            startActivity(profile)
        }

        btn_produk.setOnClickListener{
            val dataIntent = Intent(this@MainActivity,ProdukActivity::class.java)
            dataIntent.putExtra(ProdukActivity.EXTRA_PRODUK, "Laptop HP 14t")
            dataIntent.putExtra(ProdukActivity.EXTRA_BERAT, " 1,47kg")
            dataIntent.putExtra(ProdukActivity.EXTRA_DETAIL, "Layar IPS dengan BrightView WLED backlight 14 inci resolusi full HD 1920 x 1080 piksel, MicroEdge bezel\n" +
                    "Prosesor AMD Ryzen 5 3500U quad-core dengan kecepatan 2,1GHz Turbo maksimal 3,7GHz\n" +
                    "Chipset AMD\n" +
                    "Grafis AMD Radeon RX Vega 8 iGPU\n" +
                    "Memori RAM 8GB DDR4 2400MHz, upgradeable\n" +
                    "Storage SSD 512GB PCIe NVMe M.2\n" +
                    "Konektifitas 10/100/1000 GbE LAN, WiFi 802.11ac (1x1), Bluetooth 4.2 Combo, Port USB 3.1 Gen1, Port USB 3.1 Gen1 Type-C (Data transfer only, 5 Gb/s signaling rate), Port HDMI, card reader, port combo audio\n" +
                    "Audio dual speaker\n" +
                    "Kamera HP TrueVision HD Camera with integrated digital microphone\n" +
                    "Baterai 3-cell (45 WHr) Li-ion\n" +
                    "Sistem Microsoft Windows 10 Home x64 original + Microsoft Office Home &amp; Student 2019")
            startActivity(dataIntent)
        }

        btn_intent_parcelable.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity, ParcleActivity::class.java)
            val user = User("Laptop HP 14t", " 1,47kg", "Layar IPS dengan BrightView WLED backlight 14 inci resolusi full HD 1920 x 1080 piksel, MicroEdge bezel\n" +
                    "Prosesor AMD Ryzen 5 3500U quad-core dengan kecepatan 2,1GHz Turbo maksimal 3,7GHz\n" +
                    "Chipset AMD\n" +
                    "Grafis AMD Radeon RX Vega 8 iGPU\n" +
                    "Memori RAM 8GB DDR4 2400MHz, upgradeable\n" +
                    "Storage SSD 512GB PCIe NVMe M.2\n" +
                    "Konektifitas 10/100/1000 GbE LAN, WiFi 802.11ac (1x1), Bluetooth 4.2 Combo, Port USB 3.1 Gen1, Port USB 3.1 Gen1 Type-C (Data transfer only, 5 Gb/s signaling rate), Port HDMI, card reader, port combo audio\n" +
                    "Audio dual speaker\n" +
                    "Kamera HP TrueVision HD Camera with integrated digital microphone\n" +
                    "Baterai 3-cell (45 WHr) Li-ion\n" +
                    "Sistem Microsoft Windows 10 Home x64 original + Microsoft Office Home &amp; Student 2019")
            parcelIntent.putExtra(ParcleActivity.EXTRA_USER, user)
            startActivity(parcelIntent)
        }

        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "0895365280807"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body", "Haii")
            startActivity(intent)
        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_result.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }
}