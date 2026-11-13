# LangChain4j RAG flow

- `EmbeddingModel` creates vectors for document segments and user questions.
- `EmbeddingStore` stores vectors; this starter uses `InMemoryEmbeddingStore`.
- `EmbeddingStoreIngestor` splits, embeds and indexes sample content.
- `EmbeddingStoreContentRetriever` retrieves relevant segments.
- `RagAssistant` combines retrieved context with the question and chat model.

The in-memory store is reset at restart. Replace it with persistent storage for a durable service.
