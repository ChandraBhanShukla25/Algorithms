package com.array;

public class LC1700NumberUnableEatLunch {


    public static void main(String[] args) {
       int[] students = {1,1,0,0};
       int[] sandwiches = {0,1,0,1};
       LC1700NumberUnableEatLunch eatLunch = new LC1700NumberUnableEatLunch();
      int x = eatLunch.countStudents(students, sandwiches);
    }

    public int countStudents(int[] students, int[] sandwiches) {

        int[] count = new int[2];

        for (final int student : students)
            ++count[student];

        for (int i = 0; i < sandwiches.length; ++i) {
            if (count[sandwiches[i]] == 0)
                return sandwiches.length - i;
            --count[sandwiches[i]];
        }

        return 0;

    }
}
