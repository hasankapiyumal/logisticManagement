package com.zaviron.ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface AddCargo {
    public String addCargo(String current_location,String origin_location,String destination,String status,String details);
}
