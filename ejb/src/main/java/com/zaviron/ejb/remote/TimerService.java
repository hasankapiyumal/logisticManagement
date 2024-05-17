package com.zaviron.ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface TimerService {
    public void schedule();
    public void run();
}
