package com.lambada;

public class demo {
    public static void main(String[] args) {
        method1();
        method1();
        method1();
    }
    public static void  method1 (){
        final  StringBuilder a =new StringBuilder();
        Runnable asd1 = () -> {
           a.append("asd");
        };
        asd1.run();
        asd1.run();
        asd1.run();
    }
}
