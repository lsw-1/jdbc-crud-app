package com.ludwigstralewiren;

import com.ludwigstralewiren.user.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;





    public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("./start.fxml"));
            primaryStage.setTitle("JDBC APP");
            primaryStage.setScene(new Scene(root, 300, 300));
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }