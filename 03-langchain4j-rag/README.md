# 03 — LangChain4j RAG

Explore LangChain4j document splitting, local embeddings, in-memory vector retrieval and AI Service composition.

## Run
Set `OPENAI_API_KEY`, then:
```bash
mvn spring-boot:run
```
The service listens on port 8083.
```bash
curl -X POST http://localhost:8083/api/v1/rag/ask -H "Content-Type: application/json" -d '{"question":"What is RAG?"}'
```

The in-memory embedding store is reset on restart. It is for learning only. Add persistent vector storage, metadata authorization, citations and evaluation before production use.

## Author
Rama Boya · https://github.com/ramu-fsd · https://www.linkedin.com/in/ramuboya
