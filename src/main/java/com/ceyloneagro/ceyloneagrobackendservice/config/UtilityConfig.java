package com.ceyloneagro.ceyloneagrobackendservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UtilityConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}