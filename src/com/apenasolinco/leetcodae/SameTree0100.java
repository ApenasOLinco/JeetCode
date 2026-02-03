package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/same-tree/">Leet 100: Same Tree</a>
 */
public class SameTree0100 {
    public static void main(String[] args) {
        final SameTree0100 st100 = new SameTree0100();

        // Expected result: true
        System.out.println(st100.isSameTree(new TreeNode(), new TreeNode()));

        // Expected result: false
        System.out.println(
                st100.isSameTree(
                        new TreeNode(1),
                        new TreeNode(1, new TreeNode(12), null)
                )
        );

        // Expected result: true
        System.out.println(
                st100.isSameTree(
                        new TreeNode(0, null, new TreeNode(1, null, new TreeNode(2))),
                        new TreeNode(0, null, new TreeNode(1, null, new TreeNode(2)))
                )
        );
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
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
