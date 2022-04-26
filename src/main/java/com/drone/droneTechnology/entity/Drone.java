package com.drone.droneTechnology.entity;


import com.drone.droneTechnology.enums.DroneModel;
import com.drone.droneTechnology.enums.DroneState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
@Table(name = "Drone")
public class Drone implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "droneMedicationID.drone")
    private Set<DroneMedication> droneMedications;
}
