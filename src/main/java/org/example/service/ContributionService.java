package org.example.service;

import org.example.model.ContributionType;
import org.example.model.Jackpot;
import org.springframework.stereotype.Service;

@Service
public class ContributionService {

    public double calculateContribution(Jackpot jackpot, double betAmount) {
        if (jackpot.getContributionType() == ContributionType.FIXED) {
            return betAmount * jackpot.getContributionRate();
        } else {
            double rate = Math.max(0.01, jackpot.getContributionRate() - 0.001);
            jackpot.setContributionRate(rate);
            return betAmount * rate;
        }
    }
}
