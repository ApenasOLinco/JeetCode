package com.apenasolinco.leetcodae;

import java.util.*;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/description/">Leet 94: Binary Tree Inorder Traversal</a>
 */
public class BinaryTreeInorderTraversal0094 {
    public static void main(String[] args) {
        final BinaryTreeInorderTraversal0094 b94 = new BinaryTreeInorderTraversal0094();
        List<Integer> result;
        TreeNode root;

        // Expected result: [1]
        root = new TreeNode(1);
        result = b94.inorderTraversalIterative(root);
        System.out.println("Iterative: " + result.toString());
        result = b94.inorderTraversalRecursive(root);
        System.out.println("Recursive: " + result.toString());

        System.out.println("-----------");

        // Expected result: []
        root = null;
        result = b94.inorderTraversalIterative(root);
        System.out.println("Iterative: " + result.toString());
        result = b94.inorderTraversalRecursive(root);
        System.out.println("Recursive: " + result.toString());

        System.out.println("-----------");

        // Expected result: [1, 2, 3, 4]
        root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), null);
        result = b94.inorderTraversalIterative(root);
        System.out.println("Iterative: " + result.toString());
        result = b94.inorderTraversalRecursive(root);
        System.out.println("Recursive: " + result.toString());
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) return Collections.emptyList();

        ArrayList<Integer> result = new ArrayList<>(inorderTraversalIterative(root.left));
        result.add(root.val);
        result.addAll(inorderTraversalIterative(root.right));

        return result;
    }

    /**
     * Iterative solution
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        final List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        // The operations we've already done (Left, Visit, Right)
        final Map<TreeNode, Boolean[]> operations = new HashMap<>();
        // The stack that holds the order of the nodes we are visiting
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        operations.put(root, new Boolean[]{false, false, false});

        while (!stack.empty()) {
            final TreeNode current = stack.peek();
            final Boolean[] operationsStatus = operations.get(current);

            // Left
            if (!operationsStatus[0]) {
                // Update the current node's status
                operationsStatus[0] = true;

                if (current.left != null) {
                    // Initialize the new node
                    final TreeNode left = current.left;
                    stack.push(left);
                    operations.put(left, new Boolean[]{false, false, false});
                    continue;
                }
            }

            // Visit
            if (!operationsStatus[1]) {
                result.add(current.val);
                operationsStatus[1] = true;
            }

            // Right
            if (!operationsStatus[2]) {
                operationsStatus[2] = true;

                if (current.right != null) {
                    final TreeNode right = current.right;
                    stack.push(right);
                    operations.put(right, new Boolean[]{false, false, false});
                    continue;
                }
            }

            // We're done with the current node
            stack.pop();
        }

        return result;
    }

    /**
     * Definition for a binary tree node
     */
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
