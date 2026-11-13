# 05 — Document Ingestion Pipeline

## Objective
Build a controlled ingestion path that accepts text documents, validates metadata, splits content into chunks and stores chunks for later retrieval.

## Pipeline
API validation → normalization → chunking → metadata enrichment → vectorization/storage → ingestion status.

## Run
Start PostgreSQL/pgvector:
```bash
docker compose -f deployment/docker-compose.yml up -d
```
Set `SPRING_AI_OPENAI_API_KEY`, then:
```bash
mvn spring-boot:run
```
Service port: 8085.

Example:
```bash
curl -X POST http://localhost:8085/api/v1/ingestion   -H "Content-Type: application/json"   -d '{"documentId":"policy-001","title":"Sample policy","tenantId":"demo","content":"Employees must follow the approved information security policy..."}'
```

This portfolio starter accepts text content, not arbitrary uploaded binary files. For production, add file-type allowlists, Apache Tika parsing, malware scanning, PII/PCI redaction, object storage, idempotency, retry/DLQ and authenticated tenant derivation. Never trust a tenant ID supplied by an unauthenticated client.
