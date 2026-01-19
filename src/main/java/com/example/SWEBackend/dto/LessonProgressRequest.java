package com.example.SWEBackend.dto;

import lombok.Getter;

@Getter
public class LessonProgressRequest {
    private Long lessonId;

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
}