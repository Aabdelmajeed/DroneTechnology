package com.drone.droneTechnology.services;

import com.drone.droneTechnology.dto.DroneDTO;
import com.drone.droneTechnology.dto.MedicationDTO;

import java.util.List;

public interface IDroneService {
    void registerDrone(DroneDTO droneDTO);

    void loadMedicationToDroneWithSerialNumber(String serialNumber, List<MedicationDTO> MedicationList) throws Exception;

    List<DroneDTO> getAvailableDrones();

    List<DroneDTO> getAllDrones();

    String getBatteryLevel(String serialNumber);

    List<MedicationDTO> getLoadedMedicationItemForDrone(String serialNumber);
}
