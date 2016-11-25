package com.practice.DS.tree;

public class MaximumDifference {
	
	private static int res = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		maximumDifference(root);
		System.out.println(res);
	}

	private static int maximumDifference(TreeNode root) {
		if(root==null)
			return Integer.MAX_VALUE;
		
		if(root.getLeft()==null && root.getRight()==null)
			return root.getData();
		
		int val = Math.min(maximumDifference(root.getLeft()), maximumDifference(root.getRight()));
		
		res = Math.max(res, root.getData()-val);
		
		return Math.min(root.getData(), val);
		
	}

}

