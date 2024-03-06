package com.example.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //이 파일 컨트롤러야! 라는 뜻
public class MainController {
    @RequestMapping("/sbb")
    @ResponseBody //html에서 Body에 리턴값을 넣는다. 생략한다면 templates/index.html 을 찾는다
    public String index(){
        return "index";
    }

    @GetMapping("/pag1")
    @ResponseBody
    public String showGet(){
        return """
                <h1>안녕하세요</h1>
                <input type="text" placeholder="입력해주세요">
                """;
    }

    @GetMapping("/pag2")
    @ResponseBody
    public String showPost(){
        return """
                <form method="POST" action="/page2"/>
                    <input type="submit" value="page2로 POST방식으로 이동"/>
                </form>
                """;
    }
}
