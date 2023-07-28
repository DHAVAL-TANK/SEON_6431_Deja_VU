/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opeyemi.scientificcalculator;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * The Screen class represents the user interface screen of the scientific calculator.
 * It includes the calculation text field, result text field, and the calculation history.
 * 
 * @author Idris Opeyemi
 */
public class Screen {

    private static JFXTextField typeField;
    private static JFXTextField result;
    private static ObservableList<String> toCalculate = FXCollections.observableArrayList();
    private static ObservableList<String> resultList = FXCollections.observableArrayList();

    public Screen() {
    }
    /**
     * Creates and returns the user interface screen for the calculator.
     * 
     * @return The VBox containing the calculation screen components
     */
    public VBox calculateScreen() {
        VBox calculate = new VBox();
        Text mode = new Text("DEG");     

        typeField = new JFXTextField();
        typeField.getStyleClass().add("typefont");
        typeField.setFocusColor(Color.WHITE);
        typeField.setUnFocusColor(Color.WHITE);
//        typeField.setFocusTraversable(false);
        typeField.setEditable(false);

        result = new JFXTextField();
        result.setFocusTraversable(false);
        result.setEditable(false);
        result.getStyleClass().add("resultfont");
        result.setFocusColor(Color.WHITE);
        result.setUnFocusColor(Color.WHITE);
        result.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        calculate.getChildren().addAll(mode, typeField, result);
        calculate.setPadding(new Insets(5, 5, 5, 5));
        calculate.setStyle("-fx-background-color: white");
        return calculate;
    }

    public static JFXTextField getTypeField() {
        return typeField;
    }

    public static JFXTextField getResult() {
        return result;
    }

    public static ObservableList<String> getToCalculate() {
        return toCalculate;
    }
    /**
     * Sets the list of calculations to be performed.
     * 
     * @param toCalculate The list of calculations to set
     */
    public static void setToCalculate(ObservableList<String> toCalculate) {
        Screen.toCalculate = toCalculate;
    }

    public static ObservableList<String> getResultList() {
        return resultList;
    }

    /**
     * Sets the list of calculation results.
     * 
     * @param resultList The list of calculation results to set
     */
    public static void setResultList(ObservableList<String> resultList) {
        Screen.resultList = resultList;
    }

}
