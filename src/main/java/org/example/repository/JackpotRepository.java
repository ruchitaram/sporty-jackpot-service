package org.example.repository;

import org.example.model.Jackpot;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JackpotRepository {

    private final Map<String, Jackpot> jackpots = new ConcurrentHashMap<>();

    public Jackpot getJackpot(String id) {
        return jackpots.get(id);
    }

    public void saveJackpot(Jackpot jackpot) {
        jackpots.put(jackpot.getJackpotId(), jackpot);
    }

    public Collection<Jackpot> getAllJackpots() {
        return jackpots.values();
    }
}
