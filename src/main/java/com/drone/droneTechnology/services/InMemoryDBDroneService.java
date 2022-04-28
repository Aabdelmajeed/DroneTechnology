package com.drone.droneTechnology.services;

import com.drone.droneTechnology.dto.DroneDTO;
import com.drone.droneTechnology.dto.MedicationDTO;
import com.drone.droneTechnology.entity.Drone;
import com.drone.droneTechnology.entity.Medication;
import com.drone.droneTechnology.enums.DroneState;
import com.drone.droneTechnology.repo.DroneRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Qualifier("inMemoryDBDroneService")
public class InMemoryDBDroneService implements IDroneService {

    DroneRepo droneRepo;

    @Override
    public void registerDrone(DroneDTO droneDTO) {
        Drone drone = mapDtoToDroneEntity(droneDTO);
        droneRepo.save(drone);
    }

    @Override
    public void loadMedicationToDroneWithSerialNumber(String serialNumber, List<MedicationDTO> MedicationList) throws Exception {
        Drone drone = droneRepo.findBySerialNumber(serialNumber);
        if (isDroneAvalible(drone) && isDroneAbleToLoadMedicationList(drone, MedicationList)) {
            List<Medication> medications = mapMedicationDtoToMedicationList(MedicationList, drone);
            drone.getMedications().addAll(medications);
            droneRepo.save(drone);
        } else {
            throw new Exception("Drone is not available or is loaded");

        }

    }

    @Override
    public List<DroneDTO> getAvailableDrones() {
        return mapDroneListToDTOList(droneRepo.findByState(DroneState.IDLE));
    }

    @Override
    public List<DroneDTO> getAllDrones() {
        List<Drone> drones = new ArrayList<>();
        droneRepo.findAll().forEach(drones::add);
        return mapDroneListToDTOList(drones);
    }

    @Override
    public String getBatteryLevel(String serialNumber) {
        Drone drone = droneRepo.findBySerialNumber(serialNumber);
        return drone.getBatteryCapacity();
    }

    @Override
    public List<MedicationDTO> getLoadedMedicationItemForDrone(String serialNumber) {
        Drone drone = droneRepo.findBySerialNumber(serialNumber);
        return mapMedicationListToMedicationDTO(drone.getMedications());
    }

    private boolean isDroneAbleToLoadMedicationList(Drone drone, List<MedicationDTO> medicationList) {
        double sizeOfCurrentlyMedicationSize = getMedicationListSize(mapMedicationListToMedicationDTO(drone.getMedications()));
        double medicationListSize = getMedicationListSize(medicationList);
        return Double.parseDouble(drone.getWeightLimit()) >= (medicationListSize + sizeOfCurrentlyMedicationSize);
    }

    private double getMedicationListSize(List<MedicationDTO> medicationList) {
        return medicationList.stream().mapToDouble(dto -> Double.parseDouble(dto.getWeight())).sum();
    }


    private boolean isDroneAvalible(Drone drone) {
        return (DroneState.IDLE == drone.getState()) || (DroneState.LOADING == drone.getState() && Double.parseDouble(drone.getBatteryCapacity()) > 25);
    }

    private List<Medication> mapMedicationDtoToMedicationList(List<MedicationDTO> medicationDTOList, Drone drone) {
        return medicationDTOList.stream()
                .map(MedicationDTO -> {
                    Medication medication = modelMapper().map(MedicationDTO, Medication.class);
                    medication.setDrone(drone);
                    return medication;
                }).collect(Collectors.toList());
    }

    private List<MedicationDTO> mapMedicationListToMedicationDTO(List<Medication> medicationList) {
        return medicationList.stream()
                .map(medication -> modelMapper().map(medication, MedicationDTO.class))
                .collect(Collectors.toList());
    }

    private Drone mapDtoToDroneEntity(DroneDTO droneDTO) {
        return modelMapper().map(droneDTO, Drone.class);
    }

    private List<DroneDTO> mapDroneListToDTOList(List<Drone> droneList) {
        return droneList.stream()
                .map(drone -> modelMapper().map(drone, DroneDTO.class))
                .collect(Collectors.toList());
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
