package com.ramuboya.conversationalrag.service;
import com.ramuboya.conversationalrag.domain.ChatMessage;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
@Service
public class ConversationService {
 private static final int MAX_HISTORY=8;
 private final Map<String,Deque<ChatMessage>> conversations=new ConcurrentHashMap<>();
 public List<ChatMessage> history(String id) {
  return List.copyOf(conversations.getOrDefault(id,new ArrayDeque<>()));
 }
 public void append(String id,String role,String content) {
  Deque<ChatMessage> history=conversations.computeIfAbsent(id,k->new ArrayDeque<>());
  synchronized(history) {
   history.addLast(new ChatMessage(role,content,Instant.now()));
   while(history.size()>MAX_HISTORY) history.removeFirst();
  }
 }
}
