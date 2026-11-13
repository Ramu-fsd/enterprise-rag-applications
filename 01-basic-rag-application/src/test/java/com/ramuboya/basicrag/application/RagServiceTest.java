package com.ramuboya.basicrag.application;
import static org.junit.jupiter.api.Assertions.*;
import com.ramuboya.basicrag.adapter.*;
import org.junit.jupiter.api.Test;
class RagServiceTest {
 @Test void returnsAnswerAndSources() {
  var service=new RagService(new InMemoryKnowledgeRetriever(),new ContextAnswerGenerator());
  var result=service.ask("What is a RAG pipeline?");
  assertNotNull(result.answer()); assertFalse(result.sourceIds().isEmpty());
 }
}
