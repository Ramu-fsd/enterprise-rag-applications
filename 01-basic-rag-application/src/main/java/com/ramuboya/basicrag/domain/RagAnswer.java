package com.ramuboya.basicrag.domain;
import java.util.List;
public record RagAnswer(String answer, List<String> sourceIds) {}
