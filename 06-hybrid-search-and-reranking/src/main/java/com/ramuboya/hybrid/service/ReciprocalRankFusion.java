package com.ramuboya.hybrid.service;
import com.ramuboya.hybrid.domain.*;
import java.util.*;
public class ReciprocalRankFusion {
 public List<RankedPassage> fuse(List<List<RankedPassage>> rankedLists, int limit, int rankConstant) {
  if(rankConstant<1 || limit<1) throw new IllegalArgumentException("rankConstant and limit must be positive");
  Map<String, Passage> passages=new HashMap<>();
  Map<String, Double> scores=new HashMap<>();
  for(List<RankedPassage> list:rankedLists) {
   for(int i=0;i<list.size();i++) {
    RankedPassage item=list.get(i);
    passages.putIfAbsent(item.passage().id(),item.passage());
    scores.merge(item.passage().id(),1.0/(rankConstant+i+1),Double::sum);
   }
  }
  return scores.entrySet().stream()
   .sorted(Map.Entry.<String,Double>comparingByValue().reversed())
   .limit(limit)
   .map(e->new RankedPassage(passages.get(e.getKey()),e.getValue(),"RRF"))
   .toList();
 }
}
