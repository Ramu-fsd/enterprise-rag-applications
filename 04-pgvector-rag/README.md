# 04 — PostgreSQL + pgvector RAG

Focus on durable vector persistence, similarity search and metadata-aware retrieval.

## Start PostgreSQL
```bash
docker compose -f deployment/docker-compose.yml up -d
```
Set `SPRING_AI_OPENAI_API_KEY`, then run:
```bash
mvn spring-boot:run
```
Service port: 8084.
```bash
curl -X POST http://localhost:8084/api/v1/rag/ask -H "Content-Type: application/json" -d '{"question":"What is vector similarity search?"}'
```

## Topics
Vector dimensions, cosine distance, HNSW vs IVFFlat, metadata filtering, tenant isolation, embedding-model migration, indexing throughput, backup and restore.

The demo uses a fixed `demo` tenant for sample data. Do not use this pattern for real tenants. Derive tenant identity from authenticated claims and enforce isolation at the database boundary (for example PostgreSQL RLS).

## Author
Rama Boya · https://github.com/ramu-fsd · https://www.linkedin.com/in/ramuboya
