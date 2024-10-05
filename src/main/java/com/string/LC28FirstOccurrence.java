package com.string;

public class LC28FirstOccurrence {

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";
        LC28FirstOccurrence firstOccurrence = new LC28FirstOccurrence();
        int i = firstOccurrence.strStr(haystack, needle);
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
      int index = 0;
      int innerIndex= 0;
      while(index<haystack.length()){
          if(haystack.charAt(index)==needle.charAt(0)){
              int currentIndex= index;
              for(innerIndex=0;innerIndex<needle.length() && currentIndex<haystack.length();innerIndex++){
                  if(haystack.charAt(currentIndex)==needle.charAt(innerIndex)){
                      currentIndex++;
                      if(innerIndex==needle.length()-1){
                          return currentIndex-needle.length();
                      }
                  }else{
                      break;
                  }
              }
          }
          index++;
      }
      return -1;
    }
}
