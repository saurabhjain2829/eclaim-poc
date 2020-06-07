package com.nagarro;




import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;



public class IntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @BeforeClass
    public static void setUp() {
        System.out.println("Basic setup ");
    }

    @AfterClass
    public static void tearDown() {
       System.out.println("After class method ");
    }

    @Before
    public void init() {
        System.out.println("init ");
    }

    
    @Test
    public void test1() {
        
        Assert.assertTrue(true);
    }


}
