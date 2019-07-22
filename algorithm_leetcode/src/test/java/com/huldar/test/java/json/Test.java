package com.huldar.test.java.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试fastJSON过滤字段
 *
 * @author huldar
 * @date 2019/7/9 08:33
 */
public class Test {
    public static void main(String[] args) {
        People people = new People();
        people.setName("");
        people.setPrice("1223.3");
        people.setFriends(new ArrayList<>());

        String jsonString = JSON.toJSONString(people, (PropertyFilter) (object, name, value) -> {
            if (null == value) {
                return false;
            }
            if (value instanceof List) {
                List l = (List) value;
                return l.size() != 0;
            }
            if (value instanceof String) {
                String s = (String) value;
                return StringUtils.isNotBlank(s);
            }
            return true;
        });
        System.out.println(jsonString);
    }
}
