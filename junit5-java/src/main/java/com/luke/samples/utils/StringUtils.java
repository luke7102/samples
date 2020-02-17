package com.luke.samples.utils;

public class StringUtils {

    public static boolean isPalindrome(String str) {
        if(str == null || str.isEmpty()) {
            return false;
        }

        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
