package com.ramuboya.pgvectorrag.config;
import java.util.List;
import java.util.Map;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class KnowledgeBootstrap {
 @Bean ApplicationRunner loadSampleDocuments(VectorStore store) {
  return args -> {
   var docs=List.of(
    new Document("pgvector is a PostgreSQL extension that stores vector embeddings and supports similarity search. It supports exact and approximate nearest-neighbor search.",Map.of("tenant_id","demo","source","pgvector-overview")),
    new Document("Cosine distance compares vector direction. HNSW is an approximate nearest-neighbor index that can provide fast retrieval with recall and memory trade-offs.",Map.of("tenant_id","demo","source","vector-indexing")));
   store.add(new TokenTextSplitter().apply(docs));
  };
 }
}
