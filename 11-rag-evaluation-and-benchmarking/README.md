# 11 — RAG Evaluation and Benchmarking

**Author:** Rama Boya  
**GitHub:** https://github.com/ramu-fsd  
**LinkedIn:** https://www.linkedin.com/in/ramuboya

A lightweight Java evaluation foundation for measuring retrieval quality and designing repeatable RAG regression suites.

## Run tests
```bash
mvn test
```

## Included
- Precision@K, Recall@K and reciprocal-rank metric examples.
- Small JSONL evaluation dataset with banking/enterprise examples.
- Evaluation plan covering retrieval, generation, operations and safety.

## Extend
Add nDCG@K, citation verification, answer faithfulness review, dataset versioning, experiment tracking and CI quality gates. The sample dataset is illustrative; curate and validate a representative, permission-safe evaluation corpus before using results for release decisions.
