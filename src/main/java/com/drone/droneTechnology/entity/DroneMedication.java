package com.drone.droneTechnology.entity;

import com.drone.droneTechnology.enums.DroneState;
import com.drone.droneTechnology.enums.MedicationState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Drone_Medication")
public class DroneMedication implements Serializable {

    @EmbeddedId
    private DroneMedicationID droneMedicationID;

    @Column(name = "MedicationState")
    @Enumerated(EnumType.STRING)
    private MedicationState status;

    @Column(name = "operationTime")
    private String operationTime;

}
