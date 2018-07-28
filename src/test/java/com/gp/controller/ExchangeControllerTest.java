package com.gp.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: gaopeng
 * @Date: 2018-07-27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExchangeControllerTest {
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;
    @Before
    public void initMvc() {
        // 初始化mvc实例
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void exchangeRate() throws Exception {
       String response=  mvc.perform(get("/convert/CNY/USD").param("amount","1")).andReturn().getResponse().getContentAsString();
        System.out.println("单元测试响应结果: "+response);
    }
}