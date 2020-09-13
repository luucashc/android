package com.example.alcoolgasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcula.setOnClickListener {
            if(numGasolina.text.toString().isNotEmpty() && numAlcool.text.toString().isNotEmpty() ){
                calcular()
            }else{
                val erro = "Por Favor, insira valores válidos"
                txtResultado.text = erro
            }
        }
    }
    private fun calcular() {
        var mensagem = ""
        if (numGasolina.text.toString().toFloat() > 0 && numAlcool.text.toString().toFloat() > 0){
           val comparacao = numGasolina.text.toString().toFloat() * 0.70
            if(comparacao < numAlcool.text.toString().toFloat()) mensagem = "Melhor colocar Gasolina, o valor do alcool deveria ser no maximo  " +
                        comparacao
            else mensagem = "Melhor colocar Alcool, o valor do alcool deveria ser no maximo  " +
                        comparacao
        }else mensagem = "Somente valores acima de 0"


        txtResultado.text = mensagem
    }
}