package com.example.pagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text_name;
    EditText number_hours;
    EditText value_hours;
    Button btn_calcula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_name = findViewById(R.id.text_name);
        number_hours = findViewById(R.id.number_hours);
        value_hours = findViewById(R.id.value_hours);
        btn_calcula = findViewById(R.id.btn_calcula);

        btn_calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(text_name.getText().toString().isEmpty() ||
                        number_hours.getText().toString().isEmpty() ||
                        value_hours.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else {

                    String nome = text_name.getText().toString();
                    Float number = Float.parseFloat(number_hours.getText().toString());
                    Float value = Float.parseFloat(value_hours.getText().toString());

                    // Bundle para armazenar dados que irão para outra activity
                    Bundle bundle = new Bundle();
                    bundle.putString("name", nome);
                    bundle.putFloat("number", number);
                    bundle.putFloat("value", value);

                    Intent intent = new Intent(MainActivity.this, RealizaCalculo.class);
                    intent.putExtras(bundle);

                    // método para iniciar outra activity
                    startActivity(intent);

                }

            }
        });

    }
}
