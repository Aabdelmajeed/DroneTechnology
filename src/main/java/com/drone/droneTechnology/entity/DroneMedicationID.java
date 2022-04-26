package com.drone.droneTechnology.entity;


import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class DroneMedicationID implements Serializable {

    @ManyToOne
    private Drone drone;

    @ManyToOne
    private Medication medication;
}
