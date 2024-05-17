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
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;

import java.sql.SQLException;



@Stateless
public class AddCargoImpl implements AddCargo {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Interceptors({RouteInterceptor.class, TrafficInterceptor.class, WeatherInterceptor.class})
    public String addCargo(String current_location, String origin_location, String destination, String status, String details) {
        Cargo cargo = new Cargo(origin_location,destination,current_location,status,details);
        entityManager.persist(cargo);
        return "success";


    }
}
