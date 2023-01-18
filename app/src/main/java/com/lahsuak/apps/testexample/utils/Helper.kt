package com.lahsuak.apps.testexample.utils

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
}