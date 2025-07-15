package org.example.service;

import org.example.model.ContributionType;
import org.example.model.Jackpot;
import org.example.service.ContributionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContributionServiceTest {

    private final ContributionService contributionService = new ContributionService();

    @Test
    void testCalculateContributionFixed() {
        Jackpot jackpot = new Jackpot();
        jackpot.setContributionType(ContributionType.FIXED);
        jackpot.setContributionRate(0.1);

        double contribution = contributionService.calculateContribution(jackpot, 1000);
        assertEquals(100.0, contribution);
    }

    @Test
    void testCalculateContributionVariable() {
        Jackpot jackpot = new Jackpot();
        jackpot.setContributionType(ContributionType.VARIABLE);
        jackpot.setContributionRate(0.05);

        double contribution = contributionService.calculateContribution(jackpot, 1000);
        assertTrue(contribution > 0);
        assertTrue(jackpot.getContributionRate() <= 0.05);
    }
}
