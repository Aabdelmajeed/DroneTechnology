package com.drone.droneTechnology.repo;

import com.drone.droneTechnology.entity.DroneMedication;
import com.drone.droneTechnology.entity.DroneMedicationID;
import com.drone.droneTechnology.enums.MedicationState;
import org.springframework.data.repository.CrudRepository;

public interface DroneMedicationRepo extends CrudRepository<DroneMedication, DroneMedicationID> {
}
