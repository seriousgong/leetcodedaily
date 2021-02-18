package com.string;


import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString string = new DecodeString();
        System.out.println(string.decodeString("3[a]2[bc]"));
        System.out.println(string.decodeString("3[a2[c]]"));
        System.out.println(string.decodeString("2[abc]3[cd]ef"));
        System.out.println(string.decodeString("100[leetcode]"));
        System.out.println(string.dliverWay("3[a2[c]]"));
    }

    public String decodeString(String s) {
        if (s.length() < 4) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ']') {
                String subString = "";
                while (true) {
                    String pop = stack.pop();
                    if (pop.equals("[")) break;
                    else subString = pop + subString;
                }
                /*取出重复次数*/
                String countStr = "";
                while (!stack.empty()) {
                    String pop = stack.pop();
                    char c1 = pop.charAt(0);
                    if (c1>=48&&c1<=57 ){
                        countStr = pop + countStr;
                    } else{
                        stack.push(pop + "");
                        break;
                    }
                }
                int count = Integer.parseInt(countStr);
                String string = "";
                for (int i = 0; i < count; i++) {
                    string += subString;
                }
                stack.push(string);
            } else {
                stack.push(c + "");
            }
            index++;
        }
        String res = "";
        while (!stack.empty()) {
            res = stack.pop() + res;
        }
        return res;
    }
    public String dliverWay(String s){
        return dliver(s,0);
    }
    private String dliver(String s,int index){
        StringBuilder stringBuilder = new StringBuilder();
        String countStr="";
        if(index<s.length()){
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='['){
                    String dliver = dliver(s, i + 1);
                    int count = Integer.parseInt(countStr);
                    for (int i1 = 0; i1 < count; i1++) {
                        stringBuilder.append(dliver);
                    }
                }else if(s.charAt(i)==']'){
                    return stringBuilder.toString();
                }else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    countStr+=s.charAt(i);
                }else {
                    stringBuilder.append(s.charAt(i));
                }
            }
        }
            return stringBuilder.toString();
    }
}
