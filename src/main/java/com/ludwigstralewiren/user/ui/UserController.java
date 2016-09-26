package com.ludwigstralewiren.user.ui;

import com.ludwigstralewiren.user.User;
import com.ludwigstralewiren.user.UserDao;
import com.ludwigstralewiren.user.UserDaoImpl;
import com.sun.javafx.tk.Toolkit;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by Ludwig on 9/18/2016.
 */
public class UserController {

    private static UserDao userDao = new UserDaoImpl();

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    private User activeUser;

    //    ~~~~~~~~~~~~~~~~FIELDS OF SIGN-UP PAGE~~~~~~~~~~~~~~
    @FXML
    private TextField username;

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;

//    ~~~~~~~~~~~~~~FIELDS OF USER PAGE~~~~~~~~~~~~~~~~~~~~

    @FXML
    private Text userFname;
    @FXML
    private Text userLname;
    @FXML
    private Text userEmail;
    @FXML
    private Text userPhone;

    public void addUser(ActionEvent actionEvent) throws IOException, InterruptedException {


        String f = firstName.getText();
        String l = lastName.getText();
        String m = email.getText();
        String nr = phone.getText();
        if (f.isEmpty() || l.isEmpty() || m.isEmpty() || nr.isEmpty()) {
            System.out.println("INCORRECT INPUT");
        } else {
            User user = new User();

            System.out.println(user);

            goToUser(actionEvent, user);
            userDao.save(user);
        }
//        goTo(actionEvent, "user-page");
    }

    public void deleteUser(ActionEvent actionEvent) throws IOException {
//        Long id = Long.parseLong(firstName.getText().trim());
        userDao.delete(activeUser);
        goTo(actionEvent, "login");
    }

    public void goToSignUp(ActionEvent actionEvent) throws IOException {
        goTo(actionEvent, "sign-up");
    }

    public void goToLogin(ActionEvent actionEvent) throws IOException {
        goTo(actionEvent, "login");
    }

    public void goToUser(ActionEvent actionEvent, User user) throws IOException {
//        TODO: Get the user by username that is signed in on LOGIN PAGE

//        TODO: Make an optional parameter that will only use when from SIGN UP PAGE

//        TODO: Make it possible to get active USER and assign the USER INFO FIELDS with it

//        activeUser = userDao.findById(Long.parseLong(username.getText()));

        setActiveUser(user);

        System.out.println(activeUser);


        userLname.setText(activeUser.getLastName());
        goTo(actionEvent, "user-page");
//        userPhone.setText(String.valueOf(activeUser.getPhone()));


    }

    public void goToUser(ActionEvent actionEvent) throws IOException {

        activeUser = userDao.findById(Long.parseLong(username.getText()));

        System.out.println(activeUser);


    }

    public void goToAdmin(ActionEvent actionEvent) throws IOException {
        if (username.getText().equals("admin")){
        }
        goTo(actionEvent, "admin");
    }

    private void goTo(ActionEvent actionEvent, String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/" + fxml + ".fxml"));
        Scene scene = new Scene(root, 500, 500);
        Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }




    // SHOULD THIS BE USED????????
    public void findUsers(ActionEvent actionEvent) {

        /*userDao.findAll().forEach(user -> output.getChildren().add(new Text(user.getUserName())));
        userDao.findAll().forEach(System.out::println);*/


    }

    public void test(ActionEvent actionEvent) {



//        userDao.findAll().forEach(user -> output.getChildren().add(new Text(user.getUserName())));
        userDao.findAll().forEach(System.out::println);
    }
}
