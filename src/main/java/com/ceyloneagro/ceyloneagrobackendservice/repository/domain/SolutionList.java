package com.ceyloneagro.ceyloneagrobackendservice.repository.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @Table(name = "corn_disease_solution_details")

    public class SolutionList {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Setter(AccessLevel.NONE)
        @Column(name = "solution_id")
        private Long id;

        @Column(name = "solution_code", length = 10, nullable = false, unique = true, updatable = true)
        private String solutionCode;

        @Column(name = "disease_name", length = 100, nullable = false,updatable = true)
        private String diseaseName;

        @Column(name = "disease_description", length = 1000, nullable = false,updatable = true)
        private String diseaseDescription;

        @Column(name = "solution", length = 100, nullable = false, unique = true, updatable = true)
        private String solution;

        @Column(name = "solution_description", length = 1000, nullable = false, unique = true, updatable = true)
        private String solutionDescription;

        @Column(name = "solution_type", length = 100, nullable = false,updatable = true)
        private String solutionType;

        @Column(name = "rate_score", length = 10, nullable = false,updatable = false)
        private Integer rateScore;

        @Column(name = "rate_count", length = 10, nullable = false,updatable = false)
        private Integer rateCount;
}
