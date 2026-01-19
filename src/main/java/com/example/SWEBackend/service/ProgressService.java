package com.example.SWEBackend.service;

import com.example.SWEBackend.entity.Lesson;
import com.example.SWEBackend.entity.Users;
import com.example.SWEBackend.repository.LessonRepository;
import com.example.SWEBackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProgressService {

    private final UserRepository userRepo;
    private final LessonRepository lessonRepo;

    public Users completeLesson(Long userId, Long lessonId) {
        Users user = userRepo.findById(userId).orElseThrow();
        Lesson lesson = lessonRepo.findById(lessonId).orElseThrow();

        updateStreak(user);

        user.setLessonsCompleted(user.getLessonsCompleted() + 1);
        user.setTotalXP(user.getTotalXP() + lesson.getXpReward());

        return userRepo.save(user);
    }


    private void updateStreak(Users user) {
        LocalDate today = LocalDate.now();

        if (user.getLastActiveDate() == null ||
                user.getLastActiveDate().isBefore(today.minusDays(1))) {

            if (user.getStreakFreeze() > 0) {
                user.setStreakFreeze(user.getStreakFreeze() - 1);
            } else {
                user.setCurrentStreak(0);
            }
        }

        if (!today.equals(user.getLastActiveDate())) {
            user.setCurrentStreak(user.getCurrentStreak() + 1);
            user.setLongestStreak(
                    Math.max(user.getLongestStreak(), user.getCurrentStreak())
            );
        }

        user.setLastActiveDate(today);
    }

    private int streakBonus(Users user) {
        return user.getCurrentStreak() >= 5 ? 10 : 0;
    }
}