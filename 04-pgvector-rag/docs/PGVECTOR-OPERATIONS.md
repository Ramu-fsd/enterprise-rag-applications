# pgvector operations

Verify extension:
```sql
SELECT extname FROM pg_extension WHERE extname = 'vector';
```

The Spring AI PgVectorStore manages its table schema; inspect the exact schema for the pinned library version before writing custom SQL.

Benchmark cosine distance and HNSW/IVFFlat with representative data. Measure recall@k and p95 latency. Plan for connection pooling, backups, restore tests, model migration/re-embedding, document deletion propagation and index maintenance. Metadata filtering is not a substitute for database-level tenant isolation.
