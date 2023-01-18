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

//    @Test
//    fun isPalindrome_inputString_level_expectedTrue() {
//        //Arrange
//        //Act
//        val result = helper.isPalindrome("level")
//        //Assert
//        assertEquals(true, result)
//    }

    @Test
    fun validatePassword_InputEmptyString_expected_emptyString() {
        val result = helper.passwordValidation("")
        assertEquals("String is empty", result)
    }
    @Test
    fun validatePassword_InputSmallString_expected_SmallStringError() {
        val result = helper.passwordValidation("sddn")
        assertEquals("length is less than 6", result)
    }

    @Test
    fun validatePassword_InputLargeString_expected_LargeStringError() {
        val result = helper.passwordValidation("sdddsdkskdsdskdskdskdkskd")
        assertEquals("length is more than 15", result)
    }

    @Test
    fun validatePassword_InputLargeString_expected_ValidString() {
        val result = helper.passwordValidation("sdddsdkskdsd")
        assertEquals("String is valid", result)
    }

    @Test
    fun validReverseString_InputEmptyString_expected_emptyString() {
        val result = helper.reverseString("")
        assertEquals("", result)
    }
    @Test
    fun validReverseString_InputSingleCharacter_expected_SingleCharacter() {
        val result = helper.reverseString("c")
        assertEquals("c", result)
    }
    @Test
    fun validReverseString_InputString_expected_ReverseString() {
        val result = helper.reverseString("abc")
        assertEquals("cba", result)
    }
}