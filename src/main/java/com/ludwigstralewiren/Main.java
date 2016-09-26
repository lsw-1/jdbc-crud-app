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
            primaryStage.setTitle("WELCOME");
            primaryStage.setScene(new Scene(root, 500, 500));
            primaryStage.show();


        }

        public static void main(String[] args) {
            launch(args);
        }
    }