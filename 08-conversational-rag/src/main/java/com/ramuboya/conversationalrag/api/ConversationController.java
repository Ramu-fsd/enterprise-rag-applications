package com.ramuboya.conversationalrag.api;
import com.ramuboya.conversationalrag.domain.ChatMessage;
import com.ramuboya.conversationalrag.service.ConversationService;
import com.ramuboya.conversationalrag.service.LocalKnowledgeRetriever;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/conversations")
public class ConversationController {
 private final ConversationService conversations; private final LocalKnowledgeRetriever retriever;
 public ConversationController(ConversationService c,LocalKnowledgeRetriever r) { conversations=c;retriever=r; }
 public record MessageRequest(@NotBlank @Size(max=2000) String message) {}
 public record MessageResponse(String conversationId,String answer,List<String> sources,List<ChatMessage> history) {}
 @PostMapping("/{conversationId}/messages")
 public MessageResponse send(@PathVariable @Size(min=1,max=100) String conversationId,@Valid @RequestBody MessageRequest request) {
  conversations.append(conversationId,"user",request.message());
  List<String> evidence=retriever.retrieve(request.message());
  String historyContext=conversations.history(conversationId).stream()
   .map(m->m.role()+": "+m.content()).reduce((a,b)->a+"\n"+b).orElse("");
  String answer=evidence.isEmpty()
   ? "I do not have enough information in the local knowledge base to answer that question."
   : "Based on the retrieved knowledge: "+String.join(" ",evidence);
  conversations.append(conversationId,"assistant",answer);
  return new MessageResponse(conversationId,answer,evidence,conversations.history(conversationId));
 }
}
