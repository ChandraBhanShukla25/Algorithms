package com.array;

import java.util.Arrays;

public class LC43MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "0"; String num2 = "0";
        LC43MultiplyStrings multiplyStrings = new LC43MultiplyStrings();
        String res =  multiplyStrings.multiply(num1,num2);
        System.out.println(res);
    }

    public String multiply(String num1, String num2) {
       int carry = 0;
       int[] res = new int[num1.length()+num2.length()];
        Arrays.fill(res,0);
       int index =0;
       int times = 0;
       for(int i=num1.length()-1;i>=0;i--){
           index = times;
           for(int j=num2.length()-1;j>=0;j--){
               int mul = (num1.charAt(i)-48)*(num2.charAt(j)-48);
               int val = (mul + carry + res[index])%10;
               carry =  (mul + carry + res[index])/10;
               res[index]=val;
               index++;
           }
           if(carry!=0) {
               res[index] = carry;
           }
           carry=0;
           times++;
       }

       StringBuilder sb = new StringBuilder();
       int i=res.length-1;
       while(i>=0 && res[i]==0){
           i--;
       }
       while(i>=0){
           sb.append(res[i]);
           i--;
       }
       if(sb.toString().isEmpty()){
           return "0";
       }else{
           return sb.toString();
       }
    }
}
