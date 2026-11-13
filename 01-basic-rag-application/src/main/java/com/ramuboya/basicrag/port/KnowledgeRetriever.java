package com.ramuboya.basicrag.port;
import com.ramuboya.basicrag.domain.KnowledgeChunk;
import java.util.List;
public interface KnowledgeRetriever { List<KnowledgeChunk> retrieve(String question, int limit); }
