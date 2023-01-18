package com.lahsuak.apps.testexample.utils

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(private val input: String,private val expectedResult: Boolean) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isPalindrome(input)
        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: {0} is palindrome - {1}")
        fun data():List<Array<Any>>{
            return listOf(
                arrayOf("hello", true),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true),
                arrayOf("fgf", true)
            )
        }
    }
}