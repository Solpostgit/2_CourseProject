package ru.skypro._CourseProject.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro._CourseProject.model.Question;
import ru.skypro._CourseProject.service.QuestionService;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions;

    @Override
    public Question addQuestion(String question, String answer) {
        return null;
    }

    @Override
    public Question findQuestion(Question question) {
        return null;
    }

    @Override
    public Question removeQuestion(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.toArray().length);
        return (Question) questions.toArray()[index];
    }
}
