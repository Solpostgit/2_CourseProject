package ru.skypro._CourseProject.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro._CourseProject.exception.IncorrectAmountException;
import ru.skypro._CourseProject.model.Question;
import ru.skypro._CourseProject.service.ExaminerService;
import ru.skypro._CourseProject.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new IncorrectAmountException("Недостаточно вопросов в хранилище");
        }

        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
