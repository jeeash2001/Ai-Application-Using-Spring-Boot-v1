package com.ai_demo_app.AiApplicationVersion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class QuestionAndAnswerReq {


    @NotBlank(message = "Question cannot be blank")
    @Size(max = 5000, message = "Question cannot exceed 5000 characters")
    private String question;
}
