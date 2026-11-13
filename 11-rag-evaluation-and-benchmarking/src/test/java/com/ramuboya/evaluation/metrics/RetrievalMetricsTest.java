package com.ramuboya.evaluation.metrics;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class RetrievalMetricsTest {
 @Test void computesPrecisionRecallAndReciprocalRank() {
   var retrieved = new LinkedHashSet<>(List.of("d1","d2","d3"));
   var relevant = Set.of("d2","d3");
   assertEquals(2.0/3.0, RetrievalMetrics.precisionAtK(retrieved, relevant, 3), 0.0001);
   assertEquals(1.0, RetrievalMetrics.recallAtK(retrieved, relevant, 3), 0.0001);
   assertEquals(0.5, RetrievalMetrics.reciprocalRank(retrieved, relevant), 0.0001);
 }
 @Test void rejectsInvalidK() { assertThrows(IllegalArgumentException.class, () -> RetrievalMetrics.precisionAtK(Set.of(), Set.of(), 0)); }
}