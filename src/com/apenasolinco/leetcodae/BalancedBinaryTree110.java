package com.apenasolinco.leetcodae;

public class BalancedBinaryTree110 {
    public static void main(String[] args) {
        final BalancedBinaryTree110 bbt110 = new BalancedBinaryTree110();
        TreeNode tree;

        // Expected result: true
        tree = insertLevelOrder(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println(bbt110.isBalanced(tree));

        // Expected result: false
        tree = insertLevelOrder(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4}, 0);
        System.out.println(bbt110.isBalanced(tree));
    }

    public boolean isBalanced(TreeNode root) {
        final boolean[] result = new boolean[]{true};
        isBalanced(root, result);
        return result[0];
    }

    private int isBalanced(TreeNode root, boolean[] result) {
        if (root == null) return 0;

        int leftHeight = isBalanced(root.left, result);
        if (!result[0]) return 0;
        int rightHeight = isBalanced(root.right, result);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            result[0] = false;
            return 0;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Utility to build Tree from an array in level order
     */
    private static TreeNode insertLevelOrder(Integer[] arr, int i) {
        TreeNode root = null;

        if (i < arr.length) {
            if (arr[i] == null) return null;

            root = new TreeNode(arr[i]);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }

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
