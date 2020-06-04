package _15_树_Tree.BST;

import _15_树_Tree.TreeNode;

import java.util.Stack;

/**
 * Project Name: Leetcode
 * Package Name: _15_树_Tree.BST
 * File Name: BSTIterator
 * Creator: Jipeng Chen
 * Date: 6/4/20
 * Description: None
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode next = stack.pop();
        cur = next.right;
        return next.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
