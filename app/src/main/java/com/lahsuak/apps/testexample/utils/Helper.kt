package com.lahsuak.apps.testexample.utils

import android.util.Log

class Helper {
    fun isPalindrome(input: String): Boolean {
        var i = 0
        var len = input.length - 1
        var result = true
        while (i < len) {
            if (input[i] != input[len]) {
                result = false
                break
            }
            i++
            len--
        }
        return result
    }

    fun passwordValidation(input: String): String {
        return if (input.isEmpty()) {
            "String is empty"
        } else if (input.length < 6) {
            "length is less than 6"
        } else if (input.length > 15) {
            "length is more than 15"
        } else {
            "String is valid"
        }
    }

    fun reverseString(input: String): String {
        var reverseStr = ""
        for (index in input.length - 1 downTo 0) {
            reverseStr += input[index]
        }
        return reverseStr
    }
}