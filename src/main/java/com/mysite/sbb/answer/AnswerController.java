package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable Integer id,@RequestParam String content){
        // 관련 질문을 얻어온다.
        Question question = questionService.getQuestion(id);

        // TODO : 답변 객체를 만든다.

        return "redirect:/question/detail/%s".formatted(id);
    }
}
