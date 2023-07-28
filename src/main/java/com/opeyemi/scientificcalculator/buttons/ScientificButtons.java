/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opeyemi.scientificcalculator.buttons;

import com.jfoenix.controls.JFXButton;
import com.opeyemi.scientificcalculator.Screen;
import com.opeyemi.scientificcalculator.Solve;
import com.opeyemi.scientificcalculator.model.CalculateType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * This class represents a set of scientific buttons for the calculator UI.
 * It provides methods to create different rows of buttons for scientific operations.
 * The buttons are implemented using the JFXButton class from JFoenix library.
 * Each button has its own functionality and event handlers to perform the desired operation.
 * @author Idris Opeyemi
 */
public class ScientificButtons {

    HBox row;

    public ScientificButtons() {
        row = new HBox(10);
        row.setPrefWidth(350);
    }

    /**
     * Creates the second row of scientific buttons.
     *
     * @return HBox containing the second row of scientific buttons
     */
    public HBox row2() {
        HBox row2 = new HBox(10);
        row2.setPrefWidth(350);
        row2.setPadding(new Insets(0, 5, 5, 5));
        row2.getChildren().addAll(mixedFraction(), createJFXButton("√", 4), createJFXButton("x^2", 4), createJFXButton("˄", 4), createJFXButton("log", 4), createJFXButton("ln", 2));
        return row2;

    }

    /**
     * Creates the third row of scientific buttons.
     *
     * @return HBox containing the third row of scientific buttons
     */
    public HBox row3() {
        HBox row3 = new HBox(10);
        row3.setPrefWidth(350);
        row3.setPadding(new Insets(0, 5, 5, 5));
        row3.getChildren().addAll(createJFXButton("(-)", 2), createJFXButton(".", 2), createJFXButton("hyp", 2), createJFXButton("sin", 1), createJFXButton("cos", 1), createJFXButton("tan", 1));
        return row3;

    }

    /**
     * Creates the fourth row of scientific buttons.
     *
     * @return HBox containing the fourth row of scientific buttons
     */
    public HBox row4() {
        HBox row4 = new HBox(10);
        row4.setPrefWidth(350);
        row4.setPadding(new Insets(0, 5, 5, 5));
        row4.getChildren().addAll(createJFXButton("RCL", 2), createJFXButton("ENG", 2), createJFXButton("(", 3), createJFXButton(")", 3), createJFXButton(",", 2), createJFXButton("M+", 2));
        return row4;

    }

    /**
     * Creates the first half of the first row of scientific buttons.
     *
     * @return HBox containing the first half of the first row of scientific buttons
     */
    public HBox halfRow1() {
        HBox row1 = new HBox(10);
        row1.setPrefWidth(350 / 3);
        row1.getChildren().addAll(minusPower(), comb());
        return row1;

    }

    /**
     * Creates the second half of the first row of scientific buttons.
     *
     * @return HBox containing the second half of the first row of scientific buttons
     */
    public HBox half2Row() {
        HBox row1 = new HBox(10);
        row1.setPrefWidth(350 / 3);
        row1.setAlignment(Pos.BASELINE_RIGHT);
        row1.getChildren().addAll(pol(), cbrt());
        return row1;
    }

