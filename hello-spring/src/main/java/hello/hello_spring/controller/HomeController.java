package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 제일 첫번째 localhost 8080 들어오면 호출됨
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
