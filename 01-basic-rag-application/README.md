# 01 — Basic RAG Application

A provider-neutral introduction to the RAG pipeline: document loading, chunking, embeddings, vector storage, retrieval, prompt construction and answer generation.

This Spring Boot sample uses deterministic in-memory knowledge and lexical overlap retrieval so it runs without cloud credentials. It is an architectural learning demo, not semantic vector search.

## Run
```bash
mvn spring-boot:run
```
Ask:
```bash
curl -X POST http://localhost:8081/api/v1/rag/ask -H "Content-Type: application/json" -d '{"question":"What is a RAG pipeline?"}'
```

## API
`POST /api/v1/rag/ask` — returns a demo answer and source IDs.  
`GET /actuator/health` — health check.

## Next improvements
Replace the demo adapters with a real embedding model and vector store; add chunk overlap, metadata, authorization, persistence, evaluation and observability.

## Author
Rama Boya · https://github.com/ramu-fsd · https://www.linkedin.com/in/ramuboya
