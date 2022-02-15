package com.senai.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//Criando a váriavel forma global e para ser iniciada só depois de ser atribuida um valor a ela

private lateinit var pesoEditText: EditText
private lateinit var alturaEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pegando os botões
        var calcular = findViewById<Button>(R.id.calcular)
        var sair = findViewById<Button>(R.id.sair)


        //Ativando o botão
        calcular.setOnClickListener() {
            //atribuindo valores a váriavel
            pesoEditText = findViewById(R.id.peso)
            alturaEditText = findViewById(R.id.altura)
            val classificacao = findViewById<TextView>(R.id.classificacao)


            //Verificação de campos válidos
            if (validarCampos()) {
                //Convertando os dados para double
                var altura = alturaEditText.text.toString().toDouble()
                var peso = pesoEditText.text.toString().toDouble()



                //Realização do cálculo e classificação
                var imc = calcularImc(peso, altura)
                classificacao.text = classificarImc(imc)
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