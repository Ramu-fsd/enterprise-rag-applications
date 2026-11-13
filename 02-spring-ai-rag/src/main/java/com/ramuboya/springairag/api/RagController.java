package com.ramuboya.springairag.api;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/rag")
public class RagController {
 private final ChatClient client;
 public RagController(ChatClient client) { this.client=client; }
 public record AskRequest(@NotBlank @Size(max=3000) String question) {}
 public record AskResponse(String answer) {}
 @PostMapping("/ask") public AskResponse ask(@Valid @RequestBody AskRequest r) {
  String answer=client.prompt().user(r.question()).call().content();
  return new AskResponse(answer==null?"No response generated.":answer);
 }
}
