package org.example.model;

public class Jackpot {
    private String jackpotId;
    private double poolAmount;
    private double initialPoolAmount;
    private ContributionType contributionType;
    private RewardType rewardType;
    private double contributionRate;
    private double rewardChance;
    private double poolLimit;

    // Getters and setters
    public String getJackpotId() {
        return jackpotId;
    }

    public void setJackpotId(String jackpotId) {
        this.jackpotId = jackpotId;
    }

    public double getPoolAmount() {
        return poolAmount;
    }

    public void setPoolAmount(double poolAmount) {
        this.poolAmount = poolAmount;
    }

    public double getInitialPoolAmount() {
        return initialPoolAmount;
    }

    public void setInitialPoolAmount(double initialPoolAmount) {
        this.initialPoolAmount = initialPoolAmount;
    }

    public ContributionType getContributionType() {
        return contributionType;
    }

    public void setContributionType(ContributionType contributionType) {
        this.contributionType = contributionType;
    }

    public RewardType getRewardType() {
        return rewardType;
    }

    public void setRewardType(RewardType rewardType) {
        this.rewardType = rewardType;
    }

    public double getContributionRate() {
        return contributionRate;
    }

    public void setContributionRate(double contributionRate) {
        this.contributionRate = contributionRate;
    }

    public double getRewardChance() {
        return rewardChance;
    }

    public void setRewardChance(double rewardChance) {
        this.rewardChance = rewardChance;
    }

    public double getPoolLimit() {
        return poolLimit;
    }

    public void setPoolLimit(double poolLimit) {
        this.poolLimit = poolLimit;
    }
}
