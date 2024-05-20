package com.zaviron.ejb.impl;

import com.zaviron.ejb.entity.Cargo;
import com.zaviron.ejb.exception.CargoNotFoundException;
import com.zaviron.ejb.remote.DeliverCargo;
import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

import java.util.List;
import java.util.Random;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DeliverCargoImpl implements DeliverCargo {
    @PersistenceContext
    private EntityManager entityManager;
    @Inject
    private UserTransaction userTransaction;
    @Resource
    private SessionContext sessionContext;
    Timer timer;
    Long cargoId = 1L;

    @Override
    public void time(Long id) {
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression.hour("*");
        scheduleExpression.minute("*");
        scheduleExpression.second("*");
        timer = sessionContext.getTimerService().createCalendarTimer(scheduleExpression);
        cargoId = id;
    }

    @Timeout
    @Override
    public void run() {

        try {
            Cargo cargo = entityManager.createNamedQuery("Cargo.findById", Cargo.class).setParameter(1, cargoId).getSingleResult();
            if (cargo != null) {
                String currentLocation = cargo.getCurrentLocation();
                String status = cargo.getStatus();
                String destinationLocation = cargo.getDestinationLocation();
                String originLocation = cargo.getOriginLocation();
                String[] cities = {
                        "Colombo",
                        "Galle",
                        "Kandy",
                        "Anuradhapura",
                        "Matara",
                        "Negombo",
                        "Kalutara",
                        "Ratnapura",
                        "Kurunegala",
                        "Badulla",
                        "Avissawella",
                        "Embilipitiya",
                        "Kataragama",
                        "Beliatta",
                        "Chilaw",
                        "Nuwara Eliya",
                        "Ampara",
                        "Hambantota",
                        "Tangalle",
                        "Weligama",
                        "Mirissa",
                        "Hikkaduwa",
                        "Unawatuna",
                        "Bentota",
                        "Sigiriya",
                        "Dambulla",
                        "Polonnaruwa",
                        "Ella",
                        "Haputale",
                        "Bandarawela",
                        "Monaragala",
                        "Kegalle",
                        "Matale",
                        "Gampaha",

                };
                Random random =new Random();
                int randomIndex = random.nextInt(cities.length);
                String randomCity = cities[randomIndex];
                cargo.setCurrentLocation(randomCity);


                if (cargo.getCurrentLocation().equals(destinationLocation)) {
                    timer.cancel();
                    cargo.setStatus("Delivered");
                    System.out.println("stop");
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

                }
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
                System.out.println("currentLocation : " + currentLocation);
            } else {
                throw new CargoNotFoundException("Cargo Not Found");
            }
        } catch (NoResultException e) {
            throw new CargoNotFoundException("Cargo Not Found");
        }
    }
}
