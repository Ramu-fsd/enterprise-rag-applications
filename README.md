# RAG Applications

A structured, hands-on portfolio of Retrieval-Augmented Generation (RAG) applications and enterprise architecture patterns, built primarily with **Java 21** and **Spring Boot**.

The repository progresses from foundational RAG concepts to multimodal retrieval, enterprise knowledge assistants, evaluation, and production platform design.

## Author

**Rama Boya**

- GitHub: [ramu-fsd](https://github.com/ramu-fsd)
- LinkedIn: [Rama Boya](https://www.linkedin.com/in/ramuboya)

## Repository objectives

- Build practical RAG knowledge through progressively advanced projects.
- Explore Java-based LLM and retrieval integrations.
- Understand ingestion, chunking, embeddings, vector search, hybrid retrieval and reranking.
- Design secure, multi-tenant enterprise knowledge experiences.
- Evaluate answer quality, retrieval relevance, latency and cost.
- Apply production architecture practices for reliability, observability and governance.

## Technology landscape

| Area | Technologies / concepts |
|---|---|
| Language and runtime | Java 21, Maven |
| Application framework | Spring Boot, Spring AI |
| LLM frameworks | LangChain4j |
| Models and providers | Provider adapters; model integration examples |
| Vector search | PostgreSQL, pgvector |
| Retrieval | Semantic search, lexical search, hybrid search, reranking |
| Messaging and ingestion | Kafka concepts, asynchronous document processing |
| Platform | Docker, Kubernetes, OpenShift |
| Enterprise concerns | OIDC/JWT, tenant isolation, ACL filtering, audit, observability |

The technology list describes the learning scope across the repository. Not every project integrates every technology.

## Project roadmap

| # | Project | Focus |
|---|---|---|
| 01 | [Basic RAG Application](01-basic-rag-application/) | RAG fundamentals and a minimal retrieval flow |
| 02 | [Spring AI RAG](02-spring-ai-rag/) | Spring AI retrieval and generation integration |
| 03 | [LangChain4j RAG](03-langchain4j-rag/) | Java LLM application patterns with LangChain4j |
| 04 | [pgvector RAG](04-pgvector-rag/) | Vector storage and similarity retrieval |
| 05 | [Document Ingestion Pipeline](05-document-ingestion-pipeline/) | Document processing and indexing |
| 06 | [Hybrid Search and Reranking](06-hybrid-search-and-reranking/) | Combining retrieval channels and ranking evidence |
| 07 | [Metadata Filtering and Multitenancy](07-metadata-filtering-and-multitenancy/) | Tenant-aware and metadata-constrained retrieval |
| 08 | [Conversational RAG](08-conversational-rag/) | Conversation context and follow-up questions |
| 09 | [Multimodal RAG](09-multimodal-rag/) | Retrieval across text, images, audio and video |
| 10 | [Enterprise Knowledge Assistant](10-enterprise-knowledge-assistant/) | Enterprise assistant API and reference architecture |
| 11 | [RAG Evaluation and Benchmarking](11-rag-evaluation-and-benchmarking/) | Retrieval metrics and quality evaluation |
| 12 | [Production RAG Platform](12-production-rag-platform/) | Production readiness, operations and OpenShift deployment |

## Suggested learning sequence

1. Understand the end-to-end RAG lifecycle in Projects 01–04.
2. Study ingestion, retrieval quality and conversation patterns in Projects 05–08.
3. Explore multimodal and enterprise use cases in Projects 09–10.
4. Establish measurable quality gates and production operating practices in Projects 11–12.

## Typical RAG lifecycle

```text
Source Documents
      |
      v
Ingestion -> Parsing -> Cleaning -> Chunking
      |                         |
      v                         v
Metadata / ACLs             Embeddings
      |                         |
      +------------+------------+
                   |
                   v
            Vector + Lexical Index
                   |
User Query -> Query Processing -> Authorized Retrieval
                                      |
                                      v
                                  Reranking
                                      |
                                      v
                              Context Construction
                                      |
                                      v
                                LLM Generation
                                      |
                                      v
                         Grounded Answer + Citations
```

## Getting started

Each project has its own README with its scope, prerequisites and run instructions.

For Maven-based projects:

```bash
mvn test
mvn spring-boot:run
```

Run these commands from the individual project's directory. Some projects require external services, API credentials or additional configuration; consult that project's README before starting it.

## Engineering principles

- Keep model, embedding and vector-store integrations behind clear interfaces where practical.
- Make retrieval authorization-aware; do not rely on post-generation filtering.
- Preserve source provenance so answers can cite the underlying evidence.
- Treat retrieved documents and user uploads as untrusted input.
- Keep secrets out of source control and use environment-based configuration or a secrets manager.
- Measure retrieval quality and answer quality separately.
- Establish explicit latency, availability, cost and data-freshness objectives before production rollout.

## Repository structure

```text
rag-applications/
├── 01-basic-rag-application/
├── 02-spring-ai-rag/
├── 03-langchain4j-rag/
├── 04-pgvector-rag/
├── 05-document-ingestion-pipeline/
├── 06-hybrid-search-and-reranking/
├── 07-metadata-filtering-and-multitenancy/
├── 08-conversational-rag/
├── 09-multimodal-rag/
├── 10-enterprise-knowledge-assistant/
├── 11-rag-evaluation-and-benchmarking/
├── 12-production-rag-platform/
├── docs/
├── .editorconfig
├── .gitattributes
├── .gitignore
├── CONTRIBUTING.md
├── CODE_OF_CONDUCT.md
├── LICENSE
├── README.md
└── SECURITY.md
```

## Scope and implementation status

This repository is a learning and portfolio collection. Projects vary in implementation depth: some contain runnable starter services or focused Java examples, while others provide reference architecture and extension points. A documented integration is not necessarily a fully wired production integration.

Before using any project in a real environment:
- Review dependency and provider versions.
- Configure authentication, authorization, secrets and network policies.
- Run tests and security scans.
- Validate tenant isolation and data deletion behavior.
- Perform load, resilience and recovery testing.

## License

Released under the [MIT License](LICENSE).
