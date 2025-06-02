package com.example.dsa_practice2025.tree.depth_first_search;

import com.example.dsa_practice2025.tree.TreeNode;

public class BinaryTreePreorderTraversal
{

    static int idx = -1;
    public static void main(String[] args) {
        int preorder[] = {1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        TreeNode root = buildTree(preorder);
        int x = 2;
    }


    public static TreeNode buildTree(int[] preorder) {
        idx++;
        if(preorder[idx] == -1)
            return null;
        else {
            TreeNode root = new TreeNode(preorder[idx]);
            root.left = buildTree(preorder);
            root.right = buildTree(preorder);
            return root;
        }
    }

}
