package com.sherdog.FightersRanking.controllers;

import com.sherdog.FightersRanking.domain.fighters;
import com.sherdog.FightersRanking.services.fightersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class fightersController {
    public fightersController(fightersService fightersService) {
        this.fightersService = fightersService;
    }

    private fightersService fightersService;

    @GetMapping("/api/v1/findall")
    public List<fighters> findAll() {
        return fightersService.findAll();
    }

    @GetMapping("/api/v1/find/{id}")
    public fighters findById(@PathVariable("id") Long id) {
        return fightersService.findById(id);
    }

    @PostMapping("/api/v1/create")
    public fighters create(@RequestBody fighters fighters, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User- Agent"));
        return fightersService.create(fighters);
    }

    @PutMapping("/api/v1/update")
    public void update(@RequestBody fighters fighters) {
        fightersService.update(fighters);
    }

    @GetMapping("/api/v1/findbyname/{name}")
    public List<fighters> findByName(@PathVariable("name") String name) {
        return fightersService.findByName(name);
    }

    @DeleteMapping("/api/v1/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        fightersService.deleteById(id);
    }

    @DeleteMapping("/api/v1/deleteall")
    public ResponseEntity<String> deleteAll() {
        fightersService.deleteAll();
        return ResponseEntity.ok("Todos los peleadores han sido eliminados.");
    }
}
