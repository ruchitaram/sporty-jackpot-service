package org.example.service;

import org.example.model.Jackpot;
import org.example.model.RewardType;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    public boolean evaluateReward(Jackpot jackpot) {
        double chance = jackpot.getRewardChance();

        if (jackpot.getRewardType() == RewardType.VARIABLE) {
            chance += 0.01;
            if (jackpot.getPoolAmount() >= jackpot.getPoolLimit()) {
                chance = 1.0;
            }
            jackpot.setRewardChance(chance);
        }

        return Math.random() <= chance;
    }
}
