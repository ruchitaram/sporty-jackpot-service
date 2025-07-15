package org.example.service;

import org.example.model.Jackpot;
import org.example.model.RewardType;
import org.example.service.RewardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardServiceTest {

    private final RewardService rewardService = new RewardService();

    @Test
    void testEvaluateRewardFixed() {
        Jackpot jackpot = new Jackpot();
        jackpot.setRewardType(RewardType.FIXED);
        jackpot.setRewardChance(1.0); // Always win

        assertTrue(rewardService.evaluateReward(jackpot));
    }

    @Test
    void testEvaluateRewardVariableChanceIncreases() {
        Jackpot jackpot = new Jackpot();
        jackpot.setRewardType(RewardType.VARIABLE);
        jackpot.setRewardChance(0.2);
        jackpot.setPoolAmount(600);
        jackpot.setPoolLimit(500);

        boolean result = rewardService.evaluateReward(jackpot);

        // With poolAmount >= poolLimit, chance is forced to 1.0
        assertTrue(result);
        assertEquals(1.0, jackpot.getRewardChance());
    }
}
