package com.apenasolinco.leetcodae;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">Leet 88: Merge Sorted Array</a>
 */
public class MergeSortedArray0088 {
    public static void main(String[] args) {
        int[] nums1, nums2;
        int m, n;
        final MergeSortedArray0088 ms88 = new MergeSortedArray0088();

        // Expected result: nums1 = [ 1, 2, 2, 3, 5, 6 ]
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        m = 3;
        nums2 = new int[]{2, 5, 6};
        n = 3;
        ms88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        // Expected result: nums1 = [ 1, 2, 2, 3, 5, 6 ]
        nums1 = new int[]{2, 2, 3, 0, 0, 0};
        m = 3;
        nums2 = new int[]{1, 5, 6};
        n = 3;
        ms88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        // Expected result: nums1 = [ 1 ]
        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        ms88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        // Expected result: nums1 = [ 1 ]
        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        ms88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIndex = m + n - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n])
                nums1[currentIndex--] = nums1[m--];
            else
                nums1[currentIndex--] = nums2[n--];
        }

        // Leftover elements
        while (n >= 0) {
            nums1[currentIndex--] = nums2[n--];
        }
    }
}
