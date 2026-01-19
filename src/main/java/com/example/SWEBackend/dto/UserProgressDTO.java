package com.example.SWEBackend.dto;

import lombok.Data;

@Data
public class UserProgressDTO {
    private int totalXP;
    private int currentStreak;
    private int longestStreak;
}

