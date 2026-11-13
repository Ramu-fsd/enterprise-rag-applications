package com.ramuboya.assistant.service;
import com.ramuboya.assistant.api.AskRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class KnowledgeAssistantServiceTest {
 @Test void returnsSafeUnconfiguredResponse() {
   var response = new KnowledgeAssistantService().ask(new AskRequest("What is the policy?", "tenant-a", "c-1"));
   assertTrue(response.answer().contains("No knowledge provider"));
   assertTrue(response.sources().isEmpty());
 }
}