package com.xqr.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("junit5功能测试")
//@SpringBootTest//加了注解可以用spring的容器
public class Junit5Test {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("测试前置条件")
    void testassuptems(){
        Assumptions.assumeTrue(true,"结果不是true");
        System.out.println(1111);
    }

    /*
    * 断言：前面断言失败，后面断言不执行
    * */
    @DisplayName("测试简单断言")
    @Test
    void testSimmpleAssert(){
        int cal=cal(2,3);
        assertEquals(5,cal,"业务逻辑测试失败");
        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1,o2,"两个对象不一样");
    }
    @DisplayName("测试数组断言")
    @Test
    void testarrat(){
        assertArrayEquals(new int[]{2,1},new int[]{1,2});
    }
    @Test
    @DisplayName("组合断言")
    public void all() {
        /*
        * 声明的所有断言都成功才会成功
        * */
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @DisplayName("异常断言")
    @Test
    void testException(){
        assertThrows(ArithmeticException.class,()->{int i=10/2;},"数学逻辑居然成功了?");
    }
    @Test
    @DisplayName("fail")//快速失败
    public void shouldFail() {
        fail("This should fail");
    }
        int cal(int i,int j){
            return i+j;
        }


    @DisplayName("测试DisplayName注解")
    @Test
    void testDisplayName(){
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }
    @Disabled //表示禁用该测试方法
    @DisplayName("测试方法2")
    @Test
    void test2(){
        System.out.println(2);
    }
    @RepeatedTest(5) //重复测试5次
    @Test
    void test3(){
        System.out.println(3);
    }
    /*
    * 规定超时时间
    * */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @DisplayName("超时注解测试")
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @BeforeEach
    void testBefore(){
        System.out.println("测试开始--->");
    }
    @AfterEach
    void testAfter(){
        System.out.println(" --->测试结束");
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("----所有测试开始----");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("----所有测试结束----");
    }
}
