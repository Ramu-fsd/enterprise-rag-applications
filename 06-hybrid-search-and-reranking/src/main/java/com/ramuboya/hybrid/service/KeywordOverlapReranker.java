package com.ramuboya.hybrid.service;
import com.ramuboya.hybrid.domain.Passage;
import com.ramuboya.hybrid.port.Reranker;
import java.util.*;
public class KeywordOverlapReranker implements Reranker {
 // Deterministic example only. Replace with a trained cross-encoder for production.
 public List<Passage> rerank(String query,List<Passage> candidates,int limit) {
  Set<String> terms=new HashSet<>(Arrays.asList(query.toLowerCase().split("\\W+")));
  return candidates.stream().sorted(Comparator.comparingInt((Passage p)->
   (int)terms.stream().filter(t->t.length()>2 && p.text().toLowerCase().contains(t)).count()).reversed())
   .limit(limit).toList();
 }
}
