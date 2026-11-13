# Ingestion checklist

- Validate document size, encoding, MIME type and allowed file extensions.
- Normalize whitespace and extract text with a parser such as Apache Tika.
- Scan files for malware before parsing.
- Redact or tokenize sensitive data before embedding.
- Split by semantic boundaries where possible; record chunk index and source offsets.
- Attach tenant, document, version, classification and source metadata.
- Make ingestion idempotent using tenant + document + content hash.
- Track lifecycle states: RECEIVED, VALIDATED, PARSED, CHUNKED, INDEXED, FAILED.
- Retry transient failures and route exhausted events to a dead-letter queue.
- Support deletion and re-indexing when source documents change.
