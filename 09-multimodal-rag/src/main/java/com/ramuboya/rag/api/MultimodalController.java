package com.ramuboya.rag.api;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/multimodal")
public class MultimodalController {
  @PostMapping("/query")
  public MultimodalResponse query(@Valid @RequestBody MultimodalRequest request) {
    return new MultimodalResponse(request.question(),
      "Starter response: connect image, audio, or video extraction and a multimodal embedding provider.",
      request.documentId(), request.modality());
  }
  public record MultimodalResponse(String question, String answer, String documentId, String modality) {}
}