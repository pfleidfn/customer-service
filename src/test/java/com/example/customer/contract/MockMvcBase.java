package com.example.customer.contract;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Base class for RestAssured-MockMVC contract tests
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class MockMvcBase {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Before
  public void setup() {
    RestAssuredMockMvc.mockMvc(mockMvc);
  }
}