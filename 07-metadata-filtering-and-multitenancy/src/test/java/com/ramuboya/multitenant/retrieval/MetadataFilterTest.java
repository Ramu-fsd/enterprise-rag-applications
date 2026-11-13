package com.ramuboya.multitenant.retrieval;
import static org.junit.jupiter.api.Assertions.*;
import com.ramuboya.multitenant.security.AuthenticatedPrincipal;
import org.junit.jupiter.api.Test;
class MetadataFilterTest {
 @Test void alwaysIncludesAuthenticatedTenant() {
  var filter=new MetadataFilter().build(new AuthenticatedPrincipal("u1","tenant-a","READER"),"INTERNAL");
  assertEquals("tenant-a",filter.get("tenant_id"));
  assertEquals("INTERNAL",filter.get("classification"));
 }
 @Test void rejectsMissingPrincipal() {
  assertThrows(SecurityException.class,()->new MetadataFilter().build(null,null));
 }
 @Test void principalCannotHaveBlankTenant() {
  assertThrows(IllegalArgumentException.class,()->new AuthenticatedPrincipal("u1"," ","READER"));
 }
}
