package com.zaviron.ejb.impl;

import com.zaviron.ejb.entity.Cargo;
import com.zaviron.ejb.exception.CargoNotFoundException;
import com.zaviron.ejb.remote.TrackCargo;
import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TrackCargoImpl implements TrackCargo {
    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private UserTransaction userTransaction;
  //  private Long id;
    @Resource
    SessionContext sessionContext;
    Timer timer;


    @Override
    public String cargoTracking(Long id) {
//        if (this.id == null) {
//            this.id = id;
//        }

        try {
            Cargo cargo = entityManager.createNamedQuery("Cargo.findById", Cargo.class).setParameter(1, id).getSingleResult();
            if (cargo != null) {
                String currentLocation = cargo.getCurrentLocation();
                String status = cargo.getStatus();
                String destinationLocation = cargo.getDestinationLocation();
                String originLocation = cargo.getOriginLocation();
                try {
                    userTransaction.begin();
                    Cargo merge = entityManager.merge(cargo);
                    System.out.println(merge.getId());
                    userTransaction.commit();

                } catch (Exception e) {
                    try {
                        userTransaction.rollback();
                    } catch (SystemException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                return "currentLocation : " + currentLocation;
            } else {
                throw new CargoNotFoundException("Cargo Not Found");
            }
        } catch (NoResultException e) {
            throw new CargoNotFoundException("Cargo Not Found");
        }

    }

    @Override
    public void time(Long id) {
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression.hour("*");
        scheduleExpression.minute("*");
        scheduleExpression.second("*");
        timer=sessionContext.getTimerService().createCalendarTimer(scheduleExpression);



    }

    @Timeout
    @Override
    public void run() {
        String s = cargoTracking(1L);

        System.out.println("cargo Tracking : "+s);
        System.out.println("cargo Tracking : ");
    }
}
