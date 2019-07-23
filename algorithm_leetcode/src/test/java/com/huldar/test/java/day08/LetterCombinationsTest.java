package com.huldar.test.java.day08;

import com.huldar.java.day08.LetterCombinations;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author huldar
 * @date 2019/7/23 16:38
 */
class LetterCombinationsTest {
    @Test
    void letterCombinations() {
        List<String> strings = LetterCombinations.letterCombinations1("23");
        System.out.println(Arrays.toString(strings.toArray()));
    }

    @Test
    void charterTest() {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations("23");
        System.out.println(Arrays.toString(result.toArray()));
    }
}