package com.ramuboya.assistant.api;
import jakarta.validation.constraints.NotBlank;
public record AskRequest(@NotBlank String question, @NotBlank String tenantId, String conversationId) {}