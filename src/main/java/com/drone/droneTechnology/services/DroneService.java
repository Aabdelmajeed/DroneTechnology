package com.drone.droneTechnology.services;

import com.drone.droneTechnology.dto.DroneDTO;
import com.drone.droneTechnology.entity.Drone;
import com.drone.droneTechnology.repo.DroneRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Service
@AllArgsConstructor
@RestControllerAdvice
public class DroneService {
    DroneRepo droneRepo;

    public void registerDrone(DroneDTO droneDTO) {
        Drone drone = mapDtoToDroneEntity(droneDTO);
        droneRepo.save(drone);
    }

    private Drone mapDtoToDroneEntity(DroneDTO droneDTO) {
        return Drone.builder()
                .serialNumber(droneDTO.getSerialNumber())
                .model(droneDTO.getDroneModel())
                .weightLimit(String.valueOf(droneDTO.getWeightLimit()))
                .batteryCapacity(String.valueOf(droneDTO.getBatteryCapacity()))
                .state(droneDTO.getDroneState())
                .build();
    }
}
