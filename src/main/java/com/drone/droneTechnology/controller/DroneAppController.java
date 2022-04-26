package com.drone.droneTechnology.controller;


import com.drone.droneTechnology.dto.DroneDTO;
import com.drone.droneTechnology.model.DroneResponseModel;
import com.drone.droneTechnology.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroneAppController {

    @Autowired
    DroneService droneService;

    @PostMapping(value = "/drone/register",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<DroneResponseModel> registerDrone(@RequestBody DroneDTO droneDTO) throws Exception {
        droneService.registerDrone(droneDTO);
        DroneResponseModel droneResponseModel = DroneResponseModel.builder()
                                                                 .description("Drone Registered Successfly")
                                                                  .build();
        return new ResponseEntity<DroneResponseModel>(droneResponseModel, HttpStatus.OK);
    }
}
