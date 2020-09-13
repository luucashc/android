package com.example.pagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RealizaCalculo extends AppCompatActivity {

    TextView view_name;
    TextView view_value;
    TextView view_hours;
    TextView view_salaryb;
    TextView view_ir;
    TextView view_inss;
    TextView view_fgts;
    TextView view_salaryl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realiza_calculo);

        view_name = findViewById(R.id.view_name);
        view_value = findViewById(R.id.view_value);
        view_hours = findViewById(R.id.view_hours);
        view_salaryb = findViewById(R.id.view_salaryb);
        view_ir = findViewById(R.id.view_ir);
        view_inss = findViewById(R.id.view_inss);
        view_fgts = findViewById(R.id.view_fgts);
        view_salaryl = findViewById(R.id.view_salaryl);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String name = bundle.getString("name", "");
        Float value = bundle.getFloat("value");
        Float hours = bundle.getFloat("number");

        Float result_ir = 0f;
        Float result_inss = 0f;

        view_name.setText("Nome: " + name);
        view_value.setText("Valor da hora: " + value);
        view_hours.setText("Horas trabalhadas: " + hours);

        Float result_salaryb = hours * value;

        view_salaryb.setText("Salario bruto: " + result_salaryb);

        /* Calculo do IR */

        if(result_salaryb <= 1372.81) {
            view_ir.setText("Ir: " + 0);
        }
        if(result_salaryb >= 1372.81 && result_salaryb <= 2743.25) {

            result_ir = (result_salaryb * 15)/100;

            view_ir.setText("Ir: " + result_ir);
        }
        if(result_salaryb >= 2743.25) {

            result_ir = (result_salaryb * 27.5f)/100;

            view_ir.setText("Ir: " + result_ir);
        }

        /* Calculo do INSS */

        if(result_salaryb <= 868.29) {

            result_inss = (result_salaryb * 8)/100;

            view_inss.setText("Inss: " + result_inss);
        }
        if(result_salaryb >= 868.29 && result_salaryb <= 1447.14) {

            result_inss = (result_salaryb * 9)/100;

            view_inss.setText("Inss: " + result_inss);
        }
        if(result_salaryb >= 1447.14 && result_salaryb <= 2894.28) {

            result_inss = (result_salaryb * 11)/100;

            view_inss.setText("Inss: " + result_inss);
        }
        if(result_salaryb >= 2894.28) {

            result_inss = result_salaryb - 318.37f;

            view_inss.setText("Inss: " + result_inss);
        }

        /* Calculo do FGTS */

        Float result_fgts = (result_salaryb * 8)/100;

        view_fgts.setText("FGTS: " + result_fgts);

        /* Calculo do salario liquido */

        Float result_salaryl = result_salaryb - result_ir - result_inss;

        view_salaryl.setText("Salario liquido: " + result_salaryl);
    }
}
