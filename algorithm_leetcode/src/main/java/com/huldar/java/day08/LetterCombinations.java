package com.huldar.java.day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码组合
 *
 * @author huldar
 * @date 2019/7/23 16:17
 */
public class LetterCombinations {

    private HashMap<String, String> mapping = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> output = new ArrayList<>();

    /**
     * 使用论坛做法
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        LinkedList<String> result = new LinkedList<>();
        String reg = "[2-9]+";
        boolean matchesFlag = digits.matches(reg);
        if (!matchesFlag) {
//            throw new IllegalArgumentException("输入的数据应该为2-9的数字");
            return result;
        }

        //数据字典
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            int x = Character.getNumericValue(ch);
            while (result.peek().length() == i) {
                String t = result.remove();
                for (char s : mapping[x].toCharArray()) {
                    result.add(t + s);
                }
            }
        }
        return result;
    }

    /**
     * 回溯算法 需要查下资料
     *
     * @param combination
     * @param nextDigits
     */
    private void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = mapping.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = mapping.get(digit).substring(i, i + 1);
                String combination1 = combination + letter;
                String nextDigits1 = nextDigits.substring(1);
                backtrack(combination1, nextDigits1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

}
