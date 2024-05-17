package com.zaviron.ejb.impl;

import com.zaviron.ejb.entity.Cargo;
import com.zaviron.ejb.interceptors.RouteInterceptor;
import com.zaviron.ejb.interceptors.TrafficInterceptor;
import com.zaviron.ejb.interceptors.WeatherInterceptor;
import com.zaviron.ejb.remote.AddCargo;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.interceptor.Interceptors;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class AddCargoImpl implements AddCargo {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Interceptors({RouteInterceptor.class, TrafficInterceptor.class, WeatherInterceptor.class})
    public Long addCargo(String current_location, String origin_location, String destination, String status, String details) {
        Cargo  cargo = new Cargo(origin_location, destination, current_location, status, details);
        entityManager.persist(cargo);
        entityManager.flush(); // Force immediate ID generation
        Long  cargoId = cargo.getId(); // Get the generated ID here
        System.out.println("Cargo created with ID: " + cargoId);
        return cargoId;


    }



}
