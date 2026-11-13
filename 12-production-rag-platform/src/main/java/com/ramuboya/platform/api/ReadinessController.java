package com.ramuboya.platform.api;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController
@RequestMapping("/api/v1/platform")
public class ReadinessController {
 @GetMapping("/capabilities")
 public Map<String, Object> capabilities() {
   return Map.of("status", "starter", "retrievalProviderConfigured", false,
     "modelProviderConfigured", false, "securityIntegrationConfigured", false);
 }
}