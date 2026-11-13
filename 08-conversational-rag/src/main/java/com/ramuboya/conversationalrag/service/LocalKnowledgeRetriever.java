package com.ramuboya.conversationalrag.service;
import java.util.List;
import org.springframework.stereotype.Component;
@Component
public class LocalKnowledgeRetriever {
 public List<String> retrieve(String question) {
  String q=question.toLowerCase();
  if(q.contains("step") || q.contains("pipeline") || q.contains("rag"))
   return List.of("RAG retrieves external knowledge and supplies it as context to a language model.",
    "Typical steps are document ingestion, chunking, embedding, vector storage, retrieval and grounded generation.");
  return List.of();
 }
}
