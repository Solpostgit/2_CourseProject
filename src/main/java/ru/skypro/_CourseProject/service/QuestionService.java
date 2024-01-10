package ru.skypro._CourseProject.service;

import ru.skypro._CourseProject.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question addQuestion(String question, String answer);
    Question findQuestion(Question question);
    Question removeQuestion(Question question);
    Collection<Question> getAllQuestions();
    Question getRandomQuestion();
}
