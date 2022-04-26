package com.drone.droneTechnology.repo;

import com.drone.droneTechnology.entity.Medication;
import org.springframework.data.repository.CrudRepository;

public interface MedicationRepo extends CrudRepository<Medication, Long> {
}
