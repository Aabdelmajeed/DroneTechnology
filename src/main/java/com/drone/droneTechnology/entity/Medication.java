package com.drone.droneTechnology.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Medication")
public class Medication implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "WEIGHT")
    private String weight;

    @Column(name = "IMAGE")
    private Blob image;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "droneMedicationID.medication")
    private Set<DroneMedication> droneMedications;
}
