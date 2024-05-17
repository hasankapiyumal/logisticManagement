package com.zaviron.ejb.remote;

import com.zaviron.ejb.entity.Cargo;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface ViewCargo {

    public List<Cargo>getCargo();
}
