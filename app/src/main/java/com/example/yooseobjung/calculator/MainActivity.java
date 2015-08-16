package com.example.yooseobjung.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{

    TextView resultView;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnDot, btnDiv, btnMul, btnSub, btnAdd, btnEqual;
    Button btnAc, btnSigned, btnPercent;
    String value1, value2;
    int operatorId;
    int lastClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = (TextView)findViewById(R.id.result);

        btn0 = (Button)findViewById(R.id.btn_0);
        btn1 = (Button)findViewById(R.id.btn_1);
        btn2 = (Button)findViewById(R.id.btn_2);
        btn3 = (Button)findViewById(R.id.btn_3);
        btn4 = (Button)findViewById(R.id.btn_4);
        btn5 = (Button)findViewById(R.id.btn_5);
        btn6 = (Button)findViewById(R.id.btn_6);
        btn7 = (Button)findViewById(R.id.btn_7);
        btn8 = (Button)findViewById(R.id.btn_8);
        btn9 = (Button)findViewById(R.id.btn_9);
        btnDot = (Button)findViewById(R.id.btn_dot);
        btnDiv = (Button)findViewById(R.id.btn_div);
        btnMul = (Button)findViewById(R.id.btn_mul);
        btnSub = (Button)findViewById(R.id.btn_sub);
        btnAdd = (Button)findViewById(R.id.btn_add);
        btnEqual = (Button)findViewById(R.id.btn_equals);
        btnAc = (Button)findViewById(R.id.btn_ac);
        btnSigned = (Button)findViewById(R.id.btn_signed);
        btnPercent = (Button)findViewById(R.id.btn_percent);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnAc.setOnClickListener(this);
        btnSigned.setOnClickListener(this);
        btnPercent.setOnClickListener(this);

        value1 = "0";
        value2 = "0";
        operatorId = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                if (value1.length() > 1 || !value1.equals("0"))
                    value1 += "0";
                resultView.setText(value1);
                break;
            case R.id.btn_1:
                if (value1.equals("0"))
                    value1 = "1";
                else
                    value1 += "1";
                resultView.setText(value1);
                break;
            case R.id.btn_2:
                if (value1.equals("0"))
                    value1 = "2";
                else
                    value1 += "2";
                resultView.setText(value1);
                break;
            case R.id.btn_3:
                if (value1.equals("0"))
                    value1 = "3";
                else
                    value1 += "3";
                resultView.setText(value1);
                break;
            case R.id.btn_4:
                if (value1.equals("0"))
                    value1 = "4";
                else
                    value1 += "4";
                resultView.setText(value1);
                break;
            case R.id.btn_5:
                if (value1.equals("0"))
                    value1 = "5";
                else
                    value1 += "5";
                resultView.setText(value1);
                break;
            case R.id.btn_6:
                if (value1.equals("0"))
                    value1 = "6";
                else
                    value1 += "6";
                resultView.setText(value1);
                break;
            case R.id.btn_7:
                if (value1.equals("0"))
                    value1 = "7";
                else
                    value1 += "7";
                resultView.setText(value1);
                break;
            case R.id.btn_8:
                if (value1.equals("0"))
                    value1 = "8";
                else
                    value1 += "8";
                resultView.setText(value1);
                break;
            case R.id.btn_9:
                if (value1.equals("0"))
                    value1 = "9";
                else
                    value1 += "9";
                resultView.setText(value1);
                break;
            case R.id.btn_dot:
                if (!value1.contains("."))
                    value1 += ".";
                resultView.setText(value1);
                break;
            case R.id.btn_div:
                value2 = (String) resultView.getText();
                value1 = "0";
                operatorId = 1;
                break;
            case R.id.btn_mul:
                value2 = (String) resultView.getText();
                value1 = "0";
                operatorId = 2;
                break;
            case R.id.btn_sub:
                value2 = (String) resultView.getText();
                value1 = "0";
                operatorId = 3;
                break;
            case R.id.btn_add:
                value2 = (String) resultView.getText();
                value1 = "0";
                operatorId = 4;
                break;
            case R.id.btn_equals:
                double value2double = Double.parseDouble(value2);
                double value1double = Double.parseDouble(value1);
                double result;
                Log.d("Operator Id:", String.valueOf(operatorId));
                switch(operatorId) {
                    case 1:
                        result = value2double / value1double;
                        value2 = Double.toString(result);
                        break;
                    case 2:
                        result = value2double * value1double;
                        value2 = Double.toString(result);
                        break;
                    case 3:
                        result = value2double - value1double;
                        value2 = Double.toString(result);
                        break;
                    case 4:
                        result = value2double + value1double;
                        value2 = Double.toString(result);
                        break;
                    default:
                        value2 = value1;
                        break;
                }
                value1 = "0";
                if(value2.length() > 2 && value2.substring(value2.length()-2).equals(".0")){
                    value2 = value2.substring(0,value2.length()-2);
                }
                resultView.setText(value2);
                break;
            case R.id.btn_ac:
                value1 = "0";
                value2 = "0";
                operatorId = 0;
                resultView.setText(value2);
                break;
            case R.id.btn_signed:
                if (lastClicked == R.id.btn_signed || lastClicked == R.id.btn_equals) {
                    if (value2.charAt(0) == '-'){
                        value2 = value2.substring(1);
                    } else {
                        value2 = "-" + value2;
                    }
                } else {
                    if (value1.charAt(0) == '-'){
                        value1 = value1.substring(1);
                    } else {
                        value1 = "-" + value1;
                    }
                    value2 = value1;
                    value1 = "0";
                }
                resultView.setText(value2);
                break;
            case R.id.btn_percent:
                if (lastClicked == R.id.btn_percent || lastClicked == R.id.btn_equals) {
                    value2 = Double.toString(Double.parseDouble(value2) * 0.01);
                } else {
                    value1 = Double.toString(Double.parseDouble(value1) * 0.01);
                    value2 = value1;
                    value1 = "0";
                }
                resultView.setText(value2);
                break;
            default:
                break;
        }
        lastClicked = v.getId();

    }
}
