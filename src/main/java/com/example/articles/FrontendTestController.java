package com.example.articles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FrontendTestController {
    @GetMapping("/viewx")
    public String test() {
        return "index.html";
    }

}
