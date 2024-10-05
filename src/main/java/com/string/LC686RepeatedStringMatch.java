package com.string;

public class LC686RepeatedStringMatch {
    public static void main(String[] args) {
        String a = "abcd"; String b = "cdabcdab";
        LC686RepeatedStringMatch repeated = new LC686RepeatedStringMatch();
        int count = repeated.repeatedStringMatch(a,b);
        System.out.println(count);
    }

    public int repeatedStringMatch(String a, String b) {
       int l1 = a.length();
       int l2 = b.length();
       double len = Math.ceil(l2 / l1);
       int repetitions = (int)len;
       StringBuilder sb = new StringBuilder(a.repeat(repetitions));
       for(int i=0;i<2;i++){
           if(sb.toString().contains(b)){
               return repetitions;
           }
           repetitions++;
           sb.append(a);
       }
       return repetitions;
    }
}
