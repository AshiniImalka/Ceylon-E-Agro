package com.ceyloneagro.ceyloneagrobackendservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SolutionResponse {

    @JsonProperty("solution_id")
    private Long solutionId;

    @JsonProperty("solution_code")
    private String solutionCode;

    @JsonProperty("solution")
    private String solution;

    @JsonProperty("solution_description")
    private String solutionDescription;

    @JsonProperty("rate_score")
    private Integer rateScore;

    @JsonProperty("solution_type")
    private String solutionType;
}
