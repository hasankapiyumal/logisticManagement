package com.zaviron.ejb.remote;

import com.zaviron.ejb.entity.Cargo;
import jakarta.ejb.Remote;

@Remote
public interface UpdateCargo {
    public Cargo viewSelectedCargoDetails(Long id);
    public Cargo updateCargo(Long id,String currentLocation,String originLocation,String destinationLocation, String status,String details);
}
