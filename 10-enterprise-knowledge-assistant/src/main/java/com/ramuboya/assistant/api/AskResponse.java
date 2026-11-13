package com.ramuboya.assistant.api;
import java.util.List;
public record AskResponse(String answer, List<SourceReference> sources, String conversationId) {
 public record SourceReference(String documentId, String title, String locator) {}
}