package com.LeetCodeAPI.LeetCodeAPI.dto;

public class LeetCodeTauntResponseDTO {

    private LeetCodeDTO stats;
    private String taunt;

    public LeetCodeTauntResponseDTO(LeetCodeDTO stats, String taunt) {
       this.stats = stats;
       this.taunt = taunt;
    }

    public LeetCodeDTO getStats() {
         return stats;
    }

    public String getTaunt() {
         return taunt;
    }
}

