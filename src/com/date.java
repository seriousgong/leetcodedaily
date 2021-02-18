package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
    public static void main(String[] args) throws ParseException {
        long time = new Date().getTime();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(time / 1000 / 3600 / 24);
        System.out.println(s.parse("2020-08-10 00:00:00").getTime());
        System.out.println(time);
        System.out.println(s.format(time));
        System.out.println(time / 24 *24);

        System.out.println(s.format(time / 24 *24));

    }
}

