# Conversational memory design

- Short-term memory: recent turns with a strict token/turn budget.
- Long-term memory: only explicitly approved durable facts, stored separately with consent and retention policy.
- Retrieval memory: fetch knowledge per turn; do not assume prior assistant output is factual.
- Summarization: compress older turns while preserving user intent and unresolved references.
- Isolation: bind each conversation to an authenticated user and tenant.
- Privacy: redact sensitive values, encrypt stored history and enforce TTL/deletion.
- Safety: retrieved history and documents are untrusted context; system policy remains authoritative.

The sample uses an in-memory map and is not shared across instances. Replace it with Redis or a relational store for distributed deployment.
