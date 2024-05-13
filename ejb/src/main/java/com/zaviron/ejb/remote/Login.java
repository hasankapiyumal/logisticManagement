package com.zaviron.ejb.remote;

import com.zaviron.ejb.entity.User;
import jakarta.ejb.Remote;

@Remote
public interface Login {
    public String login(String email, String password);
}
