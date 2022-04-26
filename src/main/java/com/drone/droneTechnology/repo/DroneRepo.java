package com.drone.droneTechnology.repo;

import com.drone.droneTechnology.entity.Drone;
import org.springframework.data.repository.CrudRepository;

public interface DroneRepo extends CrudRepository<Drone, Long> {
}
