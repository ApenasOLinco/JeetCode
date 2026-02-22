package com.apenasolinco.leetcodae;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedArrayToBinarySearchTree108 {
    public static void main(String[] args) {
        final ConvertSortedArrayToBinarySearchTree108 csa108 = new ConvertSortedArrayToBinarySearchTree108();
        int[] nums;

        // Expected result: [0,-3,9,-10,null,5] OR [0,-10,5,null,-3,null,9]
        nums = new int[]{-10, -3, 0, 5, 9};
        printResult(csa108.sortedArrayToBST(nums));
    }

    private static void printResult(final TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            System.out.println("null");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();

            if (tempNode == null) {
                result.add(null);
                continue;
            }

            result.add(tempNode.val);
            queue.add(tempNode.left);
            queue.add(tempNode.right);
        }

        // Remove "null" suffixes
        int removeLength = 0;
        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i) != null) break;
            removeLength++;
        }

        result = new ArrayList<>(result.subList(0, result.size() - removeLength));
        System.out.println(result);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildSubtree(0, nums.length - 1, nums);
    }

    private TreeNode buildSubtree(int l, int r, int[] nums) {
        if (l > r) return null;

        int middle = (l + r) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildSubtree(l, middle - 1, nums);
        root.right = buildSubtree(middle + 1, r, nums);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
