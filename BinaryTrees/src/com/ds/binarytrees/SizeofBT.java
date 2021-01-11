package com.ds.binarytrees;


/*
 * Given a binary tree, we find the size which is number of nodes
 * in the binary tree. We use recursion and calculate the size of left
 * sub tree and then size of right sub tree
 *       1
 *      / \
 *     2   3
 *    / \ / \
 *   4  5 6  7
 * 
 * left size = 3
 * right size = 3
 * left size + right size + root node = 7 
 * 
 * 
 */
public class SizeofBT {

	static class Node{
		int key;
		Node right, left;
		
		Node(int data){
			key = data;
			left = right = null;
		}
	}
	
	static Node root;
	Node temp = root;
	
	public void inorder(Node temp) {
		if (temp != null) {
			inorder(temp.left);
			System.out.print(temp.key + "|");
			inorder(temp.right);
			
		}
	}
	
	public int size(Node temp) {
		if(temp == null) {
			return 0;
		}
		int leftSize = size(temp.left);
		int rightSize = size(temp.right);
		return leftSize + rightSize + 1;
	}
	
	
	public static void main(String [] args) {
		SizeofBT sbt = new SizeofBT();
		SizeofBT.root = new Node(1);
		SizeofBT.root.left = new Node(2);
		SizeofBT.root.right = new Node(3);
		SizeofBT.root.left.left = new Node(4);
		SizeofBT.root.left.right = new Node(5);
		SizeofBT.root.right.left = new Node(6);
		SizeofBT.root.right.right = new Node(7);
		
		sbt.inorder(root);
		System.out.println(" ");
		System.out.println("The size of binary tree is : "+ sbt.size(root));		
		
		
		
		
		
		
	}
	
}
