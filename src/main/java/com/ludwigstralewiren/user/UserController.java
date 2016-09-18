package com.ludwigstralewiren.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static com.ludwigstralewiren.config.HibernateUtil.getSessionFactory;

/**
 * Created by Ludwig on 9/18/2016.
 */
public class UserController {

    @FXML
    private VBox output;

    private static UserDao userDao = new UserDaoImpl();

    public void addUser(ActionEvent actionEvent) {


    }

    public void findUser(ActionEvent actionEvent) {
        userDao.findAll().forEach(user -> output.getChildren().add(new Text(user.getUserName())));
        userDao.findAll().forEach(System.out::println);


    }

    public void deleteUser(ActionEvent actionEvent) {
    }
}
