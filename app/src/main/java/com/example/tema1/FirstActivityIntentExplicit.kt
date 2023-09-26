package com.example.tema1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


/*
Este ejemplo, lo haremos con el plugin kotlin-android-extensions"
 */
class FirstActivityIntentExplicit : AppCompatActivity() {
    private lateinit var btnReturn : Button
    private lateinit var tvName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_intent_explicit)
        initEvent()
        showData()

    }

    private fun showData() {
        val name = getIntent().getStringExtra("name")
        tvName.text= name
        Toast.makeText(this, "Datos mostrados con éxito", Toast.LENGTH_LONG).show()
    }

    private fun initEvent() {
        btnReturn = findViewById(R.id.btn_return1)
        tvName = findViewById(R.id.tv_first)
        btnReturn.setOnClickListener{
           val intentReturn =  Intent(this, ExampleIntentExplicit::class.java)
            startActivity(intentReturn)
        }
    }
}