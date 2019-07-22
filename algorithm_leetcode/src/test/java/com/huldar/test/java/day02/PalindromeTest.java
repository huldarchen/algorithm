package com.huldar.test.java.day02;

import com.huldar.java.day02.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author huldar
 * @date 2019/6/5 10:22
 */
public class PalindromeTest {
    @Test
    void isPalindromeTest() {
        assertEquals(true, Palindrome.isPalindrome(121));
        assertEquals(false, Palindrome.isPalindrome(12));
        assertEquals(false, Palindrome.isPalindrome(-121));
        assertEquals(true, Palindrome.isPalindrome(11));

    }
}
