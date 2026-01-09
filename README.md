This is a Spring Boot–based REST API that integrates with OpenAI’s Chat Completion API to provide:

1.Grammar correction

2.Question & Answering

3.Text summarization

#Techonology-------
    Java 17+
    
    Maven 3.8+
    
    Spring Boot 3.x
    
    OpenAI API Key
------ARCHITECTURE OVERVIEW------

Controller Layer
   ↓
Service Layer
   ↓
OpenAI Client
   ↓
OpenAI Chat Completion API

------COMPONENTS-------

Controller → Handles HTTP requests

Service → Business logic

OpenAiClient → Calls OpenAI API

DTOs → Request & response models

application.properties → Configuration

------AI SERVICE USED-----

Provider: OpenAI

API: Chat Completions API

Model: gpt-4o-mini (configurable)

-----API ENDPOINTS USING POSTMAN-----

Base URL:http://localhost:8080/api/v1/ai

1.Grammar

URL:http://localhost:8080/api/v1/ai/grammar
REQUEST:
{
  "text": "u r name is what"
}
RESPONSE:
{
  "result": "What is your name?",
  "errorCode": null,
  "timestamp": "2026-01-09T10:30:12"
}

2.Question And Answer

URL:http://localhost:8080/api/v1/ai/qa
REQUEST:
{
  "question": "What is Spring Boot?"
}
RESPONSE:
{
  "result": "Spring Boot is a Java framework used to build stand-alone, production-ready Spring applications.",
  "errorCode": null,
  "timestamp": "2026-01-09T10:32:05"
}

3.Summarize

URL:http://localhost:8080/api/v1/ai/summarize
REQUEST:
{
  "text": "Spring Boot simplifies Java application development by providing auto-configuration and embedded servers."
}
RESPONSE:
{
  "result": "Spring Boot simplifies Java development using auto-configuration and embedded servers.",
  "errorCode": null,
  "timestamp": "2026-01-09T10:34:40"
}

