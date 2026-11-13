package com.ramuboya.langchainrag.config;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class LangChainConfiguration {
 @Bean ChatLanguageModel chatModel() {
  String key=System.getenv("OPENAI_API_KEY");
  if(key==null || key.isBlank()) throw new IllegalStateException("Set OPENAI_API_KEY");
  return OpenAiChatModel.builder().apiKey(key).modelName(System.getenv().getOrDefault("OPENAI_CHAT_MODEL","gpt-4o-mini")).build();
 }
 @Bean EmbeddingModel embeddingModel() {
  return new dev.langchain4j.model.embedding.onnx.allminilml6v2.AllMiniLmL6V2EmbeddingModel();
 }
 @Bean EmbeddingStore<TextSegment> embeddingStore() { return new InMemoryEmbeddingStore<>(); }
 @Bean ContentRetriever contentRetriever(EmbeddingStore<TextSegment> store, EmbeddingModel model) {
  return EmbeddingStoreContentRetriever.builder().embeddingStore(store).embeddingModel(model).maxResults(4).minScore(0.55).build();
 }
 @Bean org.springframework.boot.ApplicationRunner sampleIndexer(EmbeddingStore<TextSegment> store, EmbeddingModel model) {
  return args -> {
   Document doc=Document.from("Retrieval-Augmented Generation combines document retrieval with language generation. A RAG workflow loads documents, splits them into segments, embeds segments, stores vectors, retrieves relevant segments and supplies them to a language model.");
   EmbeddingStoreIngestor.builder().documentSplitter(DocumentSplitters.recursive(500,80))
    .embeddingModel(model).embeddingStore(store).build().ingest(doc);
  };
 }
}
