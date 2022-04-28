package com.drone.droneTechnology.repo;

import com.drone.droneTechnology.entity.Drone;
import com.drone.droneTechnology.enums.DroneState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DroneRepo extends CrudRepository<Drone, Serializable> {
    Drone findBySerialNumber(String serialNumber);
    List<Drone> findByState(DroneState state);
}
