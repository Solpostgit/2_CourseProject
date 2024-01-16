package ru.skypro._CourseProject.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.skypro._CourseProject.model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private final JavaQuestionService questionService = new JavaQuestionService();

    @Test
    public void shouldCorrectlyAddQuestion() {
        //given
        Question question = new Question("a", "b");
        //when
        Question addedQuestion = questionService.add(question);
        //then
        assertEquals(question, addedQuestion);
    }

    @Test
    public void shouldCorrectlyRemoveQuestion() {
        //given
        Question question = new Question("a", "b");
        questionService.add(question);

        //when
        Question removedQuestion = questionService.remove(question);

        //then
        assertEquals(question, removedQuestion);
    }

    @Test
    public void shouldCorrectlyGetAll() {
        //given
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");

        questionService.add(question1);
        questionService.add(question2);
        //when
        Collection<Question> actualQuestions = questionService.getAll();

        //then
        assertIterableEquals(List.of(question1, question2), actualQuestions);
    }

    @Test
    public void shouldCorrectlyGetRandomQuestion() {
        //given
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");

        questionService.add(question1);
        questionService.add(question2);

        //when
        Question randomQuestion = questionService.getRandomQuestion();

        //then
        assertTrue(Set.of(question1, question2).contains(randomQuestion));
    }
}
