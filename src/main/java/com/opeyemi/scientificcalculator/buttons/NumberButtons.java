/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opeyemi.scientificcalculator.buttons;

import com.jfoenix.controls.JFXButton;
import com.opeyemi.scientificcalculator.ScientificCalculator;
import com.opeyemi.scientificcalculator.Screen;
import com.opeyemi.scientificcalculator.Solve;
import com.opeyemi.scientificcalculator.model.CalculateType;
import javafx.geometry.Insets;
import javafx.scene.CacheHint;
import javafx.scene.control.ContentDisplay;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


/**
 * The NumberButtons class is responsible for creating and managing the numeric buttons in the scientific calculator.
 * It provides methods to generate individual number buttons as well as organized rows of number buttons.
 * These buttons allow users to input numeric values and perform arithmetic operations in the calculator.
 * The class also handles the "AC" (All Clear) button to reset the calculator's state.
 * 
 * Each number button is represented by a JFXButton, which is a custom-styled JavaFX button.
 * The class also handles button actions to update the display and perform calculations.
 * 
 * @author Idris Opeyemi
 */
public class NumberButtons {

    HBox row1;
    HBox row2;
    HBox row3;

    /**
     * Constructs a new instance of the NumberButtons class.
     *
     * The NumberButtons class is responsible for creating and managing the number buttons used in the calculator user interface.
     * It organizes the number buttons into rows for display and interaction.
     */
    public NumberButtons() {
        row1 = new HBox(10);
        row1.setPrefWidth(350);;
        row1.setPadding(new Insets(0, 5, 5, 5));

        row2 = new HBox(10);
        row2.setPrefWidth(350);;
        row2.setPadding(new Insets(10, 5, 5, 5));

    }

    /**
     * Creates and returns an HBox containing the number buttons for the calculator user interface.
     *
     * @return The HBox containing the number buttons.
     */
    public HBox numbers() {
        HBox hbox = new HBox();
        return hbox;
    }

    /**
     * Creates the fourth row of number buttons (0, point, exp, Ans, and equals) in the calculator user interface.
     *
     * @return HBox representing the fourth row of number buttons
     */ 
    public HBox row4() {
        HBox row4 = new HBox(10);
        row4.setPrefWidth(350);;
        row4.setPadding(new Insets(0, 5, 5, 5));
        row4.getChildren().addAll(createJFXNumButton("0",1), createJFXNumButton(".",1), createJFXNumButton("exp",2), createJFXNumButton("Ans",2), equals());
        return row4;
    }

    /**
     * Creates the third row of number buttons (1, 2, 3, +, and -) in the calculator user interface.
     *
     * @return HBox representing the third row of number buttons
     */
    public HBox row3() {
        HBox row3 = new HBox(10);
        row3.setPrefWidth(350);;
        row3.setPadding(new Insets(0, 5, 5, 5));
        row3.getChildren().addAll( createJFXNumButton("1",1),  createJFXNumButton("2",1), createJFXNumButton("3",1),  createJFXNumButton("+",1), createJFXNumButton("-",1));
        return row3;
    }

    /**
     * Creates the second row of number buttons (4, 5, 6, multiplication, and division).
     *
     * @return HBox representing the second row of number buttons
     */
    public HBox row2() {
        HBox row2 = new HBox(10);
        row2.setPrefWidth(350);;
        row2.setPadding(new Insets(10, 5, 5, 5));
        row2.getChildren().addAll( createJFXNumButton("4",1),  createJFXNumButton("5",1),  createJFXNumButton("6",1), createJFXNumButton("×",1), createJFXNumButton("÷",1));
        return row2;
    }

    /**
     * Creates the first row of number buttons (7, 8, 9, delete, and all clear).
     *
     * @return HBox representing the second row of number buttons
     */
    public HBox row1() {
        HBox row1 = new HBox(10);
        row1.setPrefWidth(350);;
        row1.setPadding(new Insets(0, 5, 10, 5));
        row1.getChildren().addAll(createJFXNumButton("7",1), createJFXNumButton("8",1), createJFXNumButton("9",1), del(), ac());
        return row1;
    }

