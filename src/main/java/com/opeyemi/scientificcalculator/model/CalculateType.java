/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opeyemi.scientificcalculator.model;

/**
 *A utility class that represents the type of calculation being performed by the calculator.
 * It contains static fields and methods to keep track of the current calculation type,
 * whether a calculation has been performed, and the state of the shift mode in the scientific calculator.
 * @author Idris Opeyemi
 */
public class CalculateType {
    private static String type;
    private static Boolean calculated = false;
    private static Boolean shifMode = false;

    public static String getType() {
        return type;
    }

    /**
     * Sets the type of calculation being performed by the calculator.
     *
     * @param type The calculation type to be set.
     */
    public static void setType(String type) {
        CalculateType.type = type;
    }

    public static Boolean getCalculated() {
        return calculated;
    }

    /**
     * Sets the flag indicating whether a calculation has been performed.
     * This method updates the state of the 'calculated' flag, which is used to track
     * whether a calculation has been performed by the calculator.
     *
     * @param calculated The boolean value indicating whether a calculation has been performed.
     */
        public static void setCalculated(Boolean calculated) {
        CalculateType.calculated = calculated;
    }

    public static Boolean getShifMode() {
        return shifMode;
    }

    /**
     * Checks if the shift mode is active in the scientific calculator.
     *
     * @return True if the shift mode is active, false otherwise.
     */

    public static void setShifMode(Boolean shifMode) {
        CalculateType.shifMode = shifMode;
    }
    
}
