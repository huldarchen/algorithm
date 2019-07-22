package com.huldar.test.java.day05;

import com.huldar.java.day05.LongestCommonPrefix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 最长公共字符串(LCP)测试类
 *
 * @author huldar
 * @date 2019/6/15 15:57
 */
class LongestCommonPrefixTest {
    @Test
    void longestCommonPrefix1() {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix1(strs));
        assertEquals("", LongestCommonPrefix.longestCommonPrefix1(strs1));
    }

    @Test
    void longestCommonPrefix2() {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix2(strs));
        assertEquals("", LongestCommonPrefix.longestCommonPrefix2(strs1));
    }
    @Test
    void longestCommonPrefix3() {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix3(strs));
        assertEquals("", LongestCommonPrefix.longestCommonPrefix3(strs1));
    }

    @Test
    void longestCommonPrefix4() {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix4(strs));
        assertEquals("", LongestCommonPrefix.longestCommonPrefix4(strs1));
    }
}