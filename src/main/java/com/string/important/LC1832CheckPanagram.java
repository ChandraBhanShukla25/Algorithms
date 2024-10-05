package com.string.important;

public class LC1832CheckPanagram {

    public static void main(String[] args) {
        String sentence = "leetcode";
        LC1832CheckPanagram checkPanagram = new LC1832CheckPanagram();
        boolean check = checkPanagram.checkIfPangram(sentence);
        System.out.println(check);
    }

    public boolean checkIfPangram(String sentence) {

        if(sentence.isEmpty()){
            return false;
        }
        int arr[] = new int[26];

        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            arr[ch-'a']=1;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=1){
                return false;
            }
        }
        return true;
    }
}
