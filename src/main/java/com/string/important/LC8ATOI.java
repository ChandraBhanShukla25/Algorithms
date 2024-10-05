package com.string.important;

public class LC8ATOI {

    public static void main(String[] args) {
        System.out.println( myAtoi("   -042"));
    }

    public static int myAtoi(String s) {
      /*
         Check string length
         Trim whitespace and get non whitespace character if its '-' the take sign = -1 else 1
         run a loop and get Character and check if its betwen 0 to 9 inclduing
         If not break
         Take Threshold = Integer.MAX_VALUE/10;
         if result> threshold or resullt==threshold and currenrChar> 7 then return Integer.MAX_VALUE or Integer.MIN_VALUE depending on sign
         if result = result*10 + (currentChar -'0')

       */
        if(s==null || s.isEmpty()){
            return 0;
        }
        int index = 0;
        while(index<s.length() && s.charAt(index)==' '){
            index++;
        }
        if(index==s.length())
            return 0;
        int sign = 1;
        if(s.charAt(index)=='-'){
            sign=-1;
            index++;
        }else if(s.charAt(index)=='+'){
            index++;
        }

        int result = 0;
        int threshold = Integer.MAX_VALUE/10;
        while(index<s.length()){

            char ch = s.charAt(index);
            if(ch<'0' || ch>'9'){
                 break;
            }
            if(result>threshold || (result==threshold &&  ch>'7')){
                if(sign==1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            result = result*10+ch-'0';
            index++;
        }
        return result*sign;
    }
}
