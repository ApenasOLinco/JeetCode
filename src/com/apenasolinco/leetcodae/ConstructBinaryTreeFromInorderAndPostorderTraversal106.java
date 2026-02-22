package com.apenasolinco.leetcodae;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/">
 * Leet 106: Construct Binary Tree from Inorder and Postorder Traversal
 * </a>
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal106 cbt106 = new ConstructBinaryTreeFromInorderAndPostorderTraversal106();
        int[] inorder, postorder;
        TreeNode result;

        // Expected result: [3,9,20,null,null,15,7]
        inorder = new int[]{9, 3, 15, 20, 7};
        postorder = new int[]{9, 15, 7, 20, 3};
        result = cbt106.buildTree(inorder, postorder);
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


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;

        final TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        // Left subtree
        final int[] leftInorder = Arrays.stream(inorder)
                .takeWhile(el -> el != root.val)
                .toArray();
        final int[] leftPostorder = Arrays.copyOf(postorder, leftInorder.length);

        // Right subtree
        final int[] rightInorder = Arrays.copyOfRange(inorder, leftInorder.length + 1, inorder.length);
        final int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, inorder.length - 1);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

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
