package com.ds.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, in level order traversal
 * we print nodes at every level before moving on
 * to the next level
 * 
 *       1
 *      / \
 *     2   3
 *    / \   \
 *   4   5   16
 *  / \       \
 * 17   28     19
 *       
 */

public class LevelOrderTraversal {

	public void reverseOrder(Node root) {
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			root = queue.poll();
			System.out.print(root.data + "|");
			if (root.left != null) {
				queue.add(root.left);
			}

			if (root.right != null) {
				queue.add(root.right);
			}

		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(16);
		root.left.left.left = new Node(17);
		root.left.left.right = new Node(28);
		root.right.right.right = new Node(19);

		LevelOrderTraversal levelOrder = new LevelOrderTraversal();
		System.out.println("---Level order traversal---");
		levelOrder.reverseOrder(root);

	}

}