    /**
     * Creates a custom-styled JFXButton for a numeric value or special operation.
     * The appearance and behavior of the button depend on the provided label and type.
     * Numeric buttons are created for digits 0 to 9 and special operations like decimal point (.), exponentiation (exp), etc.
     * The type parameter is used to differentiate between regular numeric buttons (type = 1) and special operation buttons (type = 2).
     *
     * @param label The label/text to be displayed on the button.
     * @param type  The type of the button (1 for numeric buttons, 2 for special operation buttons).
     * @return The custom-styled JFXButton with the specified label and behavior.
     */
        public JFXButton createJFXNumButton(String label, int type) {
        JFXButton button = new JFXButton(label);
        button.setButtonType(JFXButton.ButtonType.RAISED);
        button.getStyleClass().add("numButton");
        button.setTextFill(Color.WHITE);
        button.setPrefWidth(row1.getPrefWidth() / 5);
        button.setPrefHeight(25);
       
          button.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            if( type == 1 )
          { Screen.getTypeField().appendText(label);}
          else {

          }
           });
        return button;
    }

    /**
     * Creates a custom-styled JFXButton for the "delete" (DEL) operation.
     * The button displays a delete icon and allows users to remove the last character from the input field.
     * When clicked, it removes the last character from the input field of the calculator's user interface.
     *
     * @return The custom-styled JFXButton representing the "delete" operation.
     */
    public JFXButton del() {
        JFXButton del = new JFXButton();

        ImageView delIcon = new ImageView(new Image(getClass().getResource("/images/delete.png").toExternalForm()));
        delIcon.setFitWidth(20);
        delIcon.setFitHeight(20);
        ColorAdjust white = new ColorAdjust();
        white.setBrightness(200.0);

        delIcon.setEffect(white);
        delIcon.setCache(true);
        delIcon.setCacheHint(CacheHint.SPEED);

        del.setGraphic(delIcon);
        del.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        del.setButtonType(JFXButton.ButtonType.RAISED);
        del.getStyleClass().add("delac");
        del.setPrefWidth(row1.getPrefWidth() / 5);
        del.setPrefHeight(25);
        del.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                Screen.getResult().setText("");
                Screen.getTypeField().setText("");
                CalculateType.setCalculated(Boolean.FALSE);
            }
            Screen.getTypeField().setText(Screen.getTypeField().getText().toString().substring(0, Screen.getTypeField().getText().length() - 1));
        });
        return del;
    }

    /**
     * Creates a custom-styled JFXButton for the "All Clear" (AC) operation.
     * The button allows users to reset the calculator's state and clear the input and output fields.
     * When clicked, it sets the input and output fields of the calculator's user interface to empty.
     *
     * @return The custom-styled JFXButton representing the "All Clear" operation.
     */
    public JFXButton ac() {
        JFXButton ac = new JFXButton("AC");
        ac.setButtonType(JFXButton.ButtonType.RAISED);
        ac.getStyleClass().add("delac");
        ac.setTextFill(Color.WHITE);
        ac.setPrefWidth(row1.getPrefWidth() / 5);
        ac.setPrefHeight(25);
        ac.setOnAction((ev) -> {
            Screen.getResult().setText("");
            Screen.getTypeField().setText("");
            CalculateType.setCalculated(Boolean.FALSE);
        });
        return ac;
    }

    /**
     * Creates a custom-styled JFXButton for the "equals" (=) operation.
     * The button allows users to perform arithmetic and scientific calculations based on the provided input.
     * When clicked, it triggers the calculation based on the current input in the calculator's user interface.
     * The type of calculation (normal arithmetic, scientific, combination, permutation) is determined by the calculator's state.
     * The result of the calculation is displayed in the output field of the calculator's user interface.
     *
     * @return The custom-styled JFXButton representing the "equals" operation.
     */
        public JFXButton equals() {
        Solve calculateSolve = new Solve();
        JFXButton equals = new JFXButton("=");
        equals.setButtonType(JFXButton.ButtonType.RAISED);
        equals.getStyleClass().add("numButton");
        equals.setTextFill(Color.WHITE);
        equals.setPrefWidth(row1.getPrefWidth() / 5);
        equals.setPrefHeight(25);
        equals.setOnAction((ev) -> {
            if (CalculateType.getCalculated()) {
                CalculateType.setCalculated(Boolean.FALSE);
            }
            if (CalculateType.getShifMode()) {
                Screen.getTypeField().appendText("%");
            } else if (!Screen.getTypeField().getText().equals("")) {
                switch (CalculateType.getType()) {
                    case "Scientific":
                        Screen.getToCalculate().add(Screen.getTypeField().getText().trim());
                        calculateSolve.solveScientific();
                        break;
                    case "Normal":
                        Screen.getToCalculate().add(Screen.getTypeField().getText().trim());
                        calculateSolve.solve();
                        break;
                    case "Combination":
                        Screen.getToCalculate().add(Screen.getTypeField().getText().trim());
                        calculateSolve.combination();
                        break;
                    case "Permutation":
                        Screen.getToCalculate().add(Screen.getTypeField().getText().trim());
                        calculateSolve.permutation();
                        break;
                }
            }
        });

        return equals;
    }

}
