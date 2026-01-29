package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">Leet 70: Climbing Stairs</a>
 */
public class ClimbingStairs70 {
    public static void main(String[] args) {
        final ClimbingStairs70 c70 = new ClimbingStairs70();

        // Expected result: 2
        System.out.println(c70.climbStairs(2));

        // Expected result: 3
        System.out.println(c70.climbStairs(3));

        // Expected result: 8
        System.out.println(c70.climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;

        int first = 1, second = 1, current = n - 2, result = 0;

        while (current >= 0) {
            int sum = first + second;
            second = first;
            first = sum;
            result = sum;
            current--;
        }

        return result;
    }
}
