# Hybrid retrieval design

1. Run lexical retrieval (PostgreSQL full-text/BM25-capable search engine).
2. Run vector retrieval with tenant and classification filters.
3. Deduplicate candidates by stable chunk ID.
4. Merge rankings with RRF; do not directly add raw BM25 and cosine scores unless calibrated.
5. Rerank the top N candidates using a cross-encoder or supported reranking service.
6. Select a small evidence set and preserve source IDs for citations.

Tune candidate counts and thresholds against a representative query set. Measure recall@k, MRR, nDCG, citation precision, answer groundedness, latency and cost. Reranking adds latency and should be applied to a bounded candidate pool.
