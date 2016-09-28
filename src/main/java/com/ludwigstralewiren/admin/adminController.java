package com.ludwigstralewiren.admin;

import com.ludwigstralewiren.account.*;
import com.ludwigstralewiren.account.AccountService;
import com.ludwigstralewiren.investment.Investment;
import com.ludwigstralewiren.investment.InvestmentDao;
import com.ludwigstralewiren.investment.H2InvestmentDao;
import com.ludwigstralewiren.user.User;
import com.ludwigstralewiren.user.UserDao;
import com.ludwigstralewiren.user.UserDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


@SuppressWarnings("Duplicates")
public class adminController {


    /*    public Button createInvestmentBtn;
        public Button deleteInvestmentBtn;
        public Button updateInvestmentBtn;
        public Button getInvestmentsBtn;
        public Button createAccountBtn;
        public Button deleteAccountBtn;
        public Button updateAccountBtn;*/
/*
    public Button CreateUserBtn;
    public Button deleteUserBtn;
    public Button UpdateUserBtn;
    public Button getUsersBtn;
*/
    @FXML
    public TextField field1;
    public TextField field2;
    public TextFlow result;
    public TextField fieldID;

    // INIT DAO's
    private UserDao userDao = new UserDaoImpl();
    private AccountService accountService = new H2AccountService();
    private InvestmentDao investmentDao = new H2InvestmentDao();


    public void createUser(ActionEvent actionEvent) {
        result.getChildren().clear();

        if (Objects.equals(fieldID.getText(), "")) {
            String f = field1.getText();
            String l = field2.getText();
            User user = new User();

            user.setUserName(f);
            user.setLastName(l);

            userDao.save(user);
            result.getChildren().add(new Text(String.valueOf("USER HAS BEEN CREATED TO " + user)));
        } else {
            String f = field1.getText();
            String l = field2.getText();
            Long id = Long.parseLong(fieldID.getText());
            User usr = userDao.findById(id);
            usr.setUserName(f);
            usr.setLastName(l);
            userDao.save(usr);
            result.getChildren().clear();
            result.getChildren().add(new Text(String.valueOf("USER HAS BEEN UPDATED TO " + usr)));

        }


    }

    public void deleteUser(ActionEvent actionEvent) {
        result.getChildren().clear();
        Long id = Long.parseLong(fieldID.getText());
        User usr = userDao.findById(id);
        userDao.delete(usr);
        result.getChildren().add(new Text(String.valueOf("USER HAS BEEN DELETED" + usr)));
    }

    public void GetAllUsers(ActionEvent actionEvent) {
        result.getChildren().clear();
        userDao.findAll().forEach(user -> result.getChildren().add(new Text(String.valueOf("  " + user + "  "))));
    }

    public void createAccount(ActionEvent actionEvent) {
        result.getChildren().clear();
        String aT = field1.getText();
        if (Objects.equals(fieldID.getText(), "")) {
            Account account = new Account();
            account.setAccountType(aT);
            accountService.save(account);
            result.getChildren().add(new Text((String.valueOf("ACCOUNT CREATED:  " + account))));
        } else {
            Long id = Long.parseLong(fieldID.getText());
            Account acc = accountService.findById(id);
            acc.setAccountType(aT);
            accountService.save(acc);
            result.getChildren().add(new Text((String.valueOf("ACCOUNT UPDATED:  " + acc))));
        }
    }

    public void deleteAccount(ActionEvent actionEvent) {
        result.getChildren().clear();
        Long id = Long.parseLong(fieldID.getText());
        Account acc = accountService.findById(id);
        System.out.println(acc);
        accountService.delete(acc);
        result.getChildren().add(new Text(String.valueOf("ACCOUNT HAS BEEN DELETED " + acc)));
    }

    public void GetAllAccounts(ActionEvent actionEvent) {
        result.getChildren().clear();
        accountService.findAll().forEach(acc -> result.getChildren().add(new Text(String.valueOf(acc))));
    }

    public void createInvestment(ActionEvent actionEvent) {
        result.getChildren().clear();
        String n = field1.getText();
        Long v = Long.parseLong(field2.getText());
        Long aId = Long.parseLong(fieldID.getText());
        Account account = accountService.findById(aId);

        Investment investment = new Investment();
        investment.setCurrentValue(v);
        investment.setName(n);
        investment.setAccount(account);
        investmentDao.save(investment);

        result.getChildren().add(new Text((String.valueOf("INVESTMENT ADDED:  " + investment))));
    }

    public void deleteInvestment(ActionEvent actionEvent) {
        result.getChildren().clear();
        Long id = Long.parseLong(fieldID.getText());
        Investment inv = investmentDao.findById(id);
        investmentDao.delete(inv);
        result.getChildren().add(new Text((String.valueOf("INVESTMENT DELETED:  " + inv))));
    }

    public void updateInvestment(ActionEvent actionEvent) {
        result.getChildren().clear();
        String n = field1.getText();
        Long v = Long.parseLong(field2.getText());
        Long id = Long.parseLong(fieldID.getText());
        Investment inv = investmentDao.findById(id);
        inv.setName(n);
        inv.setCurrentValue(v);
        inv.setAccount(accountService.findById(Long.parseLong(fieldID.getText())));
        investmentDao.save(inv);
        result.getChildren().add(new Text((String.valueOf("INVESTMENT UPDATED:  " + inv))));
    }


    public void getAllInvestments(ActionEvent actionEvent) {
        result.getChildren().clear();
        investmentDao.findAll().forEach(inv -> result.getChildren().add(new Text(String.valueOf(inv))));
    }


    public void getAUser(ActionEvent actionEvent) {
        result.getChildren().clear();
        Long id = Long.parseLong(fieldID.getText());
        User user = userDao.findById(id);
        result.getChildren().add(new Text(String.valueOf(user)));

    }

    public void getAInvest(ActionEvent actionEvent) {
        result.getChildren().clear();
        Long id = Long.parseLong(fieldID.getText());
        accountService.findById(id).getInvestments().forEach(acc -> result.getChildren().add(new Text(String.valueOf(acc))));


    }

    public void getAAccount(ActionEvent actionEvent) {
        result.getChildren().clear();
        Long id = Long.parseLong(fieldID.getText());
        Account account = accountService.findById(id);
        result.getChildren().add(new Text((String.valueOf("FOUND ACCOUNT: " + account))));
    }

    public void getByName(ActionEvent actionEvent) {
        result.getChildren().clear();
        String name = fieldID.getText();
        List names = userDao.findUserByName(name);
        names.forEach(usr -> result.getChildren().add(new Text(String.valueOf(usr))));

    }
}
