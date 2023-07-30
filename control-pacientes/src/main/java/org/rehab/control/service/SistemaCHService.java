package org.rehab.control.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.rehab.control.dto.SistemaCHDto;
import org.rehab.control.entity.SistemaCH;
import org.rehab.control.repository.SistemaCHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SistemaCHService {
    @Autowired
    private SistemaCHRepository sistemaCHRepository;
    @Autowired
    private ModelMapper modelMapper;

    public SistemaCH create(SistemaCHDto sistemaCHDto) {
        SistemaCH sistemaCH = modelMapper.map(sistemaCHDto,SistemaCH.class);
        return sistemaCHRepository.save(sistemaCH);
    }

    public List<SistemaCH> getAll(){
        return sistemaCHRepository.findAll();
    }
    
}
