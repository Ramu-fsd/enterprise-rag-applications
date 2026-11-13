# RAG evaluation and benchmarking

## Evaluate separate layers
- Retrieval: Recall@K, Precision@K, MRR, nDCG@K, filtered retrieval correctness.
- Generation: answer relevance, groundedness/faithfulness, citation precision and coverage, abstention quality.
- Operations: p50/p95/p99 latency, throughput, error rate, token usage, cost per accepted answer.
- Safety: prompt-injection resistance, cross-tenant leakage, sensitive-data exposure, unsafe tool invocation.

## Dataset governance
Maintain versioned questions, expected facts, relevant document IDs, risk tier and reviewer notes. Remove secrets and personal data. Include difficult negatives, ambiguous queries, stale documents and permission-boundary cases. Keep a held-out regression set.

## Benchmark protocol
1. Pin corpus snapshot, chunker, embedding model, index settings, reranker and LLM version.
2. Run retrieval-only evaluation before generation evaluation.
3. Use deterministic settings where possible; repeat stochastic tests.
4. Combine automated metrics with expert review; LLM-as-judge is a signal, not ground truth.
5. Report confidence intervals and slice results by domain, language, document type and risk.
6. Block release on critical security regressions even if aggregate quality improves.

## Metrics implementation
`RetrievalMetrics` supplies small deterministic examples for Precision@K, Recall@K and reciprocal rank. It is not a complete benchmark harness and does not calculate nDCG, generation quality or cost.
