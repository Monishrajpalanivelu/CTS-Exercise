package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up test...");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down test...");
        calculator = null;
    }

    @Test
    public void testAddWithAAA() {
        
        int a = 10;
        int b = 20;
        int expectedResult = 30;

        
        int actualResult = calculator.add(a, b);

        
        assertEquals(expectedResult, actualResult);
    }
}
