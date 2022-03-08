package com.senai.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Dentro do schedule é definido por milisegundos qunto tempo ficará na tela
        Timer().schedule(2000){ abrirMain()}
    }

    private fun abrirMain(){
        var intent = Intent( this, MainActivity::class.java)

        //abre a activy
        startActivity(intent)

        //fecha a activy para não ficar para sempre na tela
        finish()
    }


}