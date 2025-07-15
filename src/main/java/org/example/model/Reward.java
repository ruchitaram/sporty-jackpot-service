package org.example.model;

import java.time.LocalDateTime;

public class Reward {
    private String betId;
    private String userId;
    private String jackpotId;
    private double rewardAmount;
    private LocalDateTime createdAt;

    public Reward(String betId, String userId, String jackpotId, double rewardAmount, LocalDateTime createdAt) {
        this.betId = betId;
        this.userId = userId;
        this.jackpotId = jackpotId;
        this.rewardAmount = rewardAmount;
        this.createdAt = createdAt;
    }

    public String getBetId() {
        return betId;
    }

    public String getUserId() {
        return userId;
    }

    public String getJackpotId() {
        return jackpotId;
    }

    public double getRewardAmount() {
        return rewardAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
