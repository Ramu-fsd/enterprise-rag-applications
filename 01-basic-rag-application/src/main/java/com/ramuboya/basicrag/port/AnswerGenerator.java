package com.ramuboya.basicrag.port;
import com.ramuboya.basicrag.domain.KnowledgeChunk;
import java.util.List;
public interface AnswerGenerator { String generate(String question, List<KnowledgeChunk> evidence); }
