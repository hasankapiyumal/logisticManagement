package com.zaviron.ejb.impl;

import com.zaviron.ejb.entity.Cargo;
import com.zaviron.ejb.remote.UpdateCargo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class UpdateCargoImpl implements UpdateCargo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cargo viewSelectedCargoDetails(Long id) {
        Cargo cargo = entityManager.createNamedQuery("Cargo.findById", Cargo.class).setParameter(1, id).getSingleResult();
        return cargo;
    }

    @Override
    public Cargo updateCargo(Long id, String currentLocation, String originLocation, String destinationLocation, String status, String details) {
        Cargo cargo = entityManager.createNamedQuery("Cargo.findById", Cargo.class).setParameter(1, id).getSingleResult();
        cargo.setCurrentLocation(currentLocation);
        cargo.setOriginLocation(originLocation);
        cargo.setDestinationLocation(destinationLocation);
        cargo.setStatus(status);
        cargo.setDetails(details);
        entityManager.persist(cargo);
        return cargo;
    }


}
