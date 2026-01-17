package com.apenasolinco.leetcodae;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/remove-element/description/">Leet 27: Remove Element</a>
 */
public class RemoveElement27 {
    public static void main(String[] args) {
        RemoveElement27 re27 = new RemoveElement27();
        int[] nums;
        int val;
        int k;

        // Expected result: k = 2, nums = {2,2,_,_}
        nums = new int[]{3, 2, 2, 3};
        val = 3;
        k = re27.removeElement(nums, val);
        printResult(nums, k);

        // Expected result: k = 5, nums = {0,1,4,0,3,_,_,_}
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        k = re27.removeElement(nums, val);
        printResult(nums, k);
    }

    private static void printResult(int[] nums, int k) {
        System.out.printf(
                "nums = [%s] - k = %d\n",
                Arrays.stream(nums)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")),
                k
        );
    }

    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        int i = 0;
        while (i < k) {
            if (nums[i] != val) {
                i++;
                continue;
            }

            // Shift the array to the left
            for (int j = i; j < k - 1; j++) {
                nums[j] = nums[j + 1];
            }
            k--;
        }

        return k;
    }
}
