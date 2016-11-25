package com.practice.DS.tree;

public class Print2dTree {
	
	private static int COUNT=10;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(14));
		root.getRight().setRight(new TreeNode(8));
		
		print2D(root, 0);		
		
	}

	private static void print2D(TreeNode root, int space) {
		if(root==null)
			return;
		
		space+=COUNT;
		
		print2D(root.getRight(), space);
		
		for(int i=COUNT;i<space;i++){
			System.out.print(" ");
		}
		System.out.println(root.getData());
		
		print2D(root.getLeft(), space);
	}

}
