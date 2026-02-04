package com.apenasolinco.leetcodae;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree/">Leet 101: Symmetric Tree</a>
 */
public class SymmetricTree0101 {
    public static void main(String[] args) {
        final SymmetricTree0101 st101 = new SymmetricTree0101();
        boolean result;

        // Expected result: false
        result = st101.isSymmetric(
                new TreeNode(
                        1,
                        new TreeNode(
                                12,
                                new TreeNode(3),
                                null
                        ),
                        new TreeNode(4)
                )
        );
        System.out.println(result);

        // Expected result: true
        result = st101.isSymmetric(
                new TreeNode(1)
        );
        System.out.println(result);

        // Expected result: true
        result = st101.isSymmetric(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(5),
                                new TreeNode(3)
                        ),
                        new TreeNode(
                                2,
                                new TreeNode(3),
                                new TreeNode(5)
                        )
                )
        );
        System.out.println(result);
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(final TreeNode left, final TreeNode right) {
        if (left == null || right == null) return left == right;

        return left.val == right.val
                && dfs(left.left, right.right)
                && dfs(left.right, right.left);
    }

    static public class TreeNode {
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
