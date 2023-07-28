/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opeyemi.scientificcalculator.model;

/**
 * A utility class that represents the current mode of the scientific calculator.
 * The mode can be used to indicate whether the calculator is in a particular mode (e.g., Normal mode).
 * @author Idris Opeyemi
 */
public class ModeStatic {
    private static String mode;

    /**
     * Gets the current mode of the scientific calculator.
     *
     * @return The current mode of the calculator.
     */
    public static String getMode() {
        return mode;
    }

    /**
     * Sets the mode of the scientific calculator.
     *
     * @param mode The mode to be set for the calculator.
     */
    public static void setMode(String mode) {
        ModeStatic.mode = mode;
    }

}
