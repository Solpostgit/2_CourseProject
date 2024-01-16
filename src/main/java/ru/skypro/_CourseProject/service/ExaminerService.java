package ru.skypro._CourseProject.service;

import ru.skypro._CourseProject.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
