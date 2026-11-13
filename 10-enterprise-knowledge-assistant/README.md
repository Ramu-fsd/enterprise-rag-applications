# 10 — Enterprise Knowledge Assistant

**Author:** Rama Boya  
**GitHub:** https://github.com/ramu-fsd  
**LinkedIn:** https://www.linkedin.com/in/ramuboya

A Java 21 / Spring Boot API starter for an enterprise RAG assistant, designed around authorization-aware retrieval, grounded answers and traceable sources.

## Run
```bash
mvn spring-boot:run
```
```bash
curl -X POST http://localhost:8080/api/v1/assistant/ask -H "Content-Type: application/json" -d '{"question":"What is the payment exception process?","tenantId":"demo-tenant","conversationId":"demo-1"}'
```

## Important
The response is intentionally a safe placeholder. This project does not yet connect an LLM, vector store, identity provider or enterprise document source. The supplied architecture document defines the production integration points and security controls.
