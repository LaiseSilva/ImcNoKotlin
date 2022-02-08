package com.senai.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var calcular = findViewById<Button>(R.id.calcular)
        var sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener(){
            var altura = findViewById<EditText>(R.id.altura).text.toString().toDouble()
            var peso = findViewById<EditText>(R.id.peso).text.toString().toDouble()
            var imc = peso/(altura*altura)

            val classificacao = findViewById<TextView>(R.id.classificacao)
            val valorImc = findViewById<TextView>(R.id.valorimc)

            if (imc < 18.5){
                classificacao.text = "Abaixo do peso"
                valorImc.text = "\nSeu imc é: $imc"

            }else if(imc < 24.9){
                classificacao.text = "Peso normal"
                valorImc.text = "Seu imc é: $imc"
            }else if(imc < 29.9){
                classificacao.text = "Sobrepeso"
                valorImc.text = "\nSeu imc é: $imc"
            }else if (imc < 34.9){
                classificacao.text = "Obesidade grau I"
                valorImc.text = "\nSeu imc é: $imc"
            }else if(imc < 39.9){
                classificacao.text = "Obesidade grau II"
                valorImc.text = "\nSeu imc é: $imc"
            }else{
                classificacao.text ="Obesidade grau III"
                valorImc.text = "\nSeu imc é: $imc"
            }
        }
        sair.setOnClickListener(){
            finish()
        }


    }
}