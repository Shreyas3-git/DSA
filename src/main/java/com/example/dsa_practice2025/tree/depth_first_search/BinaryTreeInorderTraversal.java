package com.example.dsa_practice2025.tree.depth_first_search;

import com.example.dsa_practice2025.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeInorderTraversal
{
    static int index = -1;
    public static void main(String[] args) {
        List<Long> inorder = new ArrayList<>();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        inorder(node,inorder);
        System.out.println(inorder);

        int in[] = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
    }



    public static void inorder(TreeNode root, List<Long> in) {
        if(root == null) {
            return;
        } else {
            inorder(root.left,in);
            in.add((long) root.val);
            inorder(root.right,in);
        }
    }


}
