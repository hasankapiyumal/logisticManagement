package com.zaviron.ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface DeliverCargo {
    public void time(Long id);
    public void run();
}
