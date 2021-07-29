package com.study.problems.hard;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBinaryTreeCompleteness {

    public static void main(String[] args) {

        TreeNode node = new TreeNode();

        node.left = new TreeNode();
        node.left.left = new TreeNode();
        node.left.right = new TreeNode();

        node.right = new TreeNode();
        node.right.left = new TreeNode();

        System.out.println(isCompleteTree(node)); // true

        node = new TreeNode();

        node.left = new TreeNode();
        node.left.left = new TreeNode();

        node.right = new TreeNode();
        node.right.left = new TreeNode();
        node.right.right = new TreeNode();

        System.out.println(isCompleteTree(node)); // false
    }

    public static boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while(!queue.isEmpty() && queue.peek() != null) {
            queue.poll();
        }

        return queue.isEmpty();
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
