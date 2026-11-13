package com.ramuboya.springairag.config;
import java.util.List;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SampleKnowledgeLoader {
 @Bean ApplicationRunner loadSampleKnowledge(VectorStore store) {
  return args -> {
   var docs=List.of(new Document("RAG grounds language model responses in retrieved external knowledge. A pipeline ingests documents, splits them into chunks, creates embeddings, stores vectors, retrieves relevant chunks and supplies context to the model.", java.util.Map.of("source","rag-introduction")));
   store.add(new TokenTextSplitter().apply(docs));
  };
 }
}
