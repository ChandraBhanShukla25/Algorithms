package com.string.important;

public class KMPAlgorithm {
//https://favtutor.com/blogs/kmp-algorithm
    public static void main(String[] args) {
        String txt = "AABAACAADAABAABA";
        String pattern = "AABA";
        KMPAlgorithm algorithm = new KMPAlgorithm();
        algorithm.kmp(pattern,txt);
    }

    void kmp(String pattern, String txt){
        int m = pattern.length();
        int n = txt.length();
        int lps[] = new int[m];
        int prefix=0;
        lpsArray(pattern, lps);
        int suffix=0;
        int x = 100000;
        while((n-suffix)>=(m-prefix)){
            if(pattern.charAt(prefix)==txt.charAt(suffix)){
                suffix++;
                prefix++;
            }
            if(prefix==m) {
                System.out.println("Pattern found at index " + (suffix - prefix));
                prefix=lps[prefix-1];
            }else if(suffix<n && pattern.charAt(prefix)!=txt.charAt(suffix)){
                if(prefix==0){
                    suffix=suffix+1;
                }else{
                    prefix=lps[prefix-1];
                }
            }
        }
    }

    private void lpsArray(String pattern, int[] lps) {
        int prefix = 0;
        int suffix=1;
        lps[0]=0;
        while(suffix<pattern.length()){
            if(pattern.charAt(suffix)==pattern.charAt(prefix)){
                lps[suffix]=prefix+1;
                suffix++;
                prefix++;
            }else{
                if(prefix==0){
                    suffix++;
                }else{
                    prefix=lps[prefix-1];
                }
            }
        }
    }
}
