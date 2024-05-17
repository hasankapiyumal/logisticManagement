package com.zaviron.ejb.impl;

import com.zaviron.ejb.remote.TimerService;
import jakarta.annotation.Resource;
import jakarta.ejb.*;

@Stateless
public class TimerServiceImpl implements TimerService {
    @Resource
    SessionContext sessionContext;
    Timer timer;

    @Override
    public void schedule() {
        ScheduleExpression se = new ScheduleExpression();
        se.hour("*");
        se.minute("*");
        se.second("*");
        //  Timer timer = context.getTimerService().createTimer(duration, "My Custom timer");
        timer = sessionContext.getTimerService().createCalendarTimer(se);
    }

    @Timeout
    @Override
    public void run() {
        System.out.println("Hello, This is schedule task...");
    }
}
