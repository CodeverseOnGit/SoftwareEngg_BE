package com.example.SWEBackend.dto;

public class ProgressRequest {
    public record ProgressRequest(Long userId, int xp) {}
}
