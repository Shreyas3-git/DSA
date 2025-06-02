package com.example.dsa_practice2025.tree.breadth_first_search;

import com.example.dsa_practice2025.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SearchElementInBinaryTree
{
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        System.out.println(binaryTreeSearching(node,5));
    }

    public static boolean binaryTreeSearching(TreeNode root, int k) {
        if(root == null)
            return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.val == k)
                return true;
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return false;
    }
}
