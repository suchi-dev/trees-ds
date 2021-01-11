package com.ds.binarytrees;

/*
 * Given a binary tree, we find the height which is number of levels
 * in the binary tree. We use recursion and calculate the height of left
 * sub tree and then height of right sub tree
 *       1
 *      / \
 *     2   3
 *    / \ / \
 *   4  5 6  7
 *  /
 *  8
 *   
 * left Height = 4
 * right Height = 3
 * Height of BT = Max(left, right) = Max(4, 3) = 4
 * 
 */
public class HeightBT {

	static class Node {
		int key;
		Node right, left;

		Node(int data) {
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

	public int height(Node temp) {
		if (temp == null) {
			return 0;
		}
		int leftHeight = height(temp.left);
		int rightHeight = height(temp.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String [] args) {
		HeightBT hbt = new HeightBT();
		HeightBT.root = new Node(1);
		HeightBT.root.left = new Node(2);
		HeightBT.root.right = new Node(3);
		HeightBT.root.left.left = new Node(4);
		HeightBT.root.left.right = new Node(5);
		HeightBT.root.right.left = new Node(6);
		HeightBT.root.right.right = new Node(7);
		HeightBT.root.left.left.left = new Node(8);

		hbt.inorder(root);
		System.out.println(" ");
		System.out.println("The height of binary tree is : " + hbt.height(root));

	}

}

