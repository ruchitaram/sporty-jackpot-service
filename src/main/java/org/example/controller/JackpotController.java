package org.example.controller;

import org.example.model.Jackpot;
import org.example.repository.JackpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jackpots")
public class JackpotController {

    @Autowired
    private JackpotRepository jackpotRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createJackpot(@RequestBody Jackpot jackpot) {
        jackpotRepository.saveJackpot(jackpot);
        return ResponseEntity.ok("Jackpot created with ID: " + jackpot.getJackpotId());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllJackpots() {
        return ResponseEntity.ok(jackpotRepository.getAllJackpots());
    }

}
