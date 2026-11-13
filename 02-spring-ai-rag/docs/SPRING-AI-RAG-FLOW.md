# Spring AI RAG flow

1. `SampleKnowledgeLoader` creates a sample document.
2. `TokenTextSplitter` creates chunks.
3. `VectorStore.add` delegates embedding and persistence.
4. `QuestionAnswerAdvisor` retrieves context for each prompt.
5. `ChatClient` calls the configured chat model.

Replace startup sample ingestion with a controlled ingestion workflow. Add document version metadata, authorization-aware filters and validated source citations before handling private knowledge.
