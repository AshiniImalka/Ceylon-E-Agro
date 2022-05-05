package com.ceyloneagro.ceyloneagrobackendservice.service.impl;

import com.ceyloneagro.ceyloneagrobackendservice.dto.response.SolutionResponse;
import com.ceyloneagro.ceyloneagrobackendservice.dto.response.SolutionsResponse;
import com.ceyloneagro.ceyloneagrobackendservice.repository.SolutionListRepository;
import com.ceyloneagro.ceyloneagrobackendservice.repository.domain.SolutionList;
import com.ceyloneagro.ceyloneagrobackendservice.service.SolutionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SolutionServiceImpl implements SolutionService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    SolutionListRepository repository;

    @Override
    public SolutionsResponse<List<SolutionResponse>> getSolutionList(int page, int limit, String disease) {

        List<SolutionResponse> solutionResponse = new ArrayList<>();
        SolutionsResponse returnValue = new SolutionsResponse();
        String diseaseDescription = null;

        if (page > 0)
            page = page - 1;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<SolutionList> resourcePage = repository.findByDiseaseName(disease, pageableRequest);
        List<SolutionList> resource = resourcePage.getContent();

        for (SolutionList entity : resource) {
            solutionResponse.add(mapper.map(entity, SolutionResponse.class));
            returnValue.setDisease(entity.getDiseaseName());
            returnValue.setDiseaseDescription(entity.getDiseaseDescription());

        }

        returnValue.setSolution(solutionResponse);
        returnValue.setCurrentPage(resourcePage.getNumber() + 1);
        returnValue.setTotalItems(resourcePage.getTotalElements());
        returnValue.setTotalPages(resourcePage.getTotalPages());


        return returnValue;
    }

}
