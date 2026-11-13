# 08 — Conversational RAG

## Objective
Support multi-turn question answering while using retrieved knowledge for factual grounding and maintaining bounded conversation context.

## Run
```bash
mvn spring-boot:run
```
Service port: 8088. The starter uses a local in-memory conversation store and deterministic retrieval/answer composition so it runs without model credentials.

Example:
```bash
curl -X POST http://localhost:8088/api/v1/conversations/demo/messages  -H "Content-Type: application/json"  -d '{"message":"What is RAG?"}'
```
Then send a follow-up to the same conversation ID:
```bash
curl -X POST http://localhost:8088/api/v1/conversations/demo/messages  -H "Content-Type: application/json"  -d '{"message":"What are its main steps?"}'
```

## Design considerations
Conversation memory is not a substitute for retrieval. Store only bounded, relevant history; apply TTL and user/tenant authorization; avoid persisting sensitive data; and consider summarization for long conversations. In production, use a durable store and include conversation ownership checks.
