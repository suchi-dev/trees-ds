package com.ds.binarytrees;

import java.util.Stack;

/* 
 * Given the root of a binary tree, we do postorder
 * traversal by visting the node's left child, then it's
 * right child.  We then print the node.
 * We do this for every node in the tree.
 * Postorder :- L-R-V
 * 
 * eg :- 1
 *      / \
 *     2   3
 *    / \ / \ 
 *   4  5 6  7
 *  /
 * 8 
 * 
 * Postorder traversal for this tree:- 8,4,5,2,6,7,3,1
 * We do this recursively as well as iteratively using 2 stacks
 */
public class PostOrderTraversal {
	
	public void iterativePostOrderTraversal(Node root) {
		if(root == null) return;
		
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		stack1.push(root);
		
		while( !stack1.isEmpty()) {
			root = stack1.pop();
			 stack2.push(root);
			 if(root.left !=null) {
				 stack1.push(root.left);
			 }
			 if(root.right !=null) {
				 stack1.push(root.right);
			 }
			
			
		}
		
		while(! stack2.isEmpty()) {
			root = stack2.pop();
			System.out.print(root.data + "-");
		}
		
	}
	
	public void recursivePostorderTraversal(Node root) {
		if(root !=null) {
			recursivePostorderTraversal(root.left);
			recursivePostorderTraversal(root.right);
			System.out.print(root.data+"|");
		}
	}

	public static void main(String [] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		PostOrderTraversal postTraversal = new PostOrderTraversal();
		System.out.println("----Postorder traversal using iterative 2 stacks----");
		postTraversal.iterativePostOrderTraversal(root);
		System.out.println(" ");
		System.out.println("----Postorder traversal using recursion----");
		postTraversal.recursivePostorderTraversal(root);
		
		
		
		
		
	}
	
}
