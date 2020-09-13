package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result_view;
    String text_view;
    float current_number = 0;
    float old_number = 0;
    String op = "";
    boolean typing = false;
    boolean separator = false;
    String modify_comma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            result_view = findViewById(R.id.result_view);

    }

    //
    public void btnNumber(View view){

        Button btnNumber = (Button)view;

        String number = btnNumber.getText().toString();

        text_view = result_view.getText().toString();

        if (!typing || text_view.equals("0")) {
            result_view.setText(number);

            if(!number.equals("0")) {
                typing = true;
            }
        } else {
            result_view.setText(text_view + number);
        }
    }

    //
    public void clean(View view){
        result_view.setText("0");
        current_number = 0;
        old_number = 0;
        typing = false;
        separator = false;
    }

    //
    public void btnOperation(View view){

//        Double resultSquareRoot;

        Button btnOp = (Button)view;

        if(btnOp.getText().equals(",") && !separator){
            separator = true;

            if (!typing) {
                result_view.setText("0,");
            } else {
                result_view.setText(result_view.getText().toString()+",");
            }

            typing = true;

        } else if (!btnOp.getText().equals(",")) {

            modify_comma = result_view.getText().toString().replace(',','.');

            current_number = Float.parseFloat(modify_comma);

            switch (btnOp.getId()){

                case R.id.addition_btn:

                    if(old_number == 0){
                        old_number = current_number;
                    }else{
                        old_number = current_number;
                    }

                    text_view = String.valueOf(old_number);

                    if(text_view.endsWith(".0")){
                        text_view = text_view.substring(0, text_view.length()-2);
                    }

                    modify_comma = text_view.replace('.',',');
                    result_view.setText(modify_comma);

                    op = "addition";

                    result_view.setText("0");
                    typing = false;
                    separator = false;

                    break;

                case R.id.subtraction_btn:

                    if(old_number == 0) {
                        old_number = current_number;
                    } else {
                        old_number = current_number;
                    }

                    text_view = String.valueOf(old_number);

                    if(text_view.endsWith(".0")){
                        text_view = text_view.substring(0, text_view.length()-2);
                    }

                    modify_comma = text_view.replace('.',',');
                    result_view.setText(modify_comma);

                    op = "subtraction";

                    result_view.setText("0");
                    typing = false;
                    separator = false;

                    break;

                case R.id.x_btn:

                    if(old_number == 0) {
                        old_number = current_number;
                    } else {
                        old_number = current_number;
                    }

                    text_view = String.valueOf(old_number);

                    if(text_view.endsWith(".0")){
                        text_view = text_view.substring(0, text_view.length()-2);
                    }

                    modify_comma = text_view.replace('.',',');
                    result_view.setText(modify_comma);

                    op = "x";

                    result_view.setText("0");
                    typing = false;
                    separator = false;

                    break;

                case R.id.division_btn:

                    if(old_number == 0) {
                        old_number = current_number;
                    } else {
                        old_number = current_number;
                    }

                    text_view = String.valueOf(old_number);

                    if(text_view.endsWith(".0")){
                        text_view = text_view.substring(0, text_view.length()-2);
                    }

                    modify_comma = text_view.replace('.',',');
                    result_view.setText(modify_comma);

                    op = "division";

                    result_view.setText("0");
                    typing = false;
                    separator = false;

                    break;

                case R.id.percentage_btn:

                    if(old_number == 0){
                        old_number = current_number;
                    }else{
                        old_number = current_number;
                    }

                    text_view = String.valueOf(old_number);

                    if(text_view.endsWith(".0")){
                        text_view = text_view.substring(0, text_view.length()-2);
                    }

                    modify_comma = text_view.replace('.',',');
                    result_view.setText(modify_comma);

                    op = "percentage";

                    result_view.setText("0");
                    typing = false;
                    separator = false;

                    break;

                case R.id.power_btn:

                    if(old_number == 0){
                        old_number = current_number;
                    }else{
                        old_number = current_number;
                    }

                    text_view = String.valueOf(old_number);

                    if(text_view.endsWith(".0")){
                        text_view = text_view.substring(0, text_view.length()-2);
                    }

                    modify_comma = text_view.replace('.',',');
                    result_view.setText(modify_comma);

                    op = "power";

                    result_view.setText("0");
                    typing = false;
                    separator = false;

                    break;

//                case R.id.squareRoot_btn:
//
//                    resultSquareRoot = Math.sqrt(old_number);
//
//                    old_number = 0;
//                    text_view = String.valueOf(resultSquareRoot);
//
//                    if(text_view.endsWith(".0")){
//                        text_view = text_view.substring(0, text_view.length()-2);
//                    }
//
//                    modify_comma = text_view.replace('.',',');
//                    result_view.setText(modify_comma);
//                    typing = false;
//                    separator = false;
//
//                    break;

                case R.id.equal_btn:

                    float result;

                    Double resultPower;

                    if(op.equals("addition")) {

                        result = old_number + current_number;
                        old_number = 0;
                        current_number = 0;
                        text_view = String.valueOf(result);

                        if(text_view.endsWith(".0")){
                            text_view = text_view.substring(0, text_view.length()-2);
                        }
                        modify_comma = text_view.replace('.',',');
                        result_view.setText(modify_comma);
                    }

                    if(op.equals("subtraction")) {

                        result = old_number - current_number;
                        old_number = 0;
                        current_number = 0;
                        text_view = String.valueOf(result);

                        if(text_view.endsWith(".0")){
                            text_view = text_view.substring(0, text_view.length()-2);
                        }
                        modify_comma = text_view.replace('.',',');
                        result_view.setText(modify_comma);
                    }

                    if(op.equals("x")) {

                        result = old_number * current_number;
                        old_number = 0;
                        current_number = 0;
                        text_view = String.valueOf(result);

                        if(text_view.endsWith(".0")){
                            text_view = text_view.substring(0, text_view.length()-2);
                        }
                        modify_comma = text_view.replace('.',',');
                        result_view.setText(modify_comma);
                    }

                    if(op.equals("division") && current_number != 0) {

                        result = old_number / current_number;
                        old_number = 0;
                        current_number = 0;
                        text_view = String.valueOf(result);

                        if(text_view.endsWith(".0")){
                            text_view = text_view.substring(0, text_view.length()-2);
                        }else {
                            result_view.setText("Erro Divisão por 0");
                        }

                        modify_comma = text_view.replace('.',',');
                        result_view.setText(modify_comma);
                    }

                    if(op.equals("percentage")) {

                        result = (old_number * current_number) / 100;

                        old_number = 0;
                        current_number = 0;
                        text_view = String.valueOf(result);

                        if(text_view.endsWith(".0")){
                            text_view = text_view.substring(0, text_view.length()-2);
                        }
                        modify_comma = text_view.replace('.',',');
                        result_view.setText(modify_comma);
                    }

                    if(op.equals("power")) {

                        resultPower = Math.pow(old_number, current_number);

                        old_number = 0;
                        current_number = 0;
                        text_view = String.valueOf(resultPower);

                        if(text_view.endsWith(".0")){
                            text_view = text_view.substring(0, text_view.length()-2);
                        }
                        modify_comma = text_view.replace('.',',');
                        result_view.setText(modify_comma);
                    }

                    op = "";
                    typing = false;
                    separator = false;

                    break;
            }
        }
    }
}