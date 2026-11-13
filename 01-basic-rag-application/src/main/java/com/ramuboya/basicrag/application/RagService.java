package com.ramuboya.basicrag.application;
import com.ramuboya.basicrag.domain.RagAnswer;
import com.ramuboya.basicrag.port.AnswerGenerator;
import com.ramuboya.basicrag.port.KnowledgeRetriever;
import org.springframework.stereotype.Service;
@Service
public class RagService {
 private final KnowledgeRetriever retriever; private final AnswerGenerator generator;
 public RagService(KnowledgeRetriever r, AnswerGenerator g) { retriever=r; generator=g; }
 public RagAnswer ask(String question) {
  var evidence=retriever.retrieve(question,3);
  return new RagAnswer(generator.generate(question,evidence),
   evidence.stream().map(c->c.id()+" ("+c.source()+")").toList());
 }
}
