package com.array;

public class LC67AddBInary {


    public String addBinary(String a, String b) {
       StringBuilder c = new StringBuilder();
       StringBuilder a1 = new StringBuilder(a);
       StringBuilder b1 = new StringBuilder(b);
       a1.reverse();
       b1.reverse();
       int i=0;
       char carry = '0';
       // all a1, carry, b1 is 1
        // only a1 and b1 is 1
        // only a1, carry is 1
        //only b1 and carry is 1
        // only carry is 1
       while(i<a1.length() && i<b1.length()){
           if(a1.charAt(i)=='1' && b1.charAt(i)=='1' && carry=='1'){
                   c.append('1');
                   carry='1';
           }else if(a1.charAt(i)=='1' && b1.charAt(i)=='1'){
               c.append('0');
               carry='1';
           } else if(a1.charAt(i)=='1' && carry=='1'){
               c.append('0');
               carry='1';
           }else if(b1.charAt(i)=='1' && carry=='1'){
               c.append('0');
               carry='1';
           } else if (a1.charAt(i)=='1' && carry=='0'){
               c.append('1');
               carry='0';
           } else if (b1.charAt(i)=='1' && carry=='0'){
               c.append('1');
               carry='0';
           } else if(carry=='1'){
               c.append('1');
               carry='0';
           } else{
               c.append('0');
           }
           i++;
       }
       if(i<a1.length()){
           if(carry=='1' && a1.charAt(i)=='1'){
               carry='1';
               c.append('0');
           }else{
               c.append('1');
               carry='0';
           }
           i++;
       }

        if(i<b1.length()){
            if(carry=='1' && b1.charAt(i)=='1'){
                carry='1';
                c.append('0');
            }else{
                c.append('1');
                carry='0';
            }
            i++;
        }
        if(carry!='0'){
            c.append('1');
        }
        c.reverse();
       return c.toString();
    }

    public static void main(String[] args) {
       String  a = "1010"; String b = "1011";
       LC67AddBInary addBInary = new LC67AddBInary();
       String s1 = addBInary.addBinary(a,b);
       System.out.println(s1);
    }
}
