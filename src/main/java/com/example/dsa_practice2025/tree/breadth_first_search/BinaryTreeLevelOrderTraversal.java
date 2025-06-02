package com.example.dsa_practice2025.tree.breadth_first_search;

import com.example.dsa_practice2025.tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal
{
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        System.out.println(List.of(binaryTreeLevelOrderTraversal(node)));
    }

    public static List<List<Long>> binaryTreeLevelOrderTraversal(TreeNode root) {
        /**
         *  algorithm:
         *  1)declare result list
         *  2)declare queue of treenode
         *  3)add root-node into queue
         *  4)iterate till queue is not empty
         *      1]take size of queue
         *      2]declare list level
         *      3]iterate from 0 to size
         *           I.poll node from queue
         *          II.add node into level list
         *         III.check left child is not null
         *              add node into queue
         *          IV.check right child is not null
         *              add node into queue
         *      4]end loop
         *  5)add level list into result
         *  6)end loop
         *  7)return result
         *
         *  TC - O(N)
         *  BECAUSE EACH NODE IS GETTING TRAVERSE EXACTLY ONCE EVEN IT HAS 2 LOOPS
         */
        if(root == null)
            return new ArrayList<>();
        List<List<Long>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Long> levels = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levels.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(levels);
        }
        return result;
    }
}
