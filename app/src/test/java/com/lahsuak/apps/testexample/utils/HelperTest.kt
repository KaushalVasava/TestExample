package com.lahsuak.apps.testexample.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setUp() {
        helper = Helper()
        println("Before every test case")
    }

    @After
    fun finalWork() {
        println("After every test case")
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        //Arrange
        //Act
        val result = helper.isPalindrome("level")
        //Assert
        assertEquals(true, result)
    }
}