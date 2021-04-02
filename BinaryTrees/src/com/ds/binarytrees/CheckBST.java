package com.ds.binarytrees;


/*
 * Given a binary tree, we need to check if is a BST
 * A BST is a special binary tree where left child is less
 * than or equal to it's parent node and right child is
 * greater than it's parent
 * 
 * 
 *   45
 *   /  \
 *  20   60
 *  /\   / \
 * 15 30 50 68    
 * 
 * This  BT is a BST
 * 
 *    30
 *   /  \
 *  20   40
 *  /\   / \
 * 5  35 25 45
 * 
 * This BT is not a BST
 */
public class CheckBST {
	
	
	public boolean isBST(Node root, int min, int max) {
		if(root == null) return true;
		
		if(root.data <= min || root.data  > max) {
			return false;
		}
		
		return isBST(root.left, min, root.data)
			&& isBST(root.right, root.data, max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(45);
		root.left = new Node(20);
		root.right = new Node(60);
		root.left.left = new Node(15);
		root.left.right = new Node(30);
		root.right.left = new Node(50);
		root.right.right = new Node(68);
		CheckBST checkBST = new CheckBST();
		boolean isBST = checkBST.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("-------------------");
		System.out.println("The given BT is a BST ? "+isBST);
		
		Node root1 = new Node(30);
		root1.left = new Node(20);
		root1.right = new Node(40);
		root1.left.left = new Node(5);
		root1.left.right = new Node(35);
		root1.right.left = new Node(25);
		root1.right.right = new Node(45);
		isBST = checkBST.isBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("-------------------");
		System.out.println("The given BT is a BST ? "+isBST);
		
		
		
	}

}
