# 12 — Production RAG Platform

**Author:** Rama Boya  
**GitHub:** https://github.com/ramu-fsd  
**LinkedIn:** https://www.linkedin.com/in/ramuboya

A production architecture and deployment foundation for scaling enterprise RAG workloads on Kubernetes/OpenShift.

## Run locally
```bash
mvn spring-boot:run
```
```bash
curl http://localhost:8080/api/v1/platform/capabilities
curl http://localhost:8080/actuator/health
```

## Included
- Java 21 / Spring Boot service skeleton.
- Actuator health and metrics endpoints.
- OpenShift Deployment and Service examples.
- Production-readiness blueprint covering reliability, security, scaling, governance and cost.

## Scope
This is an architecture starter, not a production-ready RAG service. It does not include a configured model, vector database, ingestion pipeline, identity provider, telemetry exporter or secrets integration. Complete the readiness checklist and adapt deployment manifests to the target cluster before use.
