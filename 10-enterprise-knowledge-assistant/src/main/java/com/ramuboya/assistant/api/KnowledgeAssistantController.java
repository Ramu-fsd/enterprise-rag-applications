package com.ramuboya.assistant.api;
import com.ramuboya.assistant.service.KnowledgeAssistantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/assistant")
public class KnowledgeAssistantController {
 private final KnowledgeAssistantService service;
 public KnowledgeAssistantController(KnowledgeAssistantService service) { this.service = service; }
 @PostMapping("/ask") public AskResponse ask(@Valid @RequestBody AskRequest request) { return service.ask(request); }
}