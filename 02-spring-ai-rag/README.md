# 02 — Spring AI RAG

Implement RAG using Spring AI `ChatClient`, `QuestionAnswerAdvisor` and the PostgreSQL pgvector store.

## Start local database
```bash
docker compose -f deployment/docker-compose.yml up -d
```
Set `SPRING_AI_OPENAI_API_KEY`, `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME` and `SPRING_DATASOURCE_PASSWORD`, then:
```bash
mvn spring-boot:run
```
The service listens on port 8082. Ask:
```bash
curl -X POST http://localhost:8082/api/v1/rag/ask -H "Content-Type: application/json" -d '{"question":"Explain the RAG pipeline"}'
```

This is a starter implementation. Configure model and embedding dimensions consistently. Add authenticated ingestion and authorization-aware metadata filtering before indexing private documents. Spring AI APIs evolve; verify compatibility when upgrading.

## Author
Rama Boya · https://github.com/ramu-fsd · https://www.linkedin.com/in/ramuboya
