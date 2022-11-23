package com.deleon.julian.charter.retailerrewards.controller;

import com.deleon.julian.charter.retailerrewards.response.Rewards;
import com.deleon.julian.charter.retailerrewards.service.RewardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardController {
    private RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/users/{userId}/rewards")
    public Rewards getRewards(@PathVariable String userId) {
        return rewardService.getRewards(userId);
    }
}
