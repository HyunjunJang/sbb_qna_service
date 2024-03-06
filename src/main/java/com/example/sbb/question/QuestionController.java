package com.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//import org.springframework.web.bind.annotation.ResponseBody;
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;
    @GetMapping("/question/list")
    public String list(Model model){ //Model 객체는 Java 클래스와 template 간의 연결고리 역할
                                    //model 객체에 값을 넣어두면 template 에서 그 값을 사용할 수 있다
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
