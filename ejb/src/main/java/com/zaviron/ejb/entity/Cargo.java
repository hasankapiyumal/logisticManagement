package com.zaviron.ejb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originLocation;
    private String destinationLocation;
    private String currentLocation;
    private String status;
    private String details;

    public Cargo() {
    }

    public Cargo(String originLocation, String destinationLocation, String currentLocation, String status, String details) {

        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.currentLocation = currentLocation;
        this.status = status;
        this.details = details;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cargo cargo = (Cargo) o;

        if (!Objects.equals(id, cargo.id)) return false;
        if (!Objects.equals(originLocation, cargo.originLocation))
            return false;
        if (!Objects.equals(destinationLocation, cargo.destinationLocation))
            return false;
        if (!Objects.equals(currentLocation, cargo.currentLocation))
            return false;
        if (!Objects.equals(status, cargo.status)) return false;
        return Objects.equals(details, cargo.details);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (originLocation != null ? originLocation.hashCode() : 0);
        result = 31 * result + (destinationLocation != null ? destinationLocation.hashCode() : 0);
        result = 31 * result + (currentLocation != null ? currentLocation.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", originLocation='" + originLocation + '\'' +
                ", destinationLocation='" + destinationLocation + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
