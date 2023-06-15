package com.sherdog.FightersRanking.services;

import com.sherdog.FightersRanking.domain.fighters;
import org.springframework.beans.factory.annotation.Autowired;
import com.sherdog.FightersRanking.repository.fightersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class fightersService {

    private fightersRepository fightersRepository;

    public fightersService(fightersRepository fightersRepository) {
        this.fightersRepository = fightersRepository;
    }


    public Optional<fighters> findByName (String name){
        return fightersRepository.findByName(name);
    }
}
