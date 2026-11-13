package com.ramuboya.conversationalrag.service;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ConversationServiceTest {
 @Test void boundsConversationHistory() {
  var service=new ConversationService();
  for(int i=0;i<12;i++) service.append("c1","user","message-"+i);
  assertEquals(8,service.history("c1").size());
  assertEquals("message-4",service.history("c1").get(0).content());
 }
}
