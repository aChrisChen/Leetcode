package _15_树_Tree.BST;

import _15_树_Tree.TreeNode;

import java.util.Stack;

/**
 * Project Name: Leetcode
 * Package Name: _15_树_Tree.BST
 * File Name: BSTIteratorSoln2
 * Creator: Jipeng Chen
 * Date: 6/4/20
 * Description: TODO
 */
public class BSTIteratorSoln2 {
    public class BSTIterator {
        private Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode tmpNode = stack.pop();
            pushAll(tmpNode.right);
            return tmpNode.val;
        }

        private void pushAll(TreeNode node) {
            for (; node != null; stack.push(node), node = node.left);
        }
    }
}
