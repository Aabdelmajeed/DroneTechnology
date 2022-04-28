package com.drone.droneTechnology.task;

import com.drone.droneTechnology.dto.DroneDTO;
import com.drone.droneTechnology.services.IDroneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class DroneBatterTask {

    private final Logger droneLogger = LoggerFactory.getLogger("DroneLogger");
    IDroneService droneService;

    @Scheduled(fixedRateString = "${BatteryCheckTaskPeriod}")
    public void checkBatteryForDrones() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Drones [SerialNumber:BatteryLevel] :  ");
        List<DroneDTO> droneDTOList = droneService.getAllDrones();
        for (DroneDTO droneDTO : droneDTOList) {
            String droneBatteryLog = "[" + droneDTO.getSerialNumber() + ":" + String.valueOf(droneDTO.getBatteryCapacity()) + "%]";
            stringBuilder.append(droneBatteryLog);
        }
        droneLogger.info(stringBuilder.toString());
    }
}
