package com.raghib.testngwithxml;

import org.testng.annotations.*;

/*

beforeSuite
beforeTest
beforeClass

beforeMethod
testCase1
afterMethod

beforeMethod
testCase2
afterMethod

afterClass
afterTest
afterSuite

 */
public class ExecutionFlow {

    @Test
    public void testCase1() {

        System.out.println("testCase1");
    }

    @Test
    public void testCase2() {

        System.out.println("testCase2");
    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {

        System.out.println("afterMethod");
    }

    @BeforeClass
    public void beforeClass() {

        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass() {

        System.out.println("afterClass");
    }

    @BeforeTest
    public void beforeTest() {

        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest() {

        System.out.println("afterTest");
    }

    @BeforeSuite
    public void beforeSuite() {

        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {

        System.out.println("afterSuite");
    }
}