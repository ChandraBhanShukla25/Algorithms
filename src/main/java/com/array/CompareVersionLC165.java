package com.array;

public class CompareVersionLC165 {


    public static void main(String[] args) {
        CompareVersionLC165 compareVersionLC165 = new CompareVersionLC165();
        String version1 = "1"; String version2 = "0";
        int val = compareVersionLC165.compareVersion(version1,version2);
        System.out.println(val);
    }
    public int compareVersion(String version1, String version2) {

        int i=0;
        int j=0;
        int num1 =0; int num2 = 0;
        while(i<version1.length() && j<version2.length()){
            if(version1.charAt(i)!='.'){
                num1 = num1*10 +  Character.getNumericValue(version1.charAt(i));;
                i++;
            }

            if(version2.charAt(j)!='.'){
                num2= num2*10 +  Character.getNumericValue(version2.charAt(j));;
                j++;
            }

            if(i<version1.length() && j<version2.length() && version1.charAt(i)=='.' && version2.charAt(j)=='.'){
                if(num1>num2){
                    return 1;
                }
                else if(num2>num1){
                    return -1;
                } else{
                    num1=0;
                    num2=0;
                    i=i+1;
                    j=j+1;
                }
            }
        }

        if(i<version1.length()) {
            while (i < version1.length()) {
                if (version1.charAt(i) == '.') {
                    if(num1>num2){
                        return 1;
                    }
                    if(num2>num1){
                        return -1;
                    }
                    num1 = 0;
                    num2 = 0;
                } else {
                    num1 = num1 * 10 + Character.getNumericValue(version1.charAt(i));
                    if (num1 > num2) {
                        return 1;
                    }
                }
                i++;
            }
        }

        if(j<version2.length()) {
            while (j < version2.length()) {
                if (version2.charAt(j) == '.') {
                    if(num1>num2){
                        return 1;
                    }
                    if(num2>num1){
                        return -1;
                    }
                    num2 = 0;
                    num1=0;
                } else {
                    num2 = num2 * 10 + Character.getNumericValue(version2.charAt(j));
                    if (num2 > num1) {
                        return -1;
                    }
                }
                j++;
            }
        }
        if(num1>num2){
            return 1;
        }
        if(num2>num1){
            return -1;
        }

        return 0;
    }
}
