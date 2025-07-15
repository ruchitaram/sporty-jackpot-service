package org.example.controller;

import org.example.model.Bet;
import org.example.model.Reward;
import org.example.service.ContributionService;
import org.example.service.JackpotService;
import org.example.service.RewardService;
import org.example.model.Jackpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/bets")
public class BetController {

    @Autowired
    private JackpotService jackpotService;

    @Autowired
    private ContributionService contributionService;

    @Autowired
    private RewardService rewardService;

    @PostMapping("/publish")
    public ResponseEntity<String> publishBet(@RequestBody Bet bet) {
        System.out.println("Kafka Publish (mock): " + bet);

        Jackpot jackpot = jackpotService.getJackpot(bet.getJackpotId());
        if (jackpot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jackpot not found");
        }

        double contributionAmount = contributionService.calculateContribution(jackpot, bet.getAmount());
        jackpot.setPoolAmount(jackpot.getPoolAmount() + contributionAmount);
        jackpotService.updateJackpot(jackpot);

        return ResponseEntity.ok("Bet published and contribution processed");
    }

    @PostMapping("/evaluate")
    public ResponseEntity<?> evaluateReward(@RequestBody Bet bet) {
        Jackpot jackpot = jackpotService.getJackpot(bet.getJackpotId());
        if (jackpot == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jackpot not found");
        }

        boolean win = rewardService.evaluateReward(jackpot);
        if (win) {
            double rewardAmount = jackpot.getPoolAmount();
            jackpot.setPoolAmount(jackpot.getInitialPoolAmount());
            jackpotService.updateJackpot(jackpot);

            Reward reward = new Reward(
                    bet.getBetId(),
                    bet.getUserId(),
                    bet.getJackpotId(),
                    rewardAmount,
                    LocalDateTime.now()
            );

            return ResponseEntity.ok(reward);
        } else {
            return ResponseEntity.ok("No reward this time");
        }
    }


}
