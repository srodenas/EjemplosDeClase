package com.example.tema1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() , OnClickListener{

    private lateinit var btnGreet : Button
    private lateinit var txtGreet: TextView
    private lateinit var btnGreetClass : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGreet= findViewById(R.id.btn_greet)
        btnGreetClass = findViewById(R.id.btn_greet_to_class)
        txtGreet = findViewById(R.id.txt_greet)
        initEvent()
    }

    private fun initEvent() {
        /*
        Ésta será la forma más eficaz de tratar los eventos. Como clase anónima utilizando para ello
        las lambda. Una clase anónima que implemente directamente de OnClickListener, es el mismo evento.
         */
        btnGreet.setOnClickListener{
            Toast.makeText(this, "Hola Santi!!!!", Toast.LENGTH_LONG).show()
            txtGreet.text="Hola santi!!!!"
        }
        /*
        Aquí utilizamos la forma de implementar la interfaz OnClickListener. En este caso, el objeto que acepta
        debe implementar de la interfaz OnClickListener y en este caso es el mismo Activity.
         */
        btnGreetClass.setOnClickListener(this)

    }

    /*
    La tercera forma de hacerlo es implementando el método que definimos en la propia interfaz. Es la forma
    más sencilla, pero no quire decir que sea la más utilizada.
     */
    fun onDontGreet(view: View){
        if (view.id == R.id.btn_dont_greet) {//podría quitarlo, porque sólo lo referencia un sólo botón desde la interfaz
            Toast.makeText(this, "No quiero saludar a Santi!!!!", Toast.LENGTH_LONG).show()
            txtGreet.text = "No quiero saludar a Santi!!!!"
        }
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_greet_to_class){
            Toast.makeText(this, "Os saludo, Clase PMDM 23/24", Toast.LENGTH_LONG).show()
            txtGreet.text = "Os saludo, Clase PMDM 23/24!!!!"
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Se llama después de onCreate. Muestro la pantalla. El usuario aún no puede interaccionar")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "El usuario ya puede interaccionar con la pantalla")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Pierdo el foco de la pantalla. Boton home")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Vuelvo a estar visible para el usaurio.")
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Dejo de estar visible para el usuario. Otra App, S.O.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "La actividad muere.")
    }



}