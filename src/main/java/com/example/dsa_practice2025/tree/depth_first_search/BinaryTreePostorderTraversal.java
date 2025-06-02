package com.example.dsa_practice2025.tree.depth_first_search;

import com.example.dsa_practice2025.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal
{
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        List<Long> post = new ArrayList<>();
        postorder(node,post);
        System.out.println(post);
    }

    public static void postorder(TreeNode root, List<Long> in) {
        if(root == null) {
            return;
        } else {
            postorder(root.left,in);
            postorder(root.right,in);
            in.add((long) root.val);
        }
    }


}
