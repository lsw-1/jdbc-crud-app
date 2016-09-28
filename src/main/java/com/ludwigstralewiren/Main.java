package com.ludwigstralewiren;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




    public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/login.fxml"));
            primaryStage.setTitle("INVESTMENT VALUE TACKER");
            primaryStage.setScene(new Scene(root, 400, 300));
            primaryStage.show();
            primaryStage.setResizable(false);


        }

        public static void main(String[] args) {
            launch(args);
        }
    }