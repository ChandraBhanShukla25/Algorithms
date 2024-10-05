package com.slidingwindow;

public class LC424CharacterReplacement {

    public static void main(String[] args) {
       String s = "ABAB";
       int k = 2;
       LC424CharacterReplacement characterReplacement = new LC424CharacterReplacement();
       int length = characterReplacement.characterReplacement(s,k);
       int length1 = characterReplacement.characterReplacementOptomized(s,k);
       System.out.println(length);
        System.out.println(length1);
    }

    public int characterReplacement(String s, int k) {
      int maxLength = 0;
      int n = s.length();
      for(int i=0; i<n;i++){
          int[] hash = new int[26];
          int maxFrequency = 0;
          for(int j=i;j<n;j++){
              int idx = s.charAt(j)-'A';
              hash[idx]++;
              maxFrequency = Integer.max(maxFrequency, hash[s.charAt(i)-'A']);
              int changes = (j-i+1)-maxFrequency;
              if(changes<=k){
                  maxLength = Integer.max(maxLength,j-i+1);
              }else{
                  break;
              }
          }
      }
      return maxLength;
    }

    public int characterReplacementOptomized(String s, int k) {
        int maxLength = 0;
        int n = s.length();
        int j=0;
        int maxFrequency = 0;
        int[] hash = new int[26];
        for(int i=0; i<n;i++){
            hash[s.charAt(i)-'A']++;
            maxFrequency = Math.max(maxFrequency, hash[s.charAt(i)-'A']);
            while ( k < i - j + 1-maxFrequency) {
                hash[s.charAt(j) - 'A']--;
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);

        }
        return maxLength;
    }
}
