package ru.skypro._CourseProject.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro._CourseProject.model.Question;
import ru.skypro._CourseProject.service.ExaminerService;
import ru.skypro._CourseProject.service.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;
    QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