    /**
     * Creates the button for factorial operation.
     *
     * @return JFXButton for factorial operation
     */
    public JFXButton minusPower() {
        Solve solve = new Solve();
        JFXButton minusPower = new JFXButton("");
        minusPower.setButtonType(JFXButton.ButtonType.RAISED);
        minusPower.getStyleClass().add("sciButton");
        minusPower.setTextFill(Color.WHITE);
        minusPower.setPrefWidth((row.getPrefWidth() / 3) / 3);
        minusPower.setPrefHeight(20);
        minusPower.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            solve.solveFactorial();
            Screen.getTypeField().appendText("!");
            Screen.getToCalculate().add(Screen.getTypeField().getText());
        });
        return minusPower;
    }

    /**
     * Creates the button for combination operation.
     *
     * @return JFXButton for combination operation
     */
    public JFXButton comb() {
        JFXButton comb = new JFXButton("nCr");
        comb.setButtonType(JFXButton.ButtonType.RAISED);
        comb.getStyleClass().add("sciButton");
        comb.setTextFill(Color.WHITE);
        comb.setPrefWidth((row.getPrefWidth() / 3) / 3);
        comb.setPrefHeight(20);
        comb.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            if (CalculateType.getShifMode()) {
                Screen.getTypeField().appendText("P");
                CalculateType.setType("Permutation");
            } else {
                Screen.getTypeField().appendText("C");
                CalculateType.setType("Combination");
            }
        });
        return comb;
    }

    /**
     * Creates the button for pol operation.
     *
     * @return JFXButton for pol operation
     */
    public JFXButton pol() {
        JFXButton pol = new JFXButton("pol(");
        pol.setButtonType(JFXButton.ButtonType.RAISED);
        pol.getStyleClass().add("sciButton");
        pol.setTextFill(Color.WHITE);
        pol.setPrefWidth((row.getPrefWidth() / 3) / 3);
        pol.setPrefHeight(20);
        pol.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            if (CalculateType.getShifMode()) {
                Screen.getTypeField().appendText("∛");
                CalculateType.setType("Normal");
            } else {
//                Screen.getTypeField().appendText("C");
//                CalculateType.setType("Combination");
            }
        });
        return pol;
    }

    /**
     * Creates the button for mixed fractions.
     *
     * @return JFXButton for mixed fractions
     */
    public JFXButton mixedFraction() {
        Text biga = new Text("a");
        Text small = new Text(" b/c");
        TextFlow fract = new TextFlow(biga, small);
        small.setFill(Color.WHITE);
        biga.setFill(Color.WHITE);

        JFXButton mixedFrac = new JFXButton();
        mixedFrac.setButtonType(JFXButton.ButtonType.RAISED);
        mixedFrac.getStyleClass().add("sciButton");
        mixedFrac.setGraphic(fract);
        mixedFrac.setTextFill(Color.WHITE);
        mixedFrac.setPrefWidth(row.getPrefWidth() / 6);
        mixedFrac.setPrefHeight(20);
        mixedFrac.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
        });
        return mixedFrac;
    }

    /**
     * Creates the button for cube root operation.
     *
     * @return JFXButton for cube root operation
     */
   public JFXButton cbrt() {
        JFXButton cbrt = new JFXButton("x^3");
        cbrt.getStyleClass().add("sciButton");
        cbrt.setTextFill(Color.WHITE);
        cbrt.setPrefWidth((row.getPrefWidth() / 3) / 3);
        cbrt.setPrefHeight(20);
        cbrt.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            Screen.getTypeField().appendText("^3");
            CalculateType.setType("Normal");
        });
        return cbrt;
    }

    /**
     * Creates a generic JFXButton with the specified label and type.
     *
     * @param label The label/text to display on the button
     * @param type  The type of the button (1, 2, 3, or 4)
     * @return JFXButton with the specified label and type
     */
      public JFXButton createJFXButton(String label, int type) {
        JFXButton button = new JFXButton(label);
        button.setButtonType(JFXButton.ButtonType.RAISED);
        button.getStyleClass().add(label);
        button.setTextFill(Color.WHITE);
        button.setPrefWidth(row.getPrefWidth() / 6);
        button.setPrefHeight(20);

        if( type == 1 )
        {
            button.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            CalculateType.setType("Scientific");
            if (CalculateType.getShifMode()) {
                Screen.getTypeField().appendText(label+"-1(");
            } else {
                Screen.getTypeField().appendText(label+"(");
            }
        });
        }
        else if( type == 3) {
             button.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            Screen.getTypeField().appendText(label);
        });
        }
        else if( type == 4 ){
             button.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            CalculateType.setType("Scientific");
            Screen.getTypeField().appendText(label+"(");
        });
        }
        else{
            button.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
        });
        }

        return button;
       
    }

}
