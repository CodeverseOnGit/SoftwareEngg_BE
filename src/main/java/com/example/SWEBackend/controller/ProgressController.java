package com.example.SWEBackend.controller;

import com.example.SWEBackend.dto.ProgressRequest;
import com.example.SWEBackend.entity.Users;
import com.example.SWEBackend.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
public class ProgressController {

    private final ProgressService service;

    @PostMapping("/lesson")
    public Users lesson(@RequestBody ProgressRequest.ProgressRequest req) {
        return service.completeLesson(req.userId(), req.xp());
    }
}