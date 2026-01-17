package com.apenasolinco.leetcodae;

import java.util.Arrays;

/**
 * 
 */
public class RemoveDuplicatesFromSortedArray26 {
    public static void main(String[] args) {
        final RemoveDuplicatesFromSortedArray26 rdfst26 = new RemoveDuplicatesFromSortedArray26();

        // Case 1
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 6, 7, 10, 10, 10};
        int k = rdfst26.removeDuplicates(nums);
        showResult(nums, k);

        // Case 2
        nums = new int[]{1, 1, 2};
        k = rdfst26.removeDuplicates(nums);
        showResult(nums, k);

        // Case 3
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        k = rdfst26.removeDuplicates(nums);
        showResult(nums, k);
    }

    private static void showResult(int[] nums, int k) {
        Arrays.stream(Arrays.copyOfRange(nums, 0, k))
                .forEach(n -> System.out.printf("%d ", n));
        System.out.println();
    }

    public int removeDuplicates(int[] nums) {
        int i = 0, unique = 0, repeated = 0;

        while (i < nums.length - repeated) {
            unique++;
            int currentDuplicates = 0;

            // Find the duplicates of the current element (if any)
            for (int j = i + 1; (j < nums.length - repeated) && (nums[j] == nums[i]); j++)
                currentDuplicates++;

            // Shift the array to the left by the number of found duplicates, overriding the repeated numbers
            for (int l = i + 1; currentDuplicates > 0 && l < nums.length - repeated; l++) {
                // The regular shift is complete, populate the end of the array with the repeated elements
                if (l + currentDuplicates >= nums.length) {
                    nums[l] = nums[i];
                    continue;
                }

                nums[l] = nums[l + currentDuplicates];
            }

            repeated += currentDuplicates;
            i++;
        }

        return unique;
    }
}
