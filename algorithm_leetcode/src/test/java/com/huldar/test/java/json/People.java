package com.huldar.test.java.json;

import java.util.List;

/**
 * 测试bean
 *
 * @author huldar
 * @date 2019/7/9 08:34
 */

public class People {

    private String name;
    private List<String> friends;
    private String age;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
