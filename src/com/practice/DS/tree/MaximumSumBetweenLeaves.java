package com.practice.DS.tree;

public class MaximumSumBetweenLeaves {
	
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		root.getRight().getLeft().setLeft(new TreeNode(6));
		root.getRight().getRight().setRight(new TreeNode(7));
		
		getMaxSum(root);
		System.out.println(max);
	}

	private static int getMaxSum(TreeNode root) {
		if(root==null)
			return 0;
		
		int ls = getMaxSum(root.getLeft());
		int rs = getMaxSum(root.getRight());
		
		int currSum;
		
		if(ls<0&&rs<0)
			currSum = root.getData();	
		else
			currSum = Math.max(Math.max(ls, rs)+root.getData(), ls+rs+root.getData());
		
		if(max<currSum)
			max = currSum;
		
		return Math.max(ls, rs)+root.getData();
		
	}
	
	

}
