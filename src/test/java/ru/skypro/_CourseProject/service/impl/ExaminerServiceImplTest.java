package ru.skypro._CourseProject.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro._CourseProject.exception.IncorrectAmountException;
import ru.skypro._CourseProject.model.Question;
import ru.skypro._CourseProject.service.ExaminerService;
import ru.skypro._CourseProject.service.QuestionService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectAmountExceptionWhenThereIsNotEnoughQuestions() {
        //given
        int amount = 10;
        when(javaQuestionService.getAll()).thenReturn(List.of());

        //when
        //then
        Assertions.assertThrows(
                IncorrectAmountException.class,
                () -> examinerService.getQuestions(amount)
        );
    }

    @Test
    public void shouldCorrectlyGetQuestions() {
        //given
        int amount = 3;
        List<Question> questions = List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"),
                new Question("question4", "answer4"),
                new Question("question5", "answer5")
        );

        when(javaQuestionService.getAll()).thenReturn(questions);

        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(1),
                questions.get(0),
                questions.get(1),
                questions.get(2)
        );

        //when
        Collection<Question> actualQuestions = examinerService.getQuestions(amount);

        //then
        Assertions.assertEquals(
                Set.of(questions.get(0), questions.get(1), questions.get(2)),
                actualQuestions
        );

        verify(javaQuestionService, times(6)).getRandomQuestion();
    }
}
