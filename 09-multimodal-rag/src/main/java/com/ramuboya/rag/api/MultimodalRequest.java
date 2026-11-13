package com.ramuboya.rag.api;
import jakarta.validation.constraints.NotBlank;
public record MultimodalRequest(@NotBlank String question, String documentId, String modality) {}