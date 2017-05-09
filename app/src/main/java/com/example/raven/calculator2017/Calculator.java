package com.example.raven.calculator2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class Calculator extends AppCompatActivity {
    private TextView display;
    private String toDisplay="";
    private String currentOperator ="";
    private static String TAG = "CalculatorActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display = (TextView)findViewById(R.id.display);
        display.setText(toDisplay);
    }

    private void updateDisplay(){
        Log.d(TAG, toDisplay);
        display.setText(toDisplay);
    }

    protected void onClickNumber(View v){
        TextView b = (TextView)v;
        toDisplay += b.getText();
        updateDisplay();
    }

    protected void onClickOperator(View v){
        TextView b = (TextView)v;
        toDisplay+=(String)b.getText();
        currentOperator = b.getText().toString();
        updateDisplay();
    }

    protected void clear(){
        toDisplay ="";
        currentOperator="";

        updateDisplay();
    }
    protected void onClickCalculate(View v){
        Log.d(TAG, currentOperator);
        String[] toCalculate = toDisplay.split(Pattern.quote(currentOperator));
        Log.d(TAG, toCalculate[0]);
        if(toCalculate.length < 2) return;
        Log.d(TAG, toCalculate[1]);
        Double numberOne = Double.valueOf(toCalculate[0]);
        Double numberTwo = Double.valueOf(toCalculate[1]);
        Double valueToDisplay = Double.valueOf(0);
        switch (currentOperator){
            case "+": valueToDisplay = numberOne+numberTwo; break;
            case "*": valueToDisplay = numberOne*numberTwo; break;
            default: valueToDisplay = Double.valueOf(-1);
        }
        toDisplay +=" "+ valueToDisplay.toString();
        Log.d(TAG, toCalculate[1]);
        updateDisplay();
        Toast.makeText(Calculator.this,"super wynik "+toDisplay,Toast.LENGTH_LONG).show();

    }


}
