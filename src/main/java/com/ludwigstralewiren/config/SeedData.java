package com.ludwigstralewiren.config;

import com.ludwigstralewiren.user.User;
import com.ludwigstralewiren.user.UserDao;
import com.ludwigstralewiren.user.UserDaoImpl;

/**
 * Created by ludwi on 2016-09-22.
 */
/*
public class SeedData {
    private static UserDao userDao = new UserDaoImpl();

    private static String[] names = {"Sven", "Ludwig", "Linn", "Patrick", "Camilla"};
    private static String[] lastNames = {"Svensson", "Karlsson", "Wiren", "Armansson"};
    private static Long[] numbers = {7121192L, 0702141L, 151515L, 9823562386L};
    private static String[] emails = {"ludwigo@hotmail.com", "svensio@gmail.com", "karsson@dond.se", "snygooas@sve.com"};

    public static void insertUsers() {
        for (int i = 1; i <= 4; i++) {
            User usr = new User.UserBuilder(names[i], lastNames[i])
                    .withEmail(emails[i])
                    .withPhone(numbers[i])
                    .build();
            userDao.save(usr);
        }


    }
}
*/
