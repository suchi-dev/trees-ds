package com.ds.binarysearchtrees;

/*
 * Given a binary search tree, we need to insert a new node into 
 * the tree.
 * In a BST, the left sub tree is less than or equal to it's
 * parent and right sub tree is greater than it's parent.
 * This is true for every node in BST
 * 
 * eg :-
 *        20
 *       /  \
 *      15    25
 *      / \   / \
 *    12   18 22 28
 *    / \
 *   10  13
 *   
 *   We need to insert node 9
 *   
 *    	  20
 *       /  \
 *      15    25
 *      / \   / \
 *    12   18 22 28
 *    / \
 *   10  13
 *   /
 *   9
 */
public class InsertionBST {

	public Node insert(Node root, int key) {
		Node node = new Node(key);
		if (root == null) {
			return node;
		}

		Node current = root;
		Node parent = null;
		while (current != null) {
			parent = current;
			if (current.data <= key) {
				current = current.right;

			} else {
				current = current.left;
			}

		}

		if (parent.data <= key) {
			parent.right = node;
		} else {
			parent.left = node;
		}

		return root;

	}

	public void inorder(Node root) {
		if(root !=null) {
			inorder(root.left);
			System.out.print(root.data + "|");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		InsertionBST ibst = new InsertionBST();
		Node root = new Node(20);
		root = ibst.insert(root, 15);
		root = ibst.insert(root, 25);
		root = ibst.insert(root, 12);
		root = ibst.insert(root, 18);
		root = ibst.insert(root, 22);
		root = ibst.insert(root, 10);
		root = ibst.insert(root, 13);
		root = ibst.insert(root, 9);
		root = ibst.insert(root, 28);
		ibst.inorder(root);
		System.out.println(" ");
		System.out.println("The root of the BST is: "+root.data);

	}

}
