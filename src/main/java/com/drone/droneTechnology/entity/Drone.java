package com.drone.droneTechnology.entity;


import com.drone.droneTechnology.enums.DroneModel;
import com.drone.droneTechnology.enums.DroneState;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Builder
@Table(name = "Drone")
public class Drone implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SERIALNO", unique = true)
    private String serialNumber;

    @Column(name = "MODEL")
    @Enumerated(EnumType.STRING)
    private DroneModel model;

    @Column(name = "WEIGHT_LIMIT")
    private String weightLimit;

    @Column(name = "BATTERY_CAPACITY")
    private String batteryCapacity;

    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    private DroneState state;

    @OneToMany(mappedBy = "drone", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Medication> medications;
}
