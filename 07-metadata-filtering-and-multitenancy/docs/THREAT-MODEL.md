# Tenant-aware RAG threat model

| Threat | Control |
|---|---|
| Caller changes tenant ID in request | Ignore request tenant; use verified JWT claim |
| Vector query omits tenant filter | Centralize filter construction; fail closed |
| Prompt injection in retrieved document | Treat retrieved content as untrusted data |
| User accesses restricted classification | Apply role/ACL filter in addition to tenant |
| Cross-tenant database query | PostgreSQL RLS or physically separated storage |
| Deleted document remains searchable | Propagate tombstones/deletion to all chunks |
| Admin or support access is abused | Just-in-time access, audit and approval |

The Java filter builder is one defense layer only. It does not replace identity validation, database authorization or security testing.
