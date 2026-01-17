package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/search-insert-position/">Leet 35: Search Insert Position</a>
 */
public class SearchInsertPosition35 {
    public static void main(String[] args) {
        SearchInsertPosition35 s35 = new SearchInsertPosition35();

        int[] nums;
        int target;

        // Expected result: 1
        nums = new int[]{1, 3, 5, 6};
        target = 2;
        System.out.println(s35.searchInsert(nums, target));

        // Expected result: 2
        nums = new int[]{1, 3, 5, 6};
        target = 5;
        System.out.println(s35.searchInsert(nums, target));

        // Expected result: 4
        nums = new int[]{1, 3, 5, 6};
        target = 7;
        System.out.println(s35.searchInsert(nums, target));

        // Expected result: 1
        nums = new int[]{1, 3};
        target = 2;
        System.out.println(s35.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) return nums.length;

        int start = 0, end = nums.length, middle = (start + end) / 2;

        while (start <= end) {
            middle = (start + end) / 2;

            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else return middle;
        }

        // {1, 3, 5, 6} t=2
        if (nums[middle] < target) return middle + 1;
        return middle;
    }
}
