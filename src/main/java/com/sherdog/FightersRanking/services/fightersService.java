package com.sherdog.FightersRanking.services;

import com.sherdog.FightersRanking.controllers.fightersController;
import com.sherdog.FightersRanking.domain.fighters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.sherdog.FightersRanking.repository.fightersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class fightersService {

    public fightersService(fightersRepository fighterRepo) {
        this.fighterRepo = fighterRepo;
    }

    private final Logger log = LoggerFactory.getLogger(fightersController.class);

    @Autowired
    private fightersRepository fighterRepo;

    public List<fighters> findAll() {
        return fighterRepo.findAll();
    }

    public fighters findById(Long id) {
        return fighterRepo.findById(id).orElse(null);
    }

    public fighters create(fighters fighter) {
        return fighterRepo.save(fighter);
    }

    public fighters update(fighters fighter) {
        return fighterRepo.save(fighter);
    }

    public void deleteById(Long id) {
        fighterRepo.deleteById(id);
    }

    public void deleteAll() {
        fighterRepo.deleteAll();
    }

    public List<fighters> findByName(String name) {
        return fighterRepo.findByName("%" + name + "%");
    }
}