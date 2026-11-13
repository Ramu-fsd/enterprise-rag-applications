# 06 — Hybrid Search and Reranking

## Objective
Improve retrieval quality by combining lexical and semantic candidate sets, merging them and reranking the most promising passages.

## Concepts
- BM25 / lexical search finds exact terms, identifiers and domain phrases.
- Vector similarity finds semantically related content.
- Reciprocal Rank Fusion (RRF) merges ranked lists without assuming score scales are comparable.
- A reranker evaluates query-passage relevance for a smaller candidate set.

## Included
A provider-neutral Java implementation of RRF and a reranking port, plus architecture notes for plugging in PostgreSQL full-text search, pgvector and a cross-encoder or hosted reranking model.

## Run tests
```bash
mvn test
```
This project is an algorithmic component library rather than a hosted-model application. The default sample reranker is deterministic and intended for tests only.
