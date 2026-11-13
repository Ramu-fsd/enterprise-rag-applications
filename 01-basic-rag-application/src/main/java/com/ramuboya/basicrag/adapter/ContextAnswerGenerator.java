package com.ramuboya.basicrag.adapter;
import com.ramuboya.basicrag.domain.KnowledgeChunk;
import com.ramuboya.basicrag.port.AnswerGenerator;
import java.util.List;
import org.springframework.stereotype.Component;
@Component
public class ContextAnswerGenerator implements AnswerGenerator {
 public String generate(String question, List<KnowledgeChunk> evidence) {
  if (evidence.isEmpty()) return "I could not find supporting information in the available knowledge base.";
  return "Demo response based on retrieved evidence: " +
   evidence.stream().map(KnowledgeChunk::content).reduce((a,b)->a+" "+b).orElse("");
 }
}
