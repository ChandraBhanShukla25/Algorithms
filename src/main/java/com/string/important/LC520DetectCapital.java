package com.string.important;

public class LC520DetectCapital {
    public static void main(String[] args) {
        String word1 = "Flag";
        String word2 = "leetcode";
        String word3 = "USA";
        LC520DetectCapital detectCapital = new LC520DetectCapital();
        boolean flag1 = detectCapital.detectCapitalUse(word1);
        boolean flag2 = detectCapital.detectCapitalUse(word2);
        boolean flag3= detectCapital.detectCapitalUse(word3);
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
    }

    public boolean detectCapitalUse(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(0))) {
                if (!Character.isLowerCase(word.charAt(i)))
                    return false;
            }
        }
        if (Character.isUpperCase(word.charAt(0))) {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(1))) {
                    if (!Character.isUpperCase(word.charAt(i)))
                        return false;
                } else if (Character.isLowerCase(word.charAt(1))) {
                    if (!Character.isLowerCase(word.charAt(i)))
                        return false;
                }
            }
        }
        return true;
    }
}
