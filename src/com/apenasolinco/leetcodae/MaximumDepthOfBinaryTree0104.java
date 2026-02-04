package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Leet 104: Maximum Depth Of Binary Tree</a>
 */
public class MaximumDepthOfBinaryTree0104 {
    public static void main(String[] args) {
        final MaximumDepthOfBinaryTree0104 mx104 = new MaximumDepthOfBinaryTree0104();
        TreeNode root;

        // Expected result: 0
        System.out.println(mx104.maxDepth(null));

        // Expected result: 2
        root = new TreeNode(
                1,
                new TreeNode(3),
                new TreeNode(0)
        );
        System.out.println(mx104.maxDepth(root));

        // Expected result: 4
        root = new TreeNode(
                1,
                new TreeNode(
                        3,
                        new TreeNode(
                                5,
                                new TreeNode(8),
                                null
                        ),
                        null
                ),
                new TreeNode(0)
        );
        System.out.println(mx104.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(
                1 + maxDepth(root.left),
                1 + maxDepth(root.right)
        );
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
