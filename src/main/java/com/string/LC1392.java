package com.string;

public class LC1392 {

    public static void main(String[] args) {
        String str = "ababab";
        LC1392 lc1392 = new LC1392();
        String res = lc1392.longestPrefix(str);
        System.out.println(res);
    }

    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        int suffix=1;
        int prefix=0;
        lps[prefix]=0;

        while(suffix<s.length()){
            if(s.charAt(suffix)==s.charAt(prefix)){
                lps[suffix] = prefix+1;
                suffix++;
                prefix++;
            }else{
                if(prefix==0){
                    lps[suffix]=0;
                    suffix++;
                }else{
                    prefix=lps[prefix-1];
                }
            }
        }
      return s.substring(0,lps[lps.length-1]);
    }
}
