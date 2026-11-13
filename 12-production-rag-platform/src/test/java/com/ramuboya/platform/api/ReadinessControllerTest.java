package com.ramuboya.platform.api;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ReadinessControllerTest {
 @Test void exposesUnconfiguredCapabilities() {
   var response = new ReadinessController().capabilities();
   assertEquals("starter", response.get("status"));
   assertEquals(false, response.get("modelProviderConfigured"));
 }
}