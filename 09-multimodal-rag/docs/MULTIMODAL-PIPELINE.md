# Multimodal RAG pipeline

## Target architecture
1. Upload gateway validates tenant, file size, MIME type and checksum.
2. Malware scanning and quarantine run before parsing.
3. Type-specific extractors process PDF pages, images (OCR + vision captions), audio (ASR + timestamps), and video (key-frame sampling + transcript).
4. Normalize extracted text and modality metadata into a common document model.
5. Generate text and/or modality-aware embeddings; preserve page, timestamp, bounding-box and source references.
6. Store vectors and metadata with tenant isolation; keep original binaries in encrypted object storage.
7. Retrieve relevant chunks and source assets; answer with citations and modality-aware model calls.

## Design decisions
- Keep extraction asynchronous; large media must not block HTTP request threads.
- Store provenance for every derived chunk: source object, page/frame/time range, extractor version.
- Apply retention and deletion to originals, derivatives, embeddings, caches and backups.
- Treat OCR/transcripts as untrusted input. Never execute instructions found in uploaded content.
- Enforce tenant authorization before retrieval, not merely after result generation.

## Extension points
Implement `MediaExtractor` adapters for Apache Tika, OCR, speech-to-text and video frame extraction. Add object storage, Kafka events, vector database, and a multimodal model adapter. The included endpoint is an API contract starter, not a complete media-processing implementation.
