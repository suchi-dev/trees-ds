package com.ds.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree and key, insert the key at the first available postion
 * using level order traversal.
 * We need to insert 8.
 *      1              
 *     / \
 *    2   3
 *   / \  / \
 *   4  5 6  7
 *   
 *      1
 *     / \
 *    2   3
 *   / \  / \
 *   4  5 6  7
 *  /
 * 8
 */
public class InsertionBinaryTree {

	static class Node {
		int key;
		Node left, right;

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
			System.out.print(temp.key+"|");
			inorder(temp.right);
		}
	}

	public void insert(Node temp, int data) {
		Node newNode = new Node(data);
		if (temp == null) {
			root = newNode;
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(temp);
		while (!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
			if (temp.left == null) {
				temp.left = newNode;
				break;
			} else {
				queue.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = newNode;
				break;
			} else {
				queue.add(temp.right);
			}

		}

	}
	
	public static void main(String [] args) {
		InsertionBinaryTree ibt = new InsertionBinaryTree();
		InsertionBinaryTree.root = new Node(1);
		InsertionBinaryTree.root.left = new Node(2);
		InsertionBinaryTree.root.right = new Node(3);
		InsertionBinaryTree.root.left.left = new Node(4);
		InsertionBinaryTree.root.left.right= new Node(5);
		InsertionBinaryTree.root.right.left = new Node(6);
		InsertionBinaryTree.root.right.right= new Node(7);
		ibt.inorder(root);
		System.out.println(" ");
		System.out.println("Inserting 8 into this tree");
		ibt.insert(root, 8);
		ibt.inorder(root);
		
		
		
		
		
		
		
	}

}
