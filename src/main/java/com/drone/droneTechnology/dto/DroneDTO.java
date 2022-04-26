package com.drone.droneTechnology.dto;

import com.drone.droneTechnology.enums.DroneModel;
import com.drone.droneTechnology.enums.DroneState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DroneDTO {

    String serialNumber;
    DroneModel droneModel;
    double weightLimit;
    double batteryCapacity;
    DroneState droneState;
}
