# 09 — Multimodal RAG

**Author:** Rama Boya  
**GitHub:** https://github.com/ramu-fsd  
**LinkedIn:** https://www.linkedin.com/in/ramuboya

## Goal
Explore retrieval over mixed enterprise content: PDFs, scanned images, diagrams, audio recordings and video.

## Stack
Java 21, Spring Boot 3.4, REST, Maven. Provider adapters are intentionally left as extension points.

## Run
```bash
mvn spring-boot:run
```
Query:
```bash
curl -X POST http://localhost:8080/api/v1/multimodal/query -H "Content-Type: application/json" -d '{"question":"Summarize the chart","documentId":"annual-report","modality":"image"}'
```

## Learning outcomes
- Design modality-specific extraction and normalization.
- Preserve page/frame/timestamp provenance.
- Secure ingestion and retrieval across tenants.
- Evaluate OCR, ASR, captioning and retrieval quality independently.

See [pipeline design](docs/MULTIMODAL-PIPELINE.md). This is a starter API and architecture exercise; no OCR, ASR, object storage or vector provider is wired in.
