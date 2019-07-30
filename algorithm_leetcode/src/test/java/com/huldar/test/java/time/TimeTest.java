package com.huldar.test.java.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 *
 * @author huldar
 * @date 2019/6/26 14:44
 */
public class TimeTest {
    public static void main(String[] args) {
        String endDt = "20190626";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
        LocalDate endDate = LocalDate.parse(endDt, dateTimeFormatter);
//        LocalDateTime rec30Day = endDate.minusDays(30);
//        System.out.println(rec30Day.format(timeFormatter));
        LocalDate rec30Day = endDate.minusDays(30);
        System.out.println(rec30Day.format(timeFormatter));
        System.out.println(LocalDate.parse("2019-07-01", DateTimeFormatter.ISO_LOCAL_DATE).format(DateTimeFormatter.ofPattern("MM.dd")));
        String format = LocalDate.now().minusDays(62).format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format);
    }
}
