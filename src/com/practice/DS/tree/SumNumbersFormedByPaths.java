package com.practice.DS.tree;

public class SumNumbersFormedByPaths {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(4));
		root.getRight().setRight(new TreeNode(5));
		
		System.out.println(getSum(root, 0));
	}

	private static int getSum(TreeNode root, int val) {
		if(root==null)
			return 0;
		
		val = val*10+root.getData();
		
		if(root.getLeft()==null && root.getRight()==null){
			return val;
		}
		
		return getSum(root.getLeft(), val)+getSum(root.getRight(), val);
	}

}
