package com.springdatatwo.dojosandninjas.services;

import com.springdatatwo.dojosandninjas.models.Dojo;
import com.springdatatwo.dojosandninjas.models.Ninja;
import com.springdatatwo.dojosandninjas.repositories.DojoRepository;
import com.springdatatwo.dojosandninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoNinjaService {
    private final DojoRepository dojoRepository;
    private final NinjaRepository ninjaRepository;

    public DojoNinjaService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository = ninjaRepository;
    }

    public Dojo createDojo(Dojo d){
        return dojoRepository.save(d);
    }

    public List<Dojo> allDojos(){
        return dojoRepository.findAll();
    }

    public Dojo findDojo(Long id){
        Optional<Dojo> dojoToFind = dojoRepository.findById(id);
        if (dojoToFind.isPresent())
            return dojoToFind.get();
        else
            return null;
    }

    public Ninja createNinja(Ninja n){
        return ninjaRepository.save(n);
    }

    public List<Ninja> NinjasOfDojo(Long id) {
        return ninjaRepository.findAllByDojo_Id(id);
    }







}
