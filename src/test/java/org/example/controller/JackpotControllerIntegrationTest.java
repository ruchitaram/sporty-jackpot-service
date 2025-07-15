package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Jackpot;
import org.example.model.ContributionType;
import org.example.model.RewardType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = org.example.Main.class)
@AutoConfigureMockMvc
class JackpotControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateJackpot() throws Exception {
        Jackpot jackpot = new Jackpot();
        jackpot.setJackpotId("j2");
        jackpot.setPoolAmount(1000);
        jackpot.setInitialPoolAmount(1000);
        jackpot.setContributionType(ContributionType.FIXED);
        jackpot.setRewardType(RewardType.FIXED);
        jackpot.setContributionRate(0.1);
        jackpot.setRewardChance(0.4);
        jackpot.setPoolLimit(5000);

        mockMvc.perform(post("/jackpots/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(jackpot)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllJackpots() throws Exception {
        mockMvc.perform(get("/jackpots/all"))
                .andExpect(status().isOk());
    }
}
