package com.string;

public class AddBinary {

    public static void main(String[] args) {
      String a=  "1010";
      String b = "1011";
      String result = addBinary(a,b);
    }

    public static String addBinary(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while(l1>=0 || l2>=0){
            int sum = carry;
            if(l1>=0){
                sum+=a.charAt(l1)-'0';
                l1--;
            }
            if(l2>=0){
                sum+=b.charAt(l2)-'0';
                l2--;
            }
            result.append(sum%2);
            carry=sum/2;
        }
        if(carry!=0){
            result.append(carry);
        }
      return result.reverse().toString();
    }
}
