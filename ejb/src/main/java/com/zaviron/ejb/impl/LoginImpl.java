package com.zaviron.ejb.impl;

import com.zaviron.ejb.entity.User;
import com.zaviron.ejb.remote.Login;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class LoginImpl implements Login{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public String login(String email, String password) {
        User user = entityManager.createQuery("select u from User u where u.email=:email and u.password=:password", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        String userType;
        if (user != null) {
          userType = user.getUser_type();
        }else {
           userType="NONE";
        }
        System.out.println(userType);
        return userType;
    }
}
