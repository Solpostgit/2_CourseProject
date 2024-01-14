package ru.skypro._CourseProject.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro._CourseProject.model.Question;
import ru.skypro._CourseProject.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    @PostConstruct
    public void init() {
        add("question 1", "answer 1");
        add("question 2", "answer 2");
        add("question 3", "answer 3");
        add("question 4", "answer 4");
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIndex);
    }
}
