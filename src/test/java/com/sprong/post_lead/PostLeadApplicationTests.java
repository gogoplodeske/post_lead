package com.sprong.post_lead;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static  org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest()
@WebAppConfiguration
class PostLeadApplicationTests {
   /* @Autowired private ObjectMapper objectMapper;
    @Resource
    private MockMvc mockMvc;

    protected String mapToJson(Object obj) throws JsonProcessingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    @Autowired
    WebApplicationContext webApplicationContext;
    @Test
    void contextLoads() throws Exception{
        Input in1=new Input();
        in1.setE1("1");
        in1.setE2("7");
        in1.setH("2");
        in1.setGraph(" digraph graphname{\n1->2\n2->3\n2->5\n5->2\n3->5\n5->7}");
        String uri = "server";
        String inputJson = mapToJson(in1);
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "[7 ,5]");

    }
*/
}
