package com.ceyloneagro.ceyloneagrobackendservice.service;

import com.ceyloneagro.ceyloneagrobackendservice.dto.response.SolutionsResponse;

public interface SolutionService {

    SolutionsResponse getSolutionList(int page, int limit,String disease);
    //SolutionsResponse getSolutionListByName(int page, int limit,String disease);
}
