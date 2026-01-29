package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">Leet 69: Sqrt(x)</a>
 */
public class SrqtX0069 {
    public static void main(String[] args) {
        final SrqtX0069 sr = new SrqtX0069();

        // Expected result: 2
        System.out.println(sr.mySqrt(4));

        // Expected result: 3
        System.out.println(sr.mySqrt(9));

        // Expected result: 9
        System.out.println(sr.mySqrt(81));

        // Expected result: 2
        System.out.println(sr.mySqrt(8));

        // Expected result: 1
        System.out.println(sr.mySqrt(1));

        // Expected result: 46339
        System.out.println(sr.mySqrt(2_147_395_599));

        // Expected result: 46340
        System.out.println(sr.mySqrt(2_147_483_647));
    }

    public int mySqrt(int x) {
        int l = 0, r = x / 2;

        while (l <= r) {
            int middle = (l + r) / 2;
            long pow = (long) middle * middle;

            if (pow > x) {
                r = middle - 1;
                continue;
            }

            if (pow < x) {
                l = middle + 1;
                continue;
            }

            return middle;
        }

        long pow = (long) l * l;
        return pow > x ? l - 1 : l;
    }
}
