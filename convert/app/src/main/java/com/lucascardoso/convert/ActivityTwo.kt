package com.lucascardoso.convert

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_two.*
import android.widget.Spinner
import android.widget.AdapterView






class ActivityTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val ouroReal = 168
        val ouroDollar = 42
        val rubiReal = 3000
        val rubiDollar = 750
        val diamanteReal = 700
        val diamanteDollar = 175

        val moedas = arrayOf("Real", "Dollar")
        val spinner = findViewById<Spinner>(R.id.spinner)

        if (spinner != null) {
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, moedas)
            spinner.adapter = arrayAdapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(
                        this@ActivityTwo,
                        getString(R.string.selected_item) + " " + moedas[position],
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                }
            }
        }

        sbValorTwo.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valor_two.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //
        btn_calc_two.setOnClickListener() {
            if (rb_ouro.isChecked) {

                if (spinner.selectedItem.equals("Real")) {

                    var valorOuro = valor_two.text.toString().toFloat() * ouroReal
                    val conv = String.format("%.2f", valorOuro)
                    result_two.text = "${valor_two.text} gramas de ouro valem $conv reais"
                } else {

                    var valorOuroDollar = valor_two.text.toString().toFloat() * ouroDollar
                    val conv = String.format("%.2f", valorOuroDollar)
                    result_two.text = "${valor_two.text} gramas de ouro valem $conv dolares"
                }

            } else if (rb_rubi.isChecked) {

                if (spinner.selectedItem.equals("Real")) {

                    var valorRubi = valor_two.text.toString().toFloat() * rubiReal
                    val conv = String.format("%.2f", valorRubi)
                    result_two.text = "${valor_two.text} gramas de rubi valem $conv reais"

                } else {
                    var valorRubiDollar = valor_two.text.toString().toFloat() * rubiDollar
                    val conv = String.format("%.2f", valorRubiDollar)
                    result_two.text = "${valor_two.text} gramas de rubi valem $conv dolares"
                }

            } else if (rb_diamante.isChecked) {

                if (spinner.selectedItem.equals("Real")) {
                    var valorDiamante = valor_two.text.toString().toFloat() * diamanteReal
                    val conv = String.format("%.2f", valorDiamante)
                    result_two.text = "${valor_two.text} gramas de diamante valem $conv reais"
                } else {
                    var valorDiamanteDollar = valor_two.text.toString().toFloat() * diamanteDollar
                    val conv = String.format("%.2f", valorDiamanteDollar)
                    result_two.text = "${valor_two.text} gramas de diamante valem $conv dolares"
                }
            } else {

                result_two.text = "Favor selecionar um valor para conversão"

            }
        }
    }
}
