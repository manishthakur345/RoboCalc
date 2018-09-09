package com.example.manishthakur.robocalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity{
    private enum OPERATOR{
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }
    TextView tvCalculations;
    TextView txtMain;
    //Instance Variable

    private String currentNumber="";
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private long Result;
    private String calculationStrings="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCalculations = findViewById(R.id.tvCalculations);
        txtMain = findViewById(R.id.txtMain);



    }

    public void buClick(View view) {
        switch (view.getId()){
            case R.id.btnBack:
                back();
                //Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btAC:
                reset();
                break;
            case R.id.btnDiv:
                break;
            case R.id.btn7:
                Tapped(7);
                break;
            case (R.id.btn8):
                Tapped(8);
                break;
            case (R.id.btn9):
                Tapped(9);
                break;
            case (R.id.btnPlus):
                operatorIsTapped(OPERATOR.PLUS);
                calculationStrings+="+";
                break;
            case (R.id.btn4):
                Tapped(4);
                break;
            case (R.id.btn5):
                Tapped(5);
                break;
            case (R.id.btn6):
                Tapped(6);
                break;
            case (R.id.btnMinus):
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationStrings+=" - ";
                break;
            case (R.id.btn1):
                Tapped(1);
                break;
            case (R.id.btn2):
                Tapped(2);
                break;
            case (R.id.btn3):
                Tapped(3);
                break;
            case (R.id.btnX):
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationStrings+=" X ";
                break;

            case (R.id.btnPerc):
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationStrings+=" / ";
                break;
            case (R.id.btnEqual):
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case (R.id.btn0):
                Tapped(0);
                break;

        }
    }
    private void reset()
    {
        txtMain.setText("");
        currentOperator = null;
        currentNumber = "";

        tvCalculations.setText("Reset");
    }
    private void equal()
    {
        switch (currentOperator){
            case PLUS:
                Result = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                //txtMain.setText("");
                //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                break;
            case EQUAL:
                break;

            case DIVIDE:
                Result = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                break;
            case MULTIPLY:
                Result = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                break;
            case SUBTRACT:
                Result = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                break;
        }

    }
    private void back()
    {
        StringBuffer crNumber = new StringBuffer(currentNumber);
        crNumber.deleteCharAt(crNumber.length()-1);
        currentNumber = crNumber.toString();
        txtMain.setText(currentNumber);

    }
    private void Tapped(int tappedNumber){
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtMain.setText(currentNumber);

    }

    private void operatorIsTapped(OPERATOR op){
        txtMain.setText("");

        if(currentOperator != null  ) {
            if (currentNumber != "") {

                stringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {
                    case PLUS:
                        Result = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                        //txtMain.setText("");
                        //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                        break;
                    case EQUAL:
                        equal();
                        //Result = Integer.parseInt(stringNumberAtLeft)  Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        Result = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        Result = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                        break;
                    case SUBTRACT:
                        Result = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft = String.valueOf(Result);
                tvCalculations.setText("Ans : "+String.valueOf(Result));
                txtMain.setText(stringNumberAtLeft);

            }
        }
        else{
            stringNumberAtLeft = currentNumber;
            currentNumber="";
        }
            currentOperator = op;
            //txtMain.setText("");
    }

}
