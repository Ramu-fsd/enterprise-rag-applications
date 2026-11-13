package com.ramuboya.basicrag.api;
import com.ramuboya.basicrag.application.RagService;
import com.ramuboya.basicrag.domain.RagAnswer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/rag")
public class RagController {
 private final RagService service;
 public RagController(RagService service) { this.service=service; }
 public record AskRequest(@NotBlank @Size(max=2000) String question) {}
 @PostMapping("/ask") public RagAnswer ask(@Valid @RequestBody AskRequest request) { return service.ask(request.question()); }
}
