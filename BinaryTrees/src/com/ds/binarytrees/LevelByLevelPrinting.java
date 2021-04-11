package com.ds.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree, we need to print the nodes
 * level by level
 * 
 * eg Consider this tree
 * 
 *    35
 *    / \
 *   20  45
 *   / \   \
 *  15  22   47
 *  /\       / \
 * 12 18    46  49 
 *
 *The ouput should be
 *  35
 *  20 45
 *  15 22 47
 *  12 18 46 49
 *
 */
public class LevelByLevelPrinting {

	/*Using 2 queues. We add root node to q1. The breaking condition is both 
	 * queues being empty. We remove top of q1, print it. Check if the removed
	 * element's left and right child exists. If they exists, it is added to q2.
	 * We continue this till q1 is empty
	 * When q1 is empty we print a new line and move on to q2.
	 * We remove the top element from q2. Print it and check if it has left and right 
	 * child. If they exists it is added to q1. We continue till until q2 is empty
	 * When q2 is empty, we print a new line and move on to q1.
	 * When both q1 and q2 are empty, we break out of the outer while loop
	
	
	*/

	public void levelByLevelQueues(Node root) {
		if (root == null) {
			return;

		}

		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();

		q1.add(root);

		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				root = q1.poll();
				System.out.print(root.data + "|");
				if (root.left != null) {
					q2.add(root.left);

				}
				if (root.right != null) {
					q2.add(root.right);
				}

			}
			System.out.println();

			while (!q2.isEmpty()) {
				root = q2.poll();
				System.out.print(root.data + "|");
				if (root.left != null) {
					q1.add(root.left);
				}

				if (root.right != null) {
					q1.add(root.right);
				}
			}
			System.out.println();
		}

	}

	
	/*
	 * We add root and null into the queue.
	 * We remove the top element from the queue. When null is encountered, we add null
	 * to the queue and print a new line.
	 * For non null values, we print the data and check for node's left and right child. 
	 * If they exists, then it is added to the queue.
	 * We break out of the while loop when null is the only value present in the queue.
	 */
	public void levelByLevelDelimiter(Node root) {
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (queue.size() != 1 || queue.peek() != null) {
			root = queue.poll();
			if (root == null) {
				queue.add(null);
				System.out.println();
			} else {
				System.out.print(root.data + "---");
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}

			}

		}

	}

	
	/*
	 * We add root to the queue and initialize our counters.
	 * levelCount is set to 1, currentCount set to 0.
	 * When we remove an element from the queue, print the element's data,
	 * the levelCount is decremented.The element which is removed from the queue's
	 * left and right child is added to the queue if they exists and accordingly 
	 * currentCount is incremented.
	 * When levelCount is 0, it is initialized again with currentCount.
	 * currentCount is reset to 0. We also print a new line
	 * LevelCount holds the number of nodes at the current level
	 * CurrentCount holds the number of nodes at the next level.
	 * 
	 */
	public void levelByLevelWithCounters(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int levelCount = 1;
		int currentCount = 0;
		Node current = root;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current.data + "***");
			levelCount -= 1;

			if (current.left != null) {
				queue.add(current.left);
				currentCount += 1;

			}

			if (current.right != null) {
				queue.add(current.right);
				currentCount += 1;
			}
			if (levelCount == 0) {
				levelCount = currentCount;
				currentCount = 0;
				System.out.println();

			}

		}

	}

	public static void main(String[] args) {
		Node root = new Node(30);
		root.left = new Node(20);
		root.right = new Node(45);

		root.left.left = new Node(15);
		root.left.right = new Node(22);
		root.right.right = new Node(47);
		root.left.left.left = new Node(12);
		root.left.left.right = new Node(18);
		root.right.right.left = new Node(46);
		root.right.right.right = new Node(49);

		LevelByLevelPrinting levelByLevelPrinting = new LevelByLevelPrinting();
		System.out.println("Level by level printing using 2 queues");
		levelByLevelPrinting.levelByLevelQueues(root);
		System.out.println("Level by level printing using null as  a delimiter");
		levelByLevelPrinting.levelByLevelDelimiter(root);
		System.out.println();
		System.out.println("Level by level printing using Counters");
		levelByLevelPrinting.levelByLevelWithCounters(root);

	}
}
