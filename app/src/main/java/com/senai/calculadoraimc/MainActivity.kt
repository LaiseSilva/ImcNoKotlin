package com.senai.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.Intent

//Criando a váriavel forma global e para ser iniciada só depois de ser atribuida um valor a ela

private lateinit var pesoEditText: EditText
private lateinit var alturaEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pegando os botões
        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)


        //Ativando o botão
        calcular.setOnClickListener() {
            //atribuindo valores a váriavel
            pesoEditText = findViewById(R.id.peso)
            alturaEditText = findViewById(R.id.altura)
            val classificacao = findViewById<TextView>(R.id.classificacao)


            //Verificação de campos válidos
            if (validarCampos()) {
                //Convertando os dados para double
                val altura = alturaEditText.text.toString().toDouble()
                val peso = pesoEditText.text.toString().toDouble()

                val imc = calcularImc(peso, altura)

                val intent =  Intent(this, ResultadoActivity::class.java)

                intent.putExtra("peso", peso.toString())
                intent.putExtra("altura", altura.toString())
                intent.putExtra("situacao", classificarImc(imc))

                startActivity(intent)



                //Realização do cálculo e classificação

               // classificacao.text = classificarImc(imc)
            }

        }
        sair.setOnClickListener() {
            finish()
        }


    }

    //Função para validar os campos
    private fun validarCampos(): Boolean {
        var noError = true

        if (alturaEditText.text.isBlank()) {
            alturaEditText.setError("Por favor digite a altura")
            noError = false
        }

        if (pesoEditText.text.isBlank()){
            pesoEditText.setError("Por favor digite seu peso")
            noError = false
        }

        return noError
    }


}