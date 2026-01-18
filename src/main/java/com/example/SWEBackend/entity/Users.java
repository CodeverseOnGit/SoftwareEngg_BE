package com.example.SWEBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private int totalXP;

    private int currentStreak;
    private int longestStreak;

    private LocalDate lastActiveDate;

    private int streakFreeze;

    private int lessonsCompleted;
    private int quizzesCompleted;
}
