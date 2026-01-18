package com.example.SWEBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Achievement {

    @Id
    private String id;

    private String title;
    private String rarity;
}
