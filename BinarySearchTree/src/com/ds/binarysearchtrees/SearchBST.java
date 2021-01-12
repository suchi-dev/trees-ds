package com.ds.binarysearchtrees;

/*
 * Given a binary search tree, we need to find if a given key
 * is present in the tree.
 * In a BST, the left sub tree is less than or equal to it's
 * parent and right sub tree is greater than it's parent.
 * This is true for every node in BST. We use this property
 * to check if the key is present by comparing the root data with key
 * and moving either to left or right half of the tree.
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
 *   eg:- for key 10, we return node 10 as it is present
 *   for key 14, we return null as it is not present in the tree.
 *   
 *   
 */
public class SearchBST {

	public Node search(Node root, int key) {
		if (root == null)
			return null;
		if (root.data == key)
			return root;

		if (root.data < key) {
			return search(root.right, key);

		} else {
			return search(root.left, key);
		}

	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "|");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		SearchBST sbst = new SearchBST();
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
		sbst.inorder(root);
		System.out.println(" ");
		System.out.println("The node is:- " + sbst.search(root, 10));
		System.out.println("The node is:- " + sbst.search(root, 14));

	}

}
