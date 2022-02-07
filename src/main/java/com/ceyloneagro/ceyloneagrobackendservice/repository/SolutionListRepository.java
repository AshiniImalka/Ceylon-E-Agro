package com.ceyloneagro.ceyloneagrobackendservice.repository;

import com.ceyloneagro.ceyloneagrobackendservice.repository.domain.SolutionList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface SolutionListRepository extends PagingAndSortingRepository<SolutionList, Long> {

    Page<SolutionList> findByDiseaseName(String disease,Pageable pageableRequest);
}
