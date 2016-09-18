package com.ludwigstralewiren.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


/**
 * Created by Ludwig on 9/18/2016.
 */
public class UserController {

    @FXML
    private VBox output;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;

    private static UserDao userDao = new UserDaoImpl();

    public void addUser(ActionEvent actionEvent) {
        String fName = field1.getText();
        String lName = field2.getText();

        User user = new User.UserBuilder(fName, lName)
                .withPhone(142352235L)
                .withEmail("sdnfjskdhf@asdasd.com")
                .build();

        userDao.save(user);
    }

    public void findUser(ActionEvent actionEvent) {
        output.getChildren().clear();
        userDao.findAll().forEach(user -> output.getChildren().add(new Text(user.getUserName())));
        userDao.findAll().forEach(System.out::println);



    }

    public void deleteUser(ActionEvent actionEvent) {
        Long id = Long.parseLong(field1.getText().trim());
        userDao.delete(userDao.findById(id));
    }
}
