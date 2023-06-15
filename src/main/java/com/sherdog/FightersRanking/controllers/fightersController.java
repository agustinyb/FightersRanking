package com.sherdog.FightersRanking.controllers;

import com.sherdog.FightersRanking.domain.fighters;
import com.sherdog.FightersRanking.repository.fightersRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<fighters> findById(@PathVariable("id") Long id) {
        Optional<fighters> fightersOpt = fightersRepository.findById(id);
        if (fightersOpt.isPresent())
            return ResponseEntity.ok(fightersOpt.get());
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/v1/create")
    public fighters create(@RequestBody fighters fighters, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User- Agent"));
        return fightersRepository.save(fighters);
    }

    @PutMapping("/api/v1/update/{id}")
    public ResponseEntity<fighters> update(@PathVariable Long id, @RequestBody fighters updateFighter) {
        Optional<fighters> fightersOpt = fightersRepository.findById(id);
        if (fightersOpt.isPresent()) {
            fighters laptop = fightersOpt.get();
            fighters updatedLaptop = fightersRepository.save(laptop);
            return ResponseEntity.ok(updateFighter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/v1/findByName/{name}")
    public ResponseEntity<fighters> findByName(@PathVariable("name") String name) {
        Optional<fighters> fighterOpt = fightersRepository.findByName(name);
        if (fighterOpt.isPresent()) {
            return ResponseEntity.ok(fighterOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/v1/delete/{id}")
    public ResponseEntity<fighters> deleteById(@PathVariable("id") Long id) {
        Optional<fighters> fightersOpt = fightersRepository.findById(id);
        if (fightersOpt.isPresent()) {
            fightersRepository.deleteById(id);
            return ResponseEntity.ok(fightersOpt.get());
        } else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/v1/deleteall")
    public ResponseEntity<String> deleteAll() {
        fightersRepository.deleteAll();
        return ResponseEntity.ok("Todos los peleadores han sido eliminados.");
    }
}
