package com.drone.droneTechnology.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Drone_Medication")
public class DroneMedication implements Serializable {

    @EmbeddedId
    private DroneMedicationID droneMedicationID;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "operationTime")
    private String operationTime;

}
