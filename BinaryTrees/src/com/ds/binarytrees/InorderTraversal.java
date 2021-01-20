package com.ds.binarytrees;

import java.util.Stack;

/*
 * Given the root of a binary tree, we do inorder
 * traversal by visting the node's left child, printing the 
 * node and  then visiting it's right child.
 * We do this for every node in the tree.
 * Inorder :- L-V-R
 * 
 * eg :- 1
 *      / \
 *     2   3
 *    / \ / \ 
 *   4  5 6  7
 *  /
 * 8 
 * 
 * Inorder traversal for this tree:- 8,4,2,5,1,6,3,7
 * We do this recursively as well as iteratively using 1 stack
 */

public class InorderTraversal {

	public void iterativeInorderTraversal(Node root) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty())
					break;
				root = stack.pop();
				System.out.print(root.data + "-");
				root = root.right;

			}
		}

	}

	public void recursiveInorderTraversal(Node root) {
		if (root != null) {
			recursiveInorderTraversal(root.left);
			System.out.print(root.data + "|");
			recursiveInorderTraversal(root.right);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		InorderTraversal inorder = new InorderTraversal();
		System.out.println("----Iterative inorder traversal----");
		inorder.iterativeInorderTraversal(root);
		System.out.println(" ");
		System.out.println("----Recursive inorder traversal----");
		inorder.recursiveInorderTraversal(root);

	}

}
