package com.ramuboya.langchainrag.api;
import com.ramuboya.langchainrag.ai.RagAssistant;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/rag")
public class RagController {
 private final RagAssistant assistant;
 public RagController(RagAssistant assistant) { this.assistant=assistant; }
 public record AskRequest(@NotBlank @Size(max=3000) String question) {}
 public record AskResponse(String answer) {}
 @PostMapping("/ask") public AskResponse ask(@Valid @RequestBody AskRequest r) { return new AskResponse(assistant.answer(r.question())); }
}
