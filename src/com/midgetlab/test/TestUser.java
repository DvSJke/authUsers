package com.midgetlab.test;

import com.midgetlab.User;
public class TestUser {

    private static User check = new User();

    public static void main(String[] args) {
        String user = "zzsASiug1123sidbfHIYGTAYGSdffsa";
        if(check.UserCheck(user)) {
            System.out.println("Имя содерджит только буквы!");
        } else {
            System.out.println("Имя содержит посторониие символы!");
        }
    }
}
