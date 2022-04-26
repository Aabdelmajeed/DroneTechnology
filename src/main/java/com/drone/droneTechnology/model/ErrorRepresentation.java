package com.drone.droneTechnology.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ErrorRepresentation {

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("status")
    private HttpStatus status;

}
