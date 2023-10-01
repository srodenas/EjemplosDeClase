package com.example.tema1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat


class IntentCallPhone : AppCompatActivity() {
    private lateinit var btnCallPhone : Button
    companion object{
        const val PHONE = "953123456"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_call_phone)
        initEvent()
    }

    private fun initEvent() {
        btnCallPhone = findViewById(R.id.btn_call)
        btnCallPhone.setOnClickListener{
           requestPermissions()
        }
    }



   //Santi 2023/2024
    private fun requestPermissions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){  //Tenemos que ver si pedimos permisos
            if (PermissionPhone()){  //Si ya concedimos los permisos
                call()  //Realizamos la llamada.
            }
            else{ //Tenemos que solicitar al usuario los permisos.
                requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
            }
        }else{
            call() //No es necesario solicitar permisos, ya que es una API < 23
        }
    }



    //Devuelve true si el usuario permitión los permisos de llamada.
    private fun PermissionPhone(): Boolean =
        ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED


    private fun call() {
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:$PHONE")  //No me complico, es el mismo teléfono.
        }
        startActivity(intent)
    }


    //llamada de orden superior.
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()) {
            isGranted->
                if (isGranted) {
                    call()
                }
                else {
                    Toast.makeText(this, "Necesitas habilitar los permisos", Toast.LENGTH_LONG).show()
                }

        }






    /*
        //API 23 - M
        private fun call() {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$PHONE")
            }



           if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)!=
               PackageManager.PERMISSION_GRANTED){
               ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1)

           }else{
               startActivity(intent)
           }

        }
    */

}