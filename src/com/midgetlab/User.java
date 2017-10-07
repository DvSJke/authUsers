package com.midgetlab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private String alpha = "^[A-Za-z0-9]+";
    private String intValues = "^[0-9]+";

    public Boolean UserCheck(String username){
        Pattern pattern = null;

        pattern = Pattern.compile(alpha);
        Matcher regExp = pattern.matcher(username);

        return regExp.matches();
    }

    public Boolean IntCheck(int a){
        Pattern pattern = null;
        Integer age = a;
        pattern = Pattern.compile(intValues);
        Matcher regExp = pattern.matcher(age.toString());

        return regExp.matches();

    }


}
