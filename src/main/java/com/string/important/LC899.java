package com.string.important;

import java.util.Arrays;

public class LC899 {

    public static void main(String[] args) {
        String s = "nhtq";
        int k = 1;
        LC899 lc899 = new LC899();
        String result = lc899.orderlyQueue(s, k);
        System.out.println(result);
    }

    public String orderlyQueue(String s, int k) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            s = String.valueOf(arr);
            return s;
        }

        String result = "";
        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(i) + s.substring(0, i);
            if (result.isBlank()) {
                result = temp;
            }
            if (result.compareTo(temp) > 0) {
                result = temp;
            }
        }
        return result;

    }


}
