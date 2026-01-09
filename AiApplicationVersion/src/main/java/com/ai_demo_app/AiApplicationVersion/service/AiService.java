package com.ai_demo_app.AiApplicationVersion.service;

import com.ai_demo_app.AiApplicationVersion.client.OpenAiClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final OpenAiClient client;

    public AiService(OpenAiClient client) {
        this.client = client;
    }

    public String summarize(String text) {

        return client.callAi("Summarize the following text: " + text);

    }
    public String correctGrammar(String text) {
        return client.callAi("Correct grammar: " + text);
    }
    public String answerQuestion(String question) {
        return client.callAi("Answer this question: " + question);
    }
}
