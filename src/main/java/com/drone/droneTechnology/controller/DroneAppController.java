package com.drone.droneTechnology.controller;


import com.drone.droneTechnology.dto.DroneDTO;
import com.drone.droneTechnology.dto.MedicationDTO;
import com.drone.droneTechnology.model.DroneResponseModel;
import com.drone.droneTechnology.model.ValidList;
import com.drone.droneTechnology.services.IDroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class DroneAppController {

    @Autowired
    @Qualifier("inMemoryDBDroneService")
    IDroneService droneService;

    @PostMapping(value = "/drone/register",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<DroneResponseModel> registerDrone(@RequestBody @Valid DroneDTO droneDTO) {

        droneService.registerDrone(droneDTO);
        DroneResponseModel droneResponseModel = DroneResponseModel.builder()
                .value("Drone Registered Successfly")
                .build();
        return new ResponseEntity<DroneResponseModel>(droneResponseModel, HttpStatus.OK);
    }


    @PostMapping(value = "/drone/{droneSerialNumber}/loadMedications",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<DroneResponseModel> loadMedication(@PathVariable("droneSerialNumber") String droneSerialNumber, @RequestBody @Valid ValidList<MedicationDTO> medicationList) throws Exception {
        droneService.loadMedicationToDroneWithSerialNumber(droneSerialNumber, medicationList);
        DroneResponseModel droneResponseModel = DroneResponseModel.builder()
                .value("Medication is loaded successfly")
                .build();
        return new ResponseEntity<DroneResponseModel>(droneResponseModel, HttpStatus.OK);
    }

    @GetMapping(value = "/drone/available",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<List<DroneDTO>> getAvalibleDrones() throws Exception {
        List<DroneDTO> availableDrones = droneService.getAvailableDrones();

        return new ResponseEntity<List<DroneDTO>>(availableDrones, HttpStatus.OK);
    }

    @GetMapping(value = "/drone/{droneSerialNumber}/batteryLevel",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<DroneResponseModel> getBatteryLevel(@PathVariable("droneSerialNumber") String droneSerialNumber) throws Exception {
        String batteryLevel = droneService.getBatteryLevel(droneSerialNumber);
        DroneResponseModel droneResponseModel = DroneResponseModel.builder()
                .value(batteryLevel)
                .build();
        return new ResponseEntity<DroneResponseModel>(droneResponseModel, HttpStatus.OK);
    }


    @GetMapping(value = "/drone/{droneSerialNumber}/getLoadedMedicationItem",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<List<MedicationDTO>> getLoadedMedicationItemsForGivenDrone(@PathVariable("droneSerialNumber") String droneSerialNumber) throws Exception {
        List<MedicationDTO> medicationListDTO = droneService.getLoadedMedicationItemForDrone(droneSerialNumber);
        return new ResponseEntity<List<MedicationDTO>>(medicationListDTO, HttpStatus.OK);
    }
}
