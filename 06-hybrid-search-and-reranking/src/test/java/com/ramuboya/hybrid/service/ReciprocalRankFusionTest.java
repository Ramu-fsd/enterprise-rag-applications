package com.ramuboya.hybrid.service;
import static org.junit.jupiter.api.Assertions.*;
import com.ramuboya.hybrid.domain.*;
import java.util.List;
import org.junit.jupiter.api.Test;
class ReciprocalRankFusionTest {
 @Test void promotesDocumentsRankedByMultipleChannels() {
  var a=new Passage("A","alpha","a"); var b=new Passage("B","beta","b"); var c=new Passage("C","gamma","c");
  var result=new ReciprocalRankFusion().fuse(List.of(
   List.of(new RankedPassage(a,0.9,"vector"),new RankedPassage(b,0.8,"vector")),
   List.of(new RankedPassage(b,12,"keyword"),new RankedPassage(c,9,"keyword"))),3,60);
  assertEquals("B",result.get(0).passage().id());
 }
}
