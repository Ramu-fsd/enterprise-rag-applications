# 07 — Metadata Filtering and Multitenancy

## Objective
Demonstrate tenant-scoped retrieval, classification filters and the security rule that tenant identity must come from a verified identity context—not from an arbitrary request parameter.

## Run
```bash
mvn test
```

This project is a security-focused component and test suite. It models tenant identity extraction and mandatory filter construction without requiring a database.

## Production design
- Validate JWT signature, issuer, audience and expiry.
- Extract `tenant_id` from a trusted claim after authentication.
- Apply tenant and authorization filters to every retrieval query.
- Enforce isolation again in PostgreSQL using row-level security or tenant-separated storage.
- Audit access and test that tenant A cannot retrieve tenant B content.
