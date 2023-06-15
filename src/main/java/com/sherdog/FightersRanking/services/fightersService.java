package com.sherdog.FightersRanking.services;

import com.sherdog.FightersRanking.domain.fighters;
import org.springframework.beans.factory.annotation.Autowired;
import com.sherdog.FightersRanking.repository.fightersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

public  String enviarDatosFP(Long id){
        Optional <fighters> fightersOpt = fightersRepository.findById(id);
        if(fightersOpt.isPresent()){
           return fightersOpt.toString();
        } else return "peleador no encontrado";
}





}
