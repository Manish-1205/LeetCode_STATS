package com.LeetCodeAPI.LeetCodeAPI.controller;


import com.LeetCodeAPI.LeetCodeAPI.dto.LeetCodeDTO;
import com.LeetCodeAPI.LeetCodeAPI.dto.LeetCodeTauntResponseDTO;
import com.LeetCodeAPI.LeetCodeAPI.service.LeetCodeService;
import com.LeetCodeAPI.LeetCodeAPI.service.TauntService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leetcode")
public class LeetCodeController {

    private final LeetCodeService leetCodeService;
    private final TauntService tauntService;

    public LeetCodeController(LeetCodeService leetCodeService, TauntService tauntService) {
        this.leetCodeService = leetCodeService;
        this.tauntService = tauntService;
    }

    @GetMapping("/{username}")
    public LeetCodeDTO getProfile(@PathVariable String username) {
        return leetCodeService.getProfile(username);
    }

    @GetMapping("/{username}/taunt")
    public LeetCodeTauntResponseDTO getTaunt(@PathVariable String username) {

        LeetCodeDTO stats = leetCodeService.getProfile(username);

        String taunt = tauntService.generateTaunt(stats);

        return new LeetCodeTauntResponseDTO(stats, taunt);
    }
}
