package com.ludwigstralewiren.admin;

import com.ludwigstralewiren.account.Account;
import com.ludwigstralewiren.account.AccountDao;
import com.ludwigstralewiren.account.AccountDaoImpl;
import com.ludwigstralewiren.investment.Investment;
import com.ludwigstralewiren.investment.InvestmentDao;
import com.ludwigstralewiren.investment.InvestmentDaoImpl;
import com.ludwigstralewiren.user.User;
import com.ludwigstralewiren.user.UserDao;
import com.ludwigstralewiren.user.UserDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.hibernate.annotations.Proxy;


@SuppressWarnings("Duplicates")
public class adminController {

    @FXML

    public Button createInvestmentBtn;
    public Button deleteInvestmentBtn;
    public Button updateInvestmentBtn;
    public Button getInvestmentsBtn;
    public Button createAccountBtn;
    public Button deleteAccountBtn;
    public Button updateAccountBtn;
    public TextField field1;
    public TextField field2;
    public TextFlow result;
    public TextField fieldID;
    public Button CreateUserBtn;
    public Button deleteUserBtn;
    public Button UpdateUserBtn;
    public Button getUsersBtn;


    private UserDao userDao = new UserDaoImpl();
    private AccountDao accountDao = new AccountDaoImpl();
    private InvestmentDao investmentDao = new InvestmentDaoImpl();


    public void createUser(ActionEvent actionEvent) {
        result.getChildren().clear();
        String f = field1.getText();
        String l = field2.getText();
        User user = new User();
        user.setUserName(f);
        user.setLastName(l);
        userDao.save(user);
        result.getChildren().add(new Text((String.valueOf(user))));

    }

    public void deleteUser(ActionEvent actionEvent) {
        result.getChildren().clear();
        Long id = Long.parseLong(fieldID.getText());
        User usr = userDao.findById(id);
        userDao.delete(usr);
        result.getChildren().add(new Text(String.valueOf("USER HAS BEEN DELETED" + usr)));
    }

    public void UpdateUser(ActionEvent actionEvent) {
        String f = field1.getText();
        String l = field2.getText();
        Long id = Long.parseLong(fieldID.getText());
        User usr = userDao.findById(id);

        usr.setUserName(f);
        usr.setLastName(l);
        userDao.update(usr);
        result.getChildren().clear();
        result.getChildren().add(new Text(String.valueOf("USER HAS BEEN UPDATED TO " + usr)));
    }

    public void GetAllUsers(ActionEvent actionEvent) {
        result.getChildren().clear();
        userDao.findAll().forEach(user -> result.getChildren().add(new Text(String.valueOf("  " + user + "  "))));
    }

    public void createAccount(ActionEvent actionEvent) {
        result.getChildren().clear();
        String aT = field1.getText();
        Account account = new Account();
        account.setAccountType(aT);
        accountDao.save(account);
        result.getChildren().add(new Text((String.valueOf("ACCOUNT CREATED:  " + account))));
    }

    public void deleteAccount(ActionEvent actionEvent) {
        result.getChildren().clear();
        Long id = Long.parseLong(fieldID.getText());
        Account acc = accountDao.findById(id);
        System.out.println(acc);
        accountDao.delete(acc);
        result.getChildren().add(new Text(String.valueOf("ACCOUNT HAS BEEN DELETED " + acc)));
    }

    public void updateAccount(ActionEvent actionEvent) {
        Long id = Long.parseLong(fieldID.getText());
        Account acc = accountDao.findById(id);
        String aT = field1.getText();
        acc.setAccountType(aT);
        accountDao.update(acc);
        result.getChildren().clear();
        result.getChildren().add(new Text(String.valueOf(acc)));
    }

    public void GetAllAccounts(ActionEvent actionEvent) {
        result.getChildren().clear();
        accountDao.findAll().forEach(acc -> result.getChildren().add(new Text(String.valueOf(acc))));
    }

    public void createInvestment(ActionEvent actionEvent) {
        result.getChildren().clear();
        String n = field1.getText();
        Double v = Double.parseDouble(field2.getText());
        Long aId = Long.parseLong(fieldID.getText());
        Investment investment = new Investment();
        investment.setCurrentValue(v);
        investment.setName(n);
        Account account = accountDao.findById(aId);
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
        Double v = Double.parseDouble(field2.getText());
        Long id = Long.parseLong(fieldID.getText());
        Investment inv = investmentDao.findById(id);
        inv.setName(n);
        inv.setCurrentValue(v);
        inv.setAccount(accountDao.findById(Long.parseLong(fieldID.getText())));
        investmentDao.update(inv);
        result.getChildren().add(new Text((String.valueOf("INVESTMENT UPDATED:  " + inv))));
    }

    public void GetAllInvestments(ActionEvent actionEvent) {
        result.getChildren().clear();
        investmentDao.findAll().forEach(inv -> result.getChildren().add(new Text(String.valueOf(inv))));
        Long id = Long.parseLong(fieldID.getText());

        Account acc =accountDao.findById(id);
        acc.getInvestments().forEach(inv -> result.getChildren().add(new Text(String.valueOf(inv))));

    }


}
