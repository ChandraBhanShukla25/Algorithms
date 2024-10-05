package com.string.important;

public class Lc1903 {
    public static void main(String[] args) {
      String str = "32782489638346578713315098393010310518347382";
      Lc1903 largestOddNumber = new Lc1903();
      String x = largestOddNumber.largestOddNumber(str);
        System.out.println(x);
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
