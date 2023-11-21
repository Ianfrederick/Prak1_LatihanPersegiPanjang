package com.example.prak1_latihanpersegipanjang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var p: EditText
    private lateinit var l: EditText
    private lateinit var k: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        p = findViewById(R.id.panjang)
        l = findViewById(R.id.lebar)
        k = findViewById(R.id.keliling)
        p.requestFocus()

        val hitung : Button = findViewById(R.id.btn_hitung)
        hitung.setOnClickListener{
            if(p.length()==0 && l.length()==0)
                Toast.makeText(this, "Panjang dan lebar belum diisi!", Toast.LENGTH_LONG).show()
            else if(p.length()==0)
                Toast.makeText(this, "Panjang belum diisi", Toast.LENGTH_LONG).show()
            else if(l.length()==0)
                Toast.makeText(this, "Lebar belum diisi!", Toast.LENGTH_LONG).show()
            else{
                val p        : Double = p.text.toString().toDouble()
                val l        : Double = l.text.toString().toDouble()
                val hs       : Double = 2*(p+l)
                k.visibility = View.VISIBLE
                k.setText("%.2f".format(hs))
            }
        }
    }

    private fun kelilingpersegipanjang(p: Double, l: Double): Double {
        return 2*(p+l)
    }

    fun hapus(view: View){
        p.text.clear()
        l.text.clear()
        k.text.clear()
    }
}