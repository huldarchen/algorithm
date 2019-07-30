package com.huldar.test.java.json;



/**
 *
 *
 * @author huldar
 * @date 2019/7/23 09:22
 */
public class StringPetterTest {
    public static void main(String[] args) {
        String sourceString = "select count(test) from < #table> join < #     table       >";
        String reg = "<\\s*#\\s*table\\s*>";
        System.out.println(sourceString.replaceAll(reg, "abd"));
    }
}
