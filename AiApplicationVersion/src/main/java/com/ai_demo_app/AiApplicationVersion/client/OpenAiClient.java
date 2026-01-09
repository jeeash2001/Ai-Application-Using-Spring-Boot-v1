package com.ai_demo_app.AiApplicationVersion.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
@Component
public class OpenAiClient {

    @Value("${openai.api-key}")
    private String apiKey;

    @Value("${openai.url}")
    private String url;

    private final RestTemplate restTemplate = new RestTemplate();

    public String callAi(String prompt) {
        try {
            // --- Headers ---
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            // --- Request Body ---
            Map<String, Object> requestBody = Map.of(
                    "model", "gpt-4o-mini",
                    "messages", List.of(
                            Map.of(
                                    "role", "user",
                                    "content", prompt
                            )
                    )
            );

            // --- Print API key, URL, and Request Body ---
            System.out.println("API Key: " + apiKey);
            System.out.println("URL: " + url);
            System.out.println("Request Body: " + requestBody);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

            // --- Call OpenAI API ---
            ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

            // --- Print Response ---
            System.out.println("Response: " + response.getBody());

            // --- Extract output text ---
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            Map<String, Object> firstChoice = choices.get(0);
            Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");

            return message.get("content").toString();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error calling OpenAI API", e);
        }
    }
}
