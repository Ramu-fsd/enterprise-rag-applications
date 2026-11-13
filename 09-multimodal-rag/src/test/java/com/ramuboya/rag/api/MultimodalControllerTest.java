package com.ramuboya.rag.api;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(MultimodalController.class)
class MultimodalControllerTest {
 @Autowired MockMvc mvc; @Autowired ObjectMapper mapper;
 @Test void returnsMultimodalStarterResponse() throws Exception {
   mvc.perform(post("/api/v1/multimodal/query").contentType(MediaType.APPLICATION_JSON)
     .content(mapper.writeValueAsString(new MultimodalRequest("Describe the chart", "doc-1", "image"))))
     .andExpect(status().isOk()).andExpect(jsonPath("$.documentId").value("doc-1"));
 }
}