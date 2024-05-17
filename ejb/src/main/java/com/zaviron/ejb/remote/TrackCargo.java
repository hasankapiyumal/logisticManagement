package com.zaviron.ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface TrackCargo {
public String cargoTracking(Long id);
}
