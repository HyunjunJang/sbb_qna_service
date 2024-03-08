package com.example.sbb.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.springframework.web.bind.annotation.ResponseBody;
@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
/*    private final QuestionRepository questionRepository; //컨트롤러에서 리포지터리를 직접 사용한다
    @GetMapping("/question/list")
    public String list(Model model){ //Model 객체는 Java 클래스와 template 간의 연결고리 역할
                                    //model 객체에 값을 넣어두면 template 에서 그 값을 사용할 수 있다
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    } */

    private final QuestionService questionService;
    @GetMapping("/list")
    public String list(Model model){
        List<Question> questionList = this.questionService.getList(); //컨트롤러에서 리포지터리를 직접 사용하지 않고
                                                                        //서비스 객체를 만들어서 사용한다ㅣ.
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm){
        return "question_form";
    }

    @PostMapping("/create") //post로 데이터를 보내므로 받으려면 RequestParam 구웃
    public String questionCreate(@Valid QuestionForm questionForm,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";

    }

}
