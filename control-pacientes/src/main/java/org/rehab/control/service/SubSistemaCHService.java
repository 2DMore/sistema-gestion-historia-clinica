package org.rehab.control.service;

import java.util.List;


import org.rehab.control.entity.SubSistemaCH;

import org.rehab.control.repository.SubSistemaCHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SubSistemaCHService {
    @Autowired
    private SubSistemaCHRepository subSistemaCHRepository;
    //@Autowired
   // private SubSistemaCH subSistemaCHRepository;
    /* 
    @Autowired
    private ModelMapper modelMapper;
*/
    public SubSistemaCH create(SubSistemaCH subSistemaCH) {
       
        return subSistemaCHRepository.save(subSistemaCH);
    }

    public List<SubSistemaCH> getAll(){
        return subSistemaCHRepository.findAll();
    }
}
