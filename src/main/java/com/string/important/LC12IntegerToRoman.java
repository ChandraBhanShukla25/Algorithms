package com.string.important;

public class LC12IntegerToRoman {

    int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        int nums = 58;
        LC12IntegerToRoman integerToRoman = new LC12IntegerToRoman();
        String result = integerToRoman.intToRoman(nums);
        System.out.println(result);
    }


    public String intToRoman(int nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int times = nums / arr[i];
            nums = nums % arr[i];
            if (times > 0) {
                int k = 0;
                while (k < times) {
                    sb.append(roman[i]);
                    k++;
                }

            }
        }
        return sb.toString();
    }
}
