package com.slidingwindow;

public class MinMoves {

    public static int minMoves(String buckets) {
        int n = buckets.length();
        int ballCount = 0;
        for (char c : buckets.toCharArray()) {
            if (c == 'B') {
                ballCount++;
            }
        }

        if (ballCount == 0 || ballCount == n) {
            return 0;
        }

        if (ballCount == 1 || ballCount == n - 1) {
            return -1;
        }

        int minMoves = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int moves = 0;
            if (buckets.charAt(i) == 'B') {
                moves += Math.min(i, n - 3 - i);
                i += 2; // Skip the next two buckets
                while (i < n && buckets.charAt(i) != 'B') {
                    i++;
                    moves++;
                }
                if (i < n && buckets.charAt(i) == 'B') {
                    return -1;
                }
                minMoves = Math.min(minMoves, moves);
            }
        }

        return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
    }

    public static void main(String[] args) {
        String buckets = "..B....B.BB";
        System.out.println(minMoves(buckets));  // Output: 1
    }
}
