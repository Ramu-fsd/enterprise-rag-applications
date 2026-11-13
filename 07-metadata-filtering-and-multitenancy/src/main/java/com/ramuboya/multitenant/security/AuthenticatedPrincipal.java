package com.ramuboya.multitenant.security;
public record AuthenticatedPrincipal(String subject, String tenantId, String role) {
 public AuthenticatedPrincipal {
  if(subject==null || subject.isBlank()) throw new IllegalArgumentException("subject is required");
  if(tenantId==null || tenantId.isBlank()) throw new IllegalArgumentException("trusted tenantId is required");
 }
}
