package com.drone.droneTechnology.dto;

import com.drone.droneTechnology.enums.DroneModel;
import com.drone.droneTechnology.enums.DroneState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DroneDTO {

    @Size(max = 100, message = "serialNumber must be 100 character maximum")
    String serialNumber;
    DroneModel droneModel;
    double weightLimit;
    double batteryCapacity;
    DroneState droneState;
}
