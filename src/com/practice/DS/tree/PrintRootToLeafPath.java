package com.practice.DS.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrintRootToLeafPath {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(4));
		root.getRight().setRight(new TreeNode(5));
		
		printRootToLeafPath(root);
	}

	private static void printRootToLeafPath(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		Map<TreeNode, TreeNode> map = new HashMap<>();
		map.put(root, null);

		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();

			if (curr.getLeft() == null && curr.getRight() == null) {
				System.out.println("-----Path----");
				printPath(curr, map);
			}

				if (curr.getLeft() != null) {
					stack.push(curr.getLeft());
					map.put(curr.getLeft(), curr);
				}

				if (curr.getRight() != null) {
					stack.push(curr.getRight());
					map.put(curr.getRight(), curr);
				}
		}
	}

	private static void printPath(TreeNode curr, Map<TreeNode, TreeNode> map) {
		Stack<TreeNode> stack = new Stack<>();
		while(curr!=null){
			stack.push(curr);
			curr = map.get(curr);
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop().getData());
		}
	}

}
