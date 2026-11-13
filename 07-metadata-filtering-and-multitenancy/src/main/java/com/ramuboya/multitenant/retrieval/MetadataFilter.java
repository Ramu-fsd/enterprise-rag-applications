package com.ramuboya.multitenant.retrieval;
import com.ramuboya.multitenant.security.AuthenticatedPrincipal;
import java.util.Map;
public class MetadataFilter {
 public Map<String,Object> build(AuthenticatedPrincipal principal,String classification) {
  if(principal==null) throw new SecurityException("Authenticated principal is required");
  var filters=new java.util.HashMap<String,Object>();
  filters.put("tenant_id",principal.tenantId());
  if(classification!=null && !classification.isBlank()) filters.put("classification",classification);
  return Map.copyOf(filters);
 }
}
