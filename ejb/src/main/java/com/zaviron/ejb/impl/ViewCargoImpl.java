package com.zaviron.ejb.impl;

import com.zaviron.ejb.entity.Cargo;
import com.zaviron.ejb.remote.ViewCargo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
@Stateless
public class ViewCargoImpl implements ViewCargo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Cargo> getCargo() {
        List<Cargo> cargo =new ArrayList<>();
        cargo = entityManager.createQuery("select c from Cargo c").getResultList();
        return cargo;
    }
}
