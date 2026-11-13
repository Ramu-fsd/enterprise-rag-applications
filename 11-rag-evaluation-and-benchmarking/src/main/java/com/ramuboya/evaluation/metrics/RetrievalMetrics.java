package com.ramuboya.evaluation.metrics;
import java.util.Set;
public final class RetrievalMetrics {
 private RetrievalMetrics() {}
 public static double precisionAtK(Set<String> retrieved, Set<String> relevant, int k) {
   if (k <= 0) throw new IllegalArgumentException("k must be positive");
   long hits = retrieved.stream().limit(k).filter(relevant::contains).count();
   return (double) hits / k;
 }
 public static double recallAtK(Set<String> retrieved, Set<String> relevant, int k) {
   if (k <= 0) throw new IllegalArgumentException("k must be positive");
   if (relevant.isEmpty()) return 1.0;
   long hits = retrieved.stream().limit(k).filter(relevant::contains).count();
   return (double) hits / relevant.size();
 }
 public static double reciprocalRank(Iterable<String> ranked, Set<String> relevant) {
   int rank = 0;
   for (String id : ranked) { rank++; if (relevant.contains(id)) return 1.0 / rank; }
   return 0.0;
 }
}