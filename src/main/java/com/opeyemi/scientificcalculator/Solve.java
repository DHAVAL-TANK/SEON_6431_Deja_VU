/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opeyemi.scientificcalculator;

import com.opeyemi.scientificcalculator.model.CalculateType;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static java.lang.Integer.parseInt;
import static java.lang.System.*;

/**
 * The Solve class is responsible for performing mathematical calculations in the scientific calculator.
 * It handles various mathematical operations like power, nth root, trigonometric functions, etc.
 * 
 * @author Idris Opeyemi
 */
public class Solve {

    public Solve() {
    }

    /**
     * Solves the power operation (x^y) in a given mathematical expression.
     * 
     * @param calculate The mathematical expression containing the power operation
     * @return The updated mathematical expression with the power operation solved
     */
    public String solvePower(String calculate) {
        String[] parts = calculate.split("(?=[/×-÷+^])|(?<=[/×÷*-+^])");
        float solvedPow;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("^")) {
                int left = parseInt(parts[i - 1]);
                int right = parseInt(parts[i + 1]);
                solvedPow = (float) (Math.pow(left, right));
                int round = Math.round(solvedPow);
                calculate = calculate.replace("" + parts[i - 1] + parts[i] + parts[i + 1], "" + round);
                break;
            }
        }
        return calculate;
    }

    /**
     * Solves the nth root operation (∛) in a given mathematical expression.
     * 
     * @param calculate The mathematical expression containing the nth root operation
     * @param power The power for the nth root
     * @return The updated mathematical expression with the nth root operation solved
     */
    public String solveNthRoot(String calculate, int power) {
        String[] parts = calculate.split("(?=[/×-÷+∛])|(?<=[/×÷*-+∛])");
        float solvedPow;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("∛")) {
                int right = parseInt(parts[i + 1]);
                solvedPow = (float) (Math.pow(right, 1.0 / power));
                int round = Math.round(solvedPow);
                calculate = calculate.replace("" + parts[i] + parts[i + 1], "" + round);

                out.println(calculate);
                break;
            }
        }
        return calculate;
    }

    /**
     * Solves the mathematical expression entered by the user.
     */
    public void solve() {
        String calculate = Screen.getTypeField().getText();
        if (calculate.contains("^")) {
            calculate = solvePower(calculate);
        } else if (calculate.contains("∛")) {
            calculate = solveNthRoot(calculate, 3);
        }
        calculate = calculate.replace("√", "Math.sqrt").
                replace("÷", "/").
                replace("%", "*1/100").
                replace("π", "Math.PI").
                replace("×", "*");
        out.println(calculate);
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

        try {
            Object answer = engine.eval(calculate);
            Screen.getResultList().add(answer.toString());
            Screen.getResult().setText(answer.toString());
            CalculateType.setCalculated(Boolean.TRUE);
        } catch (ScriptException e) {
            Screen.getResultList().add("SYNTAX ERROR");
            Screen.getResult().setText("SYNTAX ERROR");
            CalculateType.setCalculated(Boolean.TRUE);
        }
    }

    /**
     * Solves the scientific mathematical expression entered by the user.
     * It handles trigonometric functions, inverse trigonometric functions, and other advanced operations.
     */
    public void solveScientific() {
        String calculate = Screen.getTypeField().getText();
        if (calculate.contains("sin-1") || calculate.contains("cos-1") || calculate.contains("tan-1")) {
            solveInverse();
            return;
        }
        if (calculate.contains("^")) {
            calculate = solvePower(calculate);
        }
        calculate = calculate.replace("sin-1", "Math.asin(").
                replace("cos-1", "Math.acos(").
                replace("tan-1", "Math.atan(").
                replace("sin", "Math.sin(").
                replace("cos", "Math.cos(").
                replace("tan", "Math.tan(").
                replace("√", "Math.sqrt").
                replace("∛", "Math.cbrt").
                replace("π", "Math.PI").
                replace(")", "*Math.PI)/180)").
                replace("÷", "/").
                replace("%", "*1/100").
                replace("×", "*").
                replace("log", "Math.log(");
        out.println(Math.log(10));

        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

        try {
            Object answer = engine.eval(calculate);
            Screen.getResultList().add(answer.toString());
            Screen.getResult().setText(answer.toString());
            CalculateType.setCalculated(Boolean.TRUE);
            CalculateType.setType("Normal");
        } catch (ScriptException e) {
            Screen.getResultList().add("SYNTAX ERROR");
            Screen.getResult().setText("SYNTAX ERROR");
            CalculateType.setCalculated(Boolean.TRUE);
        }
    }

    /**
     * Solves the inverse trigonometric functions (sin-1, cos-1, tan-1) in a given mathematical expression.
     * 
     * The method replaces the inverse trigonometric functions with their corresponding values in degrees.
     */
    public void solveInverse() {
        String calculate = Screen.getTypeField().getText();
        if (calculate.contains("^")) {
            calculate = solvePower(calculate);
        }
        calculate = calculate.replace("sin-1", "180/Math.PI*(Math.asin").
                replace("cos-1", "180/Math.PI*(Math.acos").
                replace("tan-1", "180/Math.PI*(Math.atan").
                replace("√", "Math.sqrt").
                replace("∛", "StrictMath.cbrt").
                replace("π", "Math.PI").
                replace(")", "))").
                replace("÷", "/").
                replace("%", "*1/100").
                replace("×", "*").
                replace("log", "Math.log(");
        out.println(calculate);
        Math.cbrt(0);

        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");

        try {
            Object answer = engine.eval(calculate);
            Screen.getResultList().add(answer.toString());
            Screen.getResult().setText(answer.toString());
            CalculateType.setCalculated(Boolean.TRUE);
            CalculateType.setType("Normal");
        } catch (ScriptException e) {
            Screen.getResultList().add("SYNTAX ERROR");
            Screen.getResult().setText("SYNTAX ERROR");
            CalculateType.setCalculated(Boolean.TRUE);
        }
    }

    /**
     * Solves the factorial of an integer value in a given mathematical expression.
     *
     */
    public void solveFactorial() {
        int fac = parseInt(Screen.getTypeField().getText());
        fac = factorial(fac);
        Screen.getResult().setText("" + fac);
        CalculateType.setCalculated(Boolean.TRUE);
        Screen.getResultList().add(fac + "");
    }

    /**
     * Computes the factorial of a given integer value.
     * 
     * @param value The integer value for which to compute the factorial
     * @return The factorial value of the input integer
     */
    public int factorial(int value) {
        for (int i = (value - 1); i > 0; i--) {
            value = value * i;
        }
        return value;
    }

    /**
     * Computes the combination (nCr) of two numbers.
     */
    public void combination() {
        String val[] = Screen.getTypeField().getText().split("(?=C)|(?<=C)");
        int nValue = parseInt(val[0]);
        int rValue = parseInt(val[2]);
        int nFactorial = factorial(nValue);
        int rFactorial = factorial(rValue);
        int nMinusRFactorial = factorial(nValue - rValue);
        int comb = nFactorial / (rFactorial * (nMinusRFactorial));
        Screen.getResultList().add(comb + "");
        CalculateType.setCalculated(Boolean.TRUE);
        Screen.getResult().setText("" + comb);

    }

    /**
     * Computes the permutation (nPr) of two numbers.
     * The permutation is calculated based on the formula n! / (n-r)!
     */
    public void permutation() {
        String[] val = Screen.getTypeField().getText().split("(?=P)|(?<=P)");
        int nValue;
        nValue = parseInt(val[0]);
        int rValue = parseInt(val[2]);
        int nFactorial = factorial(nValue);
        int nMinusRFactorial = factorial(nValue - rValue);
        int perm = nFactorial / (nMinusRFactorial);
        Screen.getResultList().add(perm + "");
        CalculateType.setCalculated(Boolean.TRUE);
        Screen.getResult().setText("" + perm);

    }
}
