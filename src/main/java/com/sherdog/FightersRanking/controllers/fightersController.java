package com.sherdog.FightersRanking.controllers;

import com.sherdog.FightersRanking.domain.fighters;
import com.sherdog.FightersRanking.repository.fightersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class fightersController {

    private fightersRepository fightersRepository;

    public fightersController(fightersRepository fightersRepository) {
        this.fightersRepository = fightersRepository;
    }

    @GetMapping("/api/v1/findall")
    public List<fighters> findAll() {
        return fightersRepository.findAll();
    }

@GetMapping("/api/v1/find/{id}")
    public ResponseEntity <fighters> findById (@PathVariable("id")Long id) {
Optional<fighters> fightersOpt = fightersRepository.findById(id);
if (fightersOpt.isPresent())
    return ResponseEntity.ok(fightersOpt.get());
else return ResponseEntity.notFound().build();
}



}
