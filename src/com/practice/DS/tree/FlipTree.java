package com.practice.DS.tree;

public class FlipTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(4));
		root.getRight().setRight(new TreeNode(5));
		
		root = flipTree(root);
		print(root);
	}

	private static void print(TreeNode root) {
		if(root==null){
			return;
		}
		System.out.println(root.getData());
		print(root.getLeft());
		print(root.getRight());
		
	}

	private static TreeNode flipTree(TreeNode root) {
		if(root==null)
			return null;
		
		if(root.getLeft()==null && root.getRight()==null)
			return root;
		
		TreeNode flippedNode = flipTree(root.getLeft());
		root.getLeft().setLeft(root.getRight());
		root.getLeft().setRight(root);
		root.setLeft(null);
		root.setRight(null);
		
		return  flippedNode;
	}

}
