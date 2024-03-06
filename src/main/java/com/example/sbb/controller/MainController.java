package com.example.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //이 파일 컨트롤러야! 라는 뜻
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody //html에서 Body에 리턴값을 넣는다. 생략한다면 templates/index.html 을 찾는다
    public String index(){
        return "SBB 게시판에 오신 것을 환영합니다";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/question/list"; //redirect 란 클라이언트가 요청하면 새로운 URL 로 전송한다는 뜻
    }

//    @GetMapping("/pag1")
//    @ResponseBody
//    public String showGet(){
//        return """
//                <h1>안녕하세요</h1>
//                <input type="text" placeholder="입력해주세요">
//                """;
//    }
//
//    @GetMapping("/pag2")
//    @ResponseBody
//    public String showPost(){
//        return """
//                <form method="POST" action="/page2"/>
//                    <input type="submit" value="page2로 POST방식으로 이동"/>
//                </form>
//                """;
//    }
}
