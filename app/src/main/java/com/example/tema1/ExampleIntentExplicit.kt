package com.example.tema1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExampleIntentExplicit : AppCompatActivity() {

    private lateinit var btnFirst : Button
    private lateinit var btnSecond : Button
    private lateinit var intent : Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_intent_explicit)
        initEvent()
    }

    private fun initEvent() {
        btnFirst = findViewById(R.id.button1)
        btnSecond = findViewById(R.id.button2)

        btnFirst.setOnClickListener{ view ->
            intent = Intent(this, FirstActivityIntentExplicit::class.java)
                .apply {
                    putExtra("name", "Santiago")
                }
            startActivity(intent)
        }

        btnSecond.setOnClickListener{ view ->
            intent = Intent(this, SecondActivityIntentExplicit::class.java)
                .apply {
                    putExtra("name", "Sonia")
                }
            startActivity(intent)
        }
    }
}