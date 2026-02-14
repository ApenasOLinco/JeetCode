package com.apenasolinco.leetcodae;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">Leet 105: Construct Binary Tree from Preorder and Inorder Traversal</a>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal0105 {
    public static void main(String[] args) {
        final ConstructBinaryTreeFromPreorderAndInorderTraversal0105 cbt105 = new ConstructBinaryTreeFromPreorderAndInorderTraversal0105();
        int[] inorder, preorder;
        TreeNode result;

        // Expected result: [3,9,20,null,null,15,7]
        preorder = new int[]{3, 9, 20, 15, 7};
        inorder = new int[]{9, 3, 15, 20, 7};
        result = cbt105.buildTree(preorder, inorder);
        printResult(result);

        // Expected result: [-1]
        preorder = new int[]{-1};
        inorder = new int[]{-1};
        result = cbt105.buildTree(preorder, inorder);
        printResult(result);
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int rootValue = preorder[0];
        final TreeNode rootNode = new TreeNode(rootValue);

        // Parse the left tree
        int[] leftInorder = Arrays.stream(inorder).takeWhile(el -> el != rootValue).toArray();
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length);

        // Parse the right tree
        int[] rightInorder = Arrays.copyOfRange(inorder, leftInorder.length + 1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftPreorder.length + 1, preorder.length);

        rootNode.left = buildTree(leftPreorder, leftInorder);
        rootNode.right = buildTree(rightPreorder, rightInorder);

        return rootNode;
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
