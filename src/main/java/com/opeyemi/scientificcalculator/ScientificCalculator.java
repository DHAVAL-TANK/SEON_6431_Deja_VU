/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opeyemi.scientificcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * The ScientificCalculator class is a JavaFX application for a scientific calculator.
 * It launches the graphical user interface for the calculator.
 * 
 * @author Idris Opeyemi
 */
public class ScientificCalculator extends Application {

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    /**
     * Set the primary stage of the application.
     * 
     * @param primaryStage The primary stage to set
     */
    public static void setPrimaryStage(Stage primaryStage) {
        ScientificCalculator.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Font.loadFont(getClass().getResource("/font/digital-7.ttf").toExternalForm(), 10);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ScientificCalculator.fxml"));
        System.out.println(root.toString());
        root.getStyleClass().add("anchorPane");
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setX(500.0);
        primaryStage.setY(80.0);
        primaryStage.setWidth(350);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
//        primaryStage.styl
    }

    /**
     * The main method to launch the application.
     * 
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
