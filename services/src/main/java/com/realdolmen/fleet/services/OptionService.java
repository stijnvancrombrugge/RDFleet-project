package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.Option;
import com.realdolmen.fleet.repositories.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SVCAX33 on 4/11/2015.
 */

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public List<Option> getAllOptions(){
        return optionRepository.findAll();
    }
}
