package com.numbers;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanLC12 {

    public String intToRoman(int num) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V", 5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",900);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);


        String str = convert(map, num);

        System.out.println(str);
      return str;
    }

    public String convert(Map<String,Integer> map, int nums){
        StringBuilder sb = new StringBuilder();
        while(nums>=1000){
            sb.append("M");
            nums= nums-1000;
        }
        if(nums>=900){
            sb.append("CM");
            nums = nums-900;
        }
        while(nums<900 && nums>=500){
            sb.append("D");
            nums = nums-500;
        }
        if(nums>=400){
            sb.append("CD");
            nums = nums-400;
        }
        while(nums<400 && nums>=100){
            sb.append("C");
            nums = nums-100;
        }
        if(nums>=90){
            sb.append("XC");
            nums = nums-90;
        }
        if(nums>=50){
            sb.append("L");
            nums = nums-50;
        }
        if(nums>=40){
            sb.append("XL");
            nums= nums-40;
        }
        while(nums>=10){
            sb.append("X");
            nums=nums-10;
        }
        if(nums==9){
            sb.append("IX");
            nums = nums-9;
        }
        while(nums>=5){
            sb.append("V");
            nums= nums-5;
        }
        if(nums==4){
            sb.append("IV");
            nums=nums-4;
        }
        while(nums>0){
            sb.append("I");
            nums = nums-1;
        }
       return sb.toString();
    }

    public static void main(String[] args) {
        int x = 1994;
        IntegerToRomanLC12 lc12 = new IntegerToRomanLC12();
        String str = lc12.intToRoman(x);
        System.out.println(str);
    }
}
