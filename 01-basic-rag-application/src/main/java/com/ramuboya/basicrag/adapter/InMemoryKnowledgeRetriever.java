package com.ramuboya.basicrag.adapter;
import com.ramuboya.basicrag.domain.KnowledgeChunk;
import com.ramuboya.basicrag.port.KnowledgeRetriever;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class InMemoryKnowledgeRetriever implements KnowledgeRetriever {
 private final List<KnowledgeChunk> chunks = List.of(
  new KnowledgeChunk("rag-001", "Retrieval augmented generation combines information retrieval with text generation. Relevant external knowledge is retrieved and supplied as context to a language model.", "rag-basics.md"),
  new KnowledgeChunk("rag-002", "A typical RAG pipeline contains document ingestion, chunking, embedding generation, vector storage, similarity search, prompt construction and answer generation.", "rag-pipeline.md"),
  new KnowledgeChunk("rag-003", "Chunk size, overlap, metadata filters and retrieval count influence retrieval quality. Evaluate recall, relevance, groundedness and citation correctness.", "rag-quality.md"));
 @Override public List<KnowledgeChunk> retrieve(String question, int limit) {
  String[] terms = question.toLowerCase().split("\\W+");
  return chunks.stream().map(c -> new Scored(c, score(c, terms)))
   .filter(s -> s.score > 0).sorted(Comparator.comparingInt(Scored::score).reversed())
   .limit(limit).map(Scored::chunk).toList();
 }
 private int score(KnowledgeChunk c, String[] terms) {
  int score=0; String content=c.content().toLowerCase();
  for (String term: terms) if (term.length()>2 && content.contains(term)) score++;
  return score;
 }
 private record Scored(KnowledgeChunk chunk, int score) {}
}
