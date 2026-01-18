package com.example.SWEBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content; // JSON or markdown

    private int xpReward;

    private int lessonOrder;
}
