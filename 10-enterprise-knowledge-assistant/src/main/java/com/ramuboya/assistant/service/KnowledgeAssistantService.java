package com.ramuboya.assistant.service;
import com.ramuboya.assistant.api.*;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class KnowledgeAssistantService {
 public AskResponse ask(AskRequest request) {
   // Replace this deterministic placeholder with authorized retrieval + grounded model generation.
   return new AskResponse("No knowledge provider is configured. Add retrieval and model adapters before use.",
     List.of(), request.conversationId());
 }
}