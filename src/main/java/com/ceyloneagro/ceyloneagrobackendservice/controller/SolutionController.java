package com.ceyloneagro.ceyloneagrobackendservice.controller;

import com.ceyloneagro.ceyloneagrobackendservice.dto.response.BaseResponse;
import com.ceyloneagro.ceyloneagrobackendservice.dto.response.SolutionsResponse;
import com.ceyloneagro.ceyloneagrobackendservice.enumeration.ApplicationStatus;
import com.ceyloneagro.ceyloneagrobackendservice.service.SolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/")

public class SolutionController {

    private final SolutionService solutionService;

    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping(value = "/solutions", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<SolutionsResponse>> getSolutionList(HttpServletRequest request, @RequestParam
            (value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "25") int limit,
                                                                           @RequestParam String disease) {

        SolutionsResponse response=solutionService.getSolutionList(page,limit,disease);

        BaseResponse<SolutionsResponse> baseResponse = new BaseResponse<>(ApplicationStatus.TOKEN_GENERATION_SUCCESS, response);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}