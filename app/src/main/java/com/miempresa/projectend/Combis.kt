package com.miempresa.projectend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_combis.*

class Combis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combis)

        val values = arrayOf(
            "SEGRAMPO",
            "COTUM",
            "COTAP",
            "CHARACATO"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, android.R.id.text1,
            values
        )
        lstDestinos.adapter = adapter
        lstDestinos.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val itemValue =
                    lstDestinos.getItemAtPosition(i) as String
                val intent = Intent(this@Combis, MapsActivity::class.java)
                intent.putExtra("destino", itemValue.toLowerCase())
                startActivity(intent)
            }
    }
}