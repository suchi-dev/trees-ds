package com.ds.binarytrees;

/*
 * Given roots of 2 binary trees, we need to check if they are same
 * Two binary trees are same if their left and right sub trees are same
 * 
 *      Fig a                 Fig b
 *        10                    10
 *        / \                   / \
 *       15  8                 15  8
 *      / \                    / \
 *     18  20                 18  20
 * 
 *  In this case a and b are same
 * 
 *      Fig c                  Fig d
 *      5                        5
 *     / \                      / \ 
 *    7   8                    7   8
 *    \
 *    10
 *
 *   In this case c and d are not same
 */

public class SameBT {

	public boolean sameTree(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.data == root2.data && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "|");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {

		SameBT sbt = new SameBT();
		// Creation of BT1
		Node root1 = new Node(10);
		root1.left = new Node(15);
		root1.right = new Node(8);
		root1.left.left = new Node(18);
		root1.left.right = new Node(20);

		Node root2 = new Node(10);
		root2.left = new Node(15);
		root2.right = new Node(8);
		root2.left.left = new Node(18);
		root2.left.right = new Node(20);
		sbt.inorder(root1);
		System.out.println(" ");
		sbt.inorder(root2);
		System.out.println(" ");
		System.out.println("Are they same ? " + sbt.sameTree(root1, root2));

		Node root3 = new Node(5);
		root3.left = new Node(7);
		root3.right = new Node(8);
		root3.left.right = new Node(10);

		Node root4 = new Node(5);
		root4.left = new Node(7);
		root4.right = new Node(8);
		sbt.inorder(root3);
		System.out.println(" ");
		sbt.inorder(root4);
		System.out.println(" ");
		System.out.println("Are they same ? " + sbt.sameTree(root3, root4));

	}

}
