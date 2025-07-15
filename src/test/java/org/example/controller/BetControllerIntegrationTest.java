package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Bet;
import org.example.model.ContributionType;
import org.example.model.Jackpot;
import org.example.model.RewardType;
import org.example.repository.JackpotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = org.example.Main.class)
@AutoConfigureMockMvc
class BetControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JackpotRepository jackpotRepository;

    @BeforeEach
    void setup() {
        Jackpot jackpot = new Jackpot();
        jackpot.setJackpotId("j1");
        jackpot.setPoolAmount(1000.0);
        jackpot.setInitialPoolAmount(1000.0);
        jackpot.setContributionType(ContributionType.FIXED);
        jackpot.setRewardType(RewardType.FIXED);
        jackpot.setContributionRate(0.1);
        jackpot.setRewardChance(0.5);
        jackpot.setPoolLimit(5000.0);

        jackpotRepository.saveJackpot(jackpot);
    }

    @Test
    void testPublishBet() throws Exception {
        Bet bet = new Bet();
        bet.setBetId("b1");
        bet.setUserId("u1");
        bet.setJackpotId("j1");
        bet.setAmount(500);

        mockMvc.perform(post("/bets/publish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bet)))
                .andExpect(status().isOk());
    }

    @Test
    void testEvaluateBet() throws Exception {
        Bet bet = new Bet();
        bet.setBetId("b2");
        bet.setUserId("u2");
        bet.setJackpotId("j1");
        bet.setAmount(500);

        mockMvc.perform(post("/bets/evaluate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bet)))
                .andExpect(status().isOk());
    }
}
