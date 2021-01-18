package com.ds.binarytrees;

import java.util.Stack;

/* 
 * Given the root of a binary tree, we do preorder
 * traversal by printing the node, then visting it's left
 * and right child. We do this for every node in the tree.
 * Preorder :- V-L-R
 * 
 * eg :- 1
 *      / \
 *     2   3
 *    / \ / \ 
 *   4  5 6  7
 *  /
 * 8 
 * 
 * Preorder traversal for this tree:- 1,2,4,8,5,3,6,7
 * We do this recursively as well as iteratively using 1 stack
 */
public class PreOrderTraversal {

	public void iterativePreOrderTraversal(Node root) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.data + "-");
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}

		}

	}
	
	public void recursivePreOrderTraversal(Node root) {
		if(root != null) {
			System.out.print(root.data + "|");
			recursivePreOrderTraversal(root.left);
			recursivePreOrderTraversal(root.right);
		}
		
		
	}
	
	public static void main(String [] args) {
		PreOrderTraversal preTraversal = new PreOrderTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right= new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		System.out.println("----Pre order traversal using 1 stack----");
		preTraversal.iterativePreOrderTraversal(root);
		System.out.println(" ");
		System.out.println("----Pre order traversal using recursion----");
		preTraversal.recursivePreOrderTraversal(root);
		
		
	}

}
