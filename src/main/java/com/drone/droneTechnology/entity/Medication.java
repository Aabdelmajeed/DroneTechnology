package com.drone.droneTechnology.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Medication")
public class Medication {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "IMAGE")
    private Blob image;

    @ManyToOne
    @JoinColumn(name = "DRONE_ID")
    private Drone drone;

}
