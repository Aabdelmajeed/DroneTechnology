package com.drone.droneTechnology.entity;


import com.drone.droneTechnology.enums.DroneModel;
import com.drone.droneTechnology.enums.DroneState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Drone")
public class Drone {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "SERIALNO")
    private String serialNumber;

    @Column(name = "MODEL")
    private DroneModel model;

    @Column(name = "WEIGHT_LIMIT")
    private String weightLimit;

    @Column(name = "BATTERY_CAPACITY")
    private String batteryCapacity;

    @Column(name = "STATE")
    private DroneState state;

    @OneToMany(mappedBy = "drone" , fetch = FetchType.EAGER , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Medication> medicationList;
}
