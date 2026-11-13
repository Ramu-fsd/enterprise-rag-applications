package com.ramuboya.ingestion.service;
import com.ramuboya.ingestion.api.IngestionController.IngestRequest;
import com.ramuboya.ingestion.api.IngestionController.IngestResponse;
import java.util.List;
import java.util.Map;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
@Service
public class IngestionService {
 private final VectorStore vectorStore;
 private final TokenTextSplitter splitter = new TokenTextSplitter();
 public IngestionService(VectorStore vectorStore) { this.vectorStore=vectorStore; }
 public IngestResponse ingest(IngestRequest request) {
  String normalized=request.content().replace("\r\n","\n").strip();
  Document document=new Document(normalized, Map.of(
   "tenant_id",request.tenantId(),"document_id",request.documentId(),"title",request.title()));
  List<Document> chunks=splitter.apply(List.of(document));
  vectorStore.add(chunks);
  return new IngestResponse(request.documentId(),chunks.size(),"INDEXED");
 }
}
