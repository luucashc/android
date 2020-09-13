package com.lucascardoso.convert

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dolar = 3.86
        val euro = 4.38
        val ienes = 0.03

            //open activity two
        val btnOpen : Button =  findViewById(R.id.btn_new_activity)
        btnOpen.setOnClickListener {
            val intent = Intent(this, ActivityTwo :: class.java)
            startActivity(intent)
        }

            //seekbar
        sbValor.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valor.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })


            //
        btn_result.setOnClickListener() {
            if(rbDolar.isChecked) {

                valor.hint = "Valor: $"
                var valorDolar = valor.text.toString().toFloat() * dolar
                val conv = String.format("%.2f", valorDolar)
                txt_result.text = "$${valor.text} equivalem a R$$conv"

            }else if (rbEuro.isChecked) {

                valor.hint = "Valor: €"
                var valorEuro = valor.text.toString().toFloat() * euro
                val conv = String.format("%.2f", valorEuro)
                txt_result.text = "€${valor.text} equivalem a R$$conv"

            }else if (rbIenes.isChecked) {

                valor.hint = "Valor: ¥"
                var valorIenes = valor.text.toString().toFloat() * ienes
                val conv = String.format("%.2f", valorIenes)
                txt_result.text = "¥${valor.text} equivalem a R$$conv"

            }else {

                txt_result.text = "Favor selecionar uma moeda para que a conversão seja realizada"

            }
        }
    }
}
