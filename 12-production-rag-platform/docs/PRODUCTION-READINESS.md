# Production RAG platform — readiness blueprint

## Platform capabilities
- API gateway, OIDC/JWT validation, tenant and document-level authorization.
- Ingestion workers separated from query-serving workloads.
- Durable event backbone, retry policy, idempotency keys and dead-letter queues.
- Object storage for originals; relational metadata store; vector and lexical indexes.
- Model gateway with approved model registry, timeout, bounded retries and fallback policy.
- Secrets manager, encryption in transit/at rest, key rotation and private networking.
- OpenTelemetry traces, RED metrics, structured logs and audit events.

## Reliability
Define SLOs for query availability, p95 latency, ingestion freshness and successful citation rate. Use bulkheads, bounded queues, circuit breakers, backpressure and graceful degradation. Avoid retry storms; retries must fit within an end-to-end deadline. Run load, soak, failover and restore tests.

## Scaling
Scale query API on concurrency/CPU/latency; scale ingestion consumers on queue lag and processing time. Partition by tenant or workload only after measuring hotspots. Plan vector-index capacity, embedding throughput, model quotas and connection pools independently.

## Security and governance
Enforce tenant and ACL filters at retrieval time. Redact sensitive content before model calls where policy requires. Treat retrieved text as untrusted. Record model/version, prompt template version, source IDs and policy decisions. Support deletion propagation through source files, chunks, vectors, caches and backups.

## Cost controls
Track cost per query and per accepted answer, embedding spend, token counts, cache hit rate and reprocessing volume. Use model routing, context compression, semantic caching only where isolation is preserved, and budget alerts.

## Deployment notes
The OpenShift YAML is a baseline illustration. Replace the image, namespace, service account, security context, probes and resource values for your cluster. Add Route/Ingress, NetworkPolicy, HPA, PDB, ConfigMaps/Secrets, image policy and CI/CD promotion gates.
