package com.ramuboya.ingestion.api;
import com.ramuboya.ingestion.service.IngestionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/ingestion")
public class IngestionController {
 private final IngestionService service;
 public IngestionController(IngestionService service) { this.service=service; }
 public record IngestRequest(@NotBlank @Size(max=120) String documentId,
  @NotBlank @Size(max=200) String title, @NotBlank @Size(max=100) String tenantId,
  @NotBlank @Size(max=500000) String content) {}
 public record IngestResponse(String documentId, int chunksIndexed, String status) {}
 @PostMapping @ResponseStatus(HttpStatus.ACCEPTED)
 public IngestResponse ingest(@Valid @RequestBody IngestRequest request) {
  return service.ingest(request);
 }
}
