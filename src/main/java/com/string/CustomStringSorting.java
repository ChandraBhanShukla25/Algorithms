package com.string;

import java.util.LinkedList;

public class CustomStringSorting {

    public static void main(String[] args) {
       String order = "cba",  s = "abcd";
       String order1 = "bcafg", s1 = "abcd";
       CustomStringSorting sorting = new CustomStringSorting();
       String sortedStr = sorting.customSortString(order,s);
       String sortedStr1 = sorting.customSortString(order1,s1);
       System.out.println(sortedStr);
        System.out.println(sortedStr1);
    }
    public String customSortString(String order, String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            while (list.contains(order.charAt(i))) {
                char ch = order.charAt(i);
                sb.append(ch);
                list.removeFirstOccurrence(ch);
            }
        }

        while (!list.isEmpty()) {
            char ch = list.getFirst();
            sb.append(ch);
            list.removeFirst();
        }
        return sb.toString();
    }
}
