# Enterprise knowledge assistant — reference architecture

## Request flow
1. API gateway validates token, rate limit and request size.
2. Identity service maps subject to tenant, roles, groups and entitlements.
3. Query policy layer applies data classification, allowed collections and prompt-injection controls.
4. Hybrid retrieval searches lexical and vector indexes with mandatory tenant/ACL filters.
5. Reranker selects evidence; context builder enforces token budget and provenance.
6. Model gateway routes to an approved model with timeout, retry budget and redaction.
7. Response validator checks citations, sensitive-data policy and refusal conditions.
8. Audit pipeline records actor, tenant, model/version, retrieved document IDs, policy decisions, latency and token usage.

## Banking use cases
- Operations policy assistant with citations and effective dates.
- Developer assistant over approved API and runbook documentation.
- Contact-centre agent assist with strict customer-data entitlements.
- Compliance procedure discovery with human review for consequential actions.

## Non-functional requirements
Define p95 latency, availability, concurrency, freshness, retrieval recall, citation coverage, cost per successful answer, RTO/RPO, and deletion SLA. Establish thresholds from measured baselines rather than copying generic targets.

## Security boundaries
The `tenantId` in the request is illustrative only. In production derive tenant and permissions from a verified identity context; never trust caller-supplied tenant IDs. Apply ACL filtering inside the retrieval query and test cross-tenant leakage.
