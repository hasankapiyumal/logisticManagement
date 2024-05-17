package com.zaviron.ejb.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

import java.util.Map;
import java.util.Random;

public class RouteInterceptor {
    @AroundInvoke
    public Object intercept(InvocationContext invocationContext) throws Exception {
        String currentLocation = (String) invocationContext.getParameters()[0];
        String originLocation = (String) invocationContext.getParameters()[1];
        String destination = (String) invocationContext.getParameters()[2];
        String status = (String) invocationContext.getParameters()[3];
        String details = (String) invocationContext.getParameters()[4];
        Map<String, Object> contextData = invocationContext.getContextData();
        if (status.equals("processing")) {
            contextData.put("selectedRoad","NONE");
            contextData.put("estimatedTime",0);
        } else {
            Random random = new Random();
            int randomNumber = random.nextInt(3);
            String selectedRoad = "";
            int estimatedTime = 0;
            if (randomNumber == 0) {
                selectedRoad = "ABC ROAD";
                estimatedTime = 1;
            } else if (randomNumber == 1) {
                selectedRoad = "DEF ROAD";
                estimatedTime = 2;
            } else if (randomNumber == 2) {
                selectedRoad = "GHI ROAD";
                estimatedTime = 3;
            }

            contextData.put("selectedRoad",selectedRoad);
            contextData.put("estimatedTime",estimatedTime);
        }

        return invocationContext.proceed();

    }
}
