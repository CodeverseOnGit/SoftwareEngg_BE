package com.example.SWEBackend.controller;

import com.example.SWEBackend.dto.LessonProgressRequest;
import com.example.SWEBackend.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Progress API", description = "Endpoints for lesson/quizzes")
public class ProgressController {

    @PostMapping("/lesson")
    @Operation(summary = "Complete a lesson by ID")
    public ResponseEntity<Void> completeLesson(@RequestBody LessonProgressRequest req) {
        // your logic here
        return ResponseEntity.ok().build();
    }
}