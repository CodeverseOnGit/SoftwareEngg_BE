package com.example.SWEBackend.service;

import com.example.SWEBackend.entity.UserProgress;
import com.example.SWEBackend.repository.UserProgressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProgressService {

    private final UserProgressRepository repository;
    private static final int LESSON_XP = 50;

    public ProgressService(UserProgressRepository repository) {
        this.repository = repository;
    }

    public UserProgress completeLesson(int lessonId) {
        UserProgress progress = repository.findTopByOrderByIdAsc();
        if (progress == null) {
            progress = new UserProgress();
        }

        // XP
        progress.setTotalXP(progress.getTotalXP() + LESSON_XP);

        // Streak
        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        String yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE);

        String lastDate = progress.getLastQuizDate();

        if (lastDate == null) {
            progress.setCurrentStreak(1);
        } else if (lastDate.equals(today)) {
            // do nothing
        } else if (lastDate.equals(yesterday)) {
            progress.setCurrentStreak(progress.getCurrentStreak() + 1);
        } else {
            progress.setCurrentStreak(1);
        }

        // longest streak
        if (progress.getCurrentStreak() > progress.getLongestStreak()) {
            progress.setLongestStreak(progress.getCurrentStreak());
        }

        // last quiz date
        progress.setLastQuizDate(today);

        repository.save(progress);
        return progress;
    }
}