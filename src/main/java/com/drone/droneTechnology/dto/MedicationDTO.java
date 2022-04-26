package com.drone.droneTechnology.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.sql.Blob;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicationDTO {
    @Pattern(regexp = "([A-Za-z0-9\\-\\_]+)" , message = "name is not in correct format")
    private String name;
    @Pattern(regexp = "([A-Z0-9\\_]+)" , message = "code is not in correct format")
    private String code;
    private String weight;
    private Blob image;
}
