package ru.skypro._CourseProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro._CourseProject.model.Question;
import ru.skypro._CourseProject.service.QuestionService;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("add")
    public Question addQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ) {
        return questionService.addQuestion(question, answer);
    }

    @GetMapping("remove")
    public Question removeQuestion(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ) {
        return questionService.addQuestion(question, answer);
    }

    @GetMapping
    public Question getAllQuestions(
            @RequestParam("question") String question,
            @RequestParam("answer") String answer
    ) {
        return questionService.addQuestion(question, answer);
    }
}
