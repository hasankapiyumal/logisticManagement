package com.zaviron.ejb.impl;

import com.zaviron.ejb.remote.Login;
import jakarta.ejb.Stateless;

@Stateless
public class LoginImpl implements Login{
    @Override
    public boolean login(String email, String password) {
       if (email.equals("admin")&& password.equals("1234")){
           return true;
       }
       return false;
    }
}
