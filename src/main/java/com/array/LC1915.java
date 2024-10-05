package com.array;

public class LC1915 {

    public static void main(String[] args) {
        LC1915 lc1915 = new LC1915();
        String word = "aabb";
        //lc1915.wonderfulSubstrings()
    }

    public long wonderfulSubstrings(String word) {

        int i=1;
        int j=0;
        int arr[] = new int[10];
        int count= 0;
        while(i<word.length()){
            String str = word.substring(j,i);
            for(int k=0;k<str.length();k++){
                arr[str.charAt(k)-97]++;
            }
            for(int m=0;m<arr.length;m++){
                if(arr[i]==1){
                    count++;
                }
            }

        }
return 0;
    }
}
