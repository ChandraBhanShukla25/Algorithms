package com.string.important;

public class LC1662 {

    public static void main(String[] args) {
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        LC1662 lc1662 = new LC1662();
        boolean isEqual = lc1662.arrayStringsAreEqual(word1, word2);
        System.out.println(isEqual);
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int m = 0;
        int n = 0;
        int i = 0;
        int j = 0;
        if (word1 == null || word2 == null) {
            return false;
        }

        while (m < word1.length && n < word2.length) {
            if (word1[m].charAt(i) != word2[n].charAt(j)) {
                return false;
            }
            i++;
            j++;
            if (i == word1[m].length()) {
                m++;
                i = 0;
            }
            if (j == word2[n].length()) {
                n++;
                j = 0;
            }
        }
        if (m < word1.length && i < word1[m].length()) {
            return false;
        }
        if (n < word2.length && j < word2[n].length()) {
            return false;
        }
        return true;

    }
}
