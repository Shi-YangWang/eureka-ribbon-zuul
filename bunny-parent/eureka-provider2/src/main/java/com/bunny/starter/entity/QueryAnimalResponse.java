package com.bunny.starter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryAnimalResponse {
    @JsonProperty
    private String status;

    @JsonProperty
    private String nodeId;
}
