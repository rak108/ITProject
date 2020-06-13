package com.example.calculatormprj2020;


import android.app.Application;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast;
import android.app.Application;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;


public class CalculatorBrain extends MainActivity {


   public static String str;


    // 3 + 6 = 9
    // 3 & 6 are called the operand.
    // The + is called the operator.
    // 9 is the result of the operation.
    private double mOperand;
    private double mWaitingOperand;
    private String mWaitingOperator;
    private double mCalculatorMemory;

    // operator types
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String PERCENT = "%";
    private static final String CLEAR = "AC";
    private static final String LOG = "log";
    private static final String BACKSPACE = "C";
    private static final String PI = "PI";
    private static final String FACTORIAL = "x!";
    private static final String SQUAREROOT = "√";
    private static final String POWER = "^";
    private static final String INVERT = "1/x";
    private static final String TOGGLESIGN = "+/-";
    private static final String SINE = "sin";
    private static final String COSINE = "cos";
    private static final String TANGENT = "tan";
    // public static final String EQUALS = "=";






    // constructor
    protected CalculatorBrain() {
        // initialize variables upon start
        mOperand = 0;
        mWaitingOperand = 0;
        mWaitingOperator = "";
        mCalculatorMemory = 0;
    }

    public void setOperand(double operand) {
        mOperand = operand;
    }

    public double getResult() {
        return mOperand;
    }

    // used on screen orientation change
    public void setMemory(double calculatorMemory) {
        mCalculatorMemory = calculatorMemory;
    }

    // used on screen orientation change
    public double getMemory() {
        return mCalculatorMemory;
    }

    public String toString() {
        return Double.toString(mOperand);
    }

    protected double performOperation(String operator) {

        switch (operator) {
            case CLEAR:
                mOperand = 0;
                mWaitingOperator = "";
                mWaitingOperand = 0;
                break;
            case LOG:
                mOperand = Math.log10(mOperand);
                break;
            case BACKSPACE:
                mOperand -= (mOperand % 10);
                mOperand /= 10;
                mCalculatorMemory -= (mCalculatorMemory);
                mCalculatorMemory /= 10;
                break;
            case PI:
                if (mOperand != 0) {
                    mWaitingOperand = Math.PI;
                } else
                    mOperand += Math.PI;
                break;
            case PERCENT:
                mOperand /= 100;
                break;
            case FACTORIAL:

                if (mOperand>=0) {
                    int i;
                    double number = mOperand;//It is the number to calculate factorial
                    mOperand = 1;
                    for (i = 1; i <= number; i++) {
                        mOperand = mOperand * i;

                    }
                }
                else{
                    mOperand=0;
                }
                
                break;
            case SQUAREROOT:
                mOperand = Math.sqrt(mOperand);
                break;

            case INVERT:
                if (mOperand != 0) {
                    mOperand = 1 / mOperand;
                }
                break;
            case TOGGLESIGN:
                mOperand = -mOperand;
                break;
            case SINE:
                mOperand = Math.sin(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
                break;
            case COSINE:
                mOperand = Math.cos(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
                break;
            case TANGENT:
                mOperand = Math.tan(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
                break;
            default:
                performWaitingOperation();
                mWaitingOperator = operator;
                mWaitingOperand = mOperand;
                break;
        }

        return mOperand;
    }

    private void performWaitingOperation() {

        switch (mWaitingOperator) {
            case ADD:
                mOperand = mWaitingOperand + mOperand;
                break;
            case SUBTRACT:
                mOperand = mWaitingOperand - mOperand;
                break;
            case MULTIPLY:
                mOperand = mWaitingOperand * mOperand;
                break;
            case DIVIDE:
                if (mOperand != 0) {
                    mOperand = mWaitingOperand / mOperand;
                }
                else
                {

                    mOperand=0;
                    mWaitingOperand=0;
                    mWaitingOperator="";


                }


                break;
            case POWER:
                mOperand = Math.pow(mWaitingOperand, mOperand);
                break;
        }

    }


}

