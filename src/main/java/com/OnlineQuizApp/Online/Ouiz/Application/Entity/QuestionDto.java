package com.OnlineQuizApp.Online.Ouiz.Application.Entity;

import java.util.List;

public record QuestionDto(
        Long id,
        String questionText,
        String correctAnswer,
        List<String> options
) {}
