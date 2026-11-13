package com.ramuboya.hybrid.port;
import com.ramuboya.hybrid.domain.Passage;
import java.util.List;
public interface Reranker { List<Passage> rerank(String query, List<Passage> candidates, int limit); }
