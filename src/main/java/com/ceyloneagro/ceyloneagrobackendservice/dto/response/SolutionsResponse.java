package com.ceyloneagro.ceyloneagrobackendservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class SolutionsResponse<T> {

   @JsonProperty("disease")
    private String disease;

    @JsonProperty("solution")
    private T solution;

    @JsonProperty("currentPage")
    private Integer currentPage;

    @JsonProperty("totalItems")
    private Long totalItems;

    @JsonProperty("totalPages")
    private Integer totalPages;


}
