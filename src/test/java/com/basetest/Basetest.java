package com.basetest;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import qjp.Application;

//告知使用哪个运行策略
@RunWith(SpringRunner.class)
//表明是一个测试类
@SpringBootTest(classes= Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Basetest {
    @Autowired
    //@WebAppConfiguration是一个类级别的注释，
    // 您可以使用它来声明为集成测试加载的ApplicationContext应该是一个WebApplicationContext。
    // 测试类上仅存在@WebAppConfiguration就可以确保为测试加载WebApplicationContext，
    // 使用默认值“file:src/main/webapp”作为web应用程序根路径(即资源基路径)。
    // 资源基路径在后台用于创建MockServletContext，
    // 它作为测试的WebApplicationContext的ServletContext。
    private WebApplicationContext context;

    @Before
    public void contextLoads() {
        //使用上下文构建
        RestAssuredMockMvc.webAppContextSetup(this.context);
    }

}
