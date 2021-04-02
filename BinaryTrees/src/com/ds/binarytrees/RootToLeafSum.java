package com.ds.binarytrees;

import java.util.ArrayList;
import java.util.List;

/*
 * Given root node and sum, we need to find if there exists a path
 * from root to leaf node with the given sum
 * 
 * Conside this example
 * 
 *     20
 *     /\
 *   10  8
 *   /   /\
 *  4   3  7 
 *  
 *  For this example, we consider sum as 35. There exists a path from leaf
 *   to root such that sum is 35
 *   Path is 7, 8, 20
 *   
 *  
 * 
 */
public class RootToLeafSum {

	public boolean calculatePath(Node root, int sum, List<Integer> path) {

		if (root == null)
			return false;

		// check if it is a leaf node
		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				path.add(root.data);
				return true;
			} else {
				return false;
			}
		}

		if (calculatePath(root.left, sum - root.data, path)) {
			path.add(root.data);
			return true;
		}
		if (calculatePath(root.right, sum - root.data, path)) {
			path.add(root.data);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(8);
		root.left.left = new Node(4);
		root.right.left = new Node(3);
		root.right.right = new Node(7);
		System.out.println("Calculating path");
		RootToLeafSum rootToLeafSum = new RootToLeafSum();
		List<Integer> result = new ArrayList<>();
		boolean pathExists = rootToLeafSum.calculatePath(root, 35, result);
		System.out.println("Path exists ? " + pathExists);
		result.stream().forEach(System.out::println);

	}

}
