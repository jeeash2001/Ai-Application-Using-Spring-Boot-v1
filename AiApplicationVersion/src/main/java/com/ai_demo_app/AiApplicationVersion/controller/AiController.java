package com.ai_demo_app.AiApplicationVersion.controller;

import com.ai_demo_app.AiApplicationVersion.dto.AiResponse;
import com.ai_demo_app.AiApplicationVersion.dto.GrammarReq;
import com.ai_demo_app.AiApplicationVersion.dto.QuestionAndAnswerReq;
import com.ai_demo_app.AiApplicationVersion.dto.SummaryReq;
import com.ai_demo_app.AiApplicationVersion.service.AiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiService service;
    @GetMapping("/test")
    public String test() {
        return "Controller is working";
    }
    @PostMapping("/grammar")
    public AiResponse grammar(@Valid @RequestBody GrammarReq request) {
        return new AiResponse(service.correctGrammar(request.getText()));
    }
    @PostMapping("/qa")
    public AiResponse qa(@Valid @RequestBody QuestionAndAnswerReq request) {
        return new AiResponse(service.answerQuestion(request.getQuestion()));
    }
    @PostMapping("/summarize")
    public AiResponse summarize(@Valid @RequestBody SummaryReq request) {
        return new AiResponse(service.summarize(request.getText()));
    }
}
