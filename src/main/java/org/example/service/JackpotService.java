package org.example.service;

import org.example.model.Jackpot;
import org.example.repository.JackpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JackpotService {

    @Autowired
    private JackpotRepository jackpotRepository;

    public Jackpot getJackpot(String jackpotId) {
        return jackpotRepository.getJackpot(jackpotId);
    }

    public void updateJackpot(Jackpot jackpot) {
        jackpotRepository.saveJackpot(jackpot);
    }
}
