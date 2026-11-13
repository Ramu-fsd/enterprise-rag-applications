package com.ramuboya.conversationalrag.domain;
import java.time.Instant;
public record ChatMessage(String role,String content,Instant createdAt) {}
