package com.example.SWEBackend.controller;

import com.example.SWEBackend.dto.LessonProgressRequest;
import com.example.SWEBackend.dto.UserProgressDTO;
import com.example.SWEBackend.entity.UserProgress;
import com.example.SWEBackend.service.ProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @PostMapping("/lesson")
    public ResponseEntity<UserProgressDTO> completeLesson(@RequestBody LessonProgressRequest request) {
        // request.lessonId must exist (check if greater than 0)
        if (request.getLessonId() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        // Call service to update progress
        UserProgress progress = progressService.completeLesson(request.getLessonId());

        // Convert to DTO and return
        UserProgressDTO user = new UserProgressDTO();
        user.setTotalXP(progress.getTotalXP());
        user.setCurrentStreak(progress.getCurrentStreak());
        user.setLongestStreak(progress.getLongestStreak());

        return ResponseEntity.ok(user);
    }
}
