package com.practice.DS.tree;

public class UncoverSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(11));
		root.getRight().setRight(new TreeNode(5));
		System.out.println(uncoverSum(root));
	}

	private static boolean uncoverSum(TreeNode root) {
		int tSum = getTotalSum(root);
		System.out.println(tSum);
		int uncoveredSum = getUncoveredSum(root);
		System.out.println(uncoveredSum);
		
		return (tSum/2)==uncoveredSum;
	}

	private static int getUncoveredSum(TreeNode root) {
		if(root==null)
			return 0;
		
		int lSum = getUncoveredLeftSum(root.getLeft());
		System.out.println(lSum);
		int rSum = getUncoveredRightSum(root.getRight());
		System.out.println(rSum);
		
		return lSum+rSum+root.getData();
	}

	private static int getUncoveredRightSum(TreeNode root) {
		if(root.getLeft()==null && root.getRight()==null)
			return root.getData();
		
		if(root.getRight()!=null){
			return root.getData()+getUncoveredRightSum(root.getRight());
		}
		else
			return root.getData()+getUncoveredRightSum(root.getLeft());
	}

	private static int getUncoveredLeftSum(TreeNode root) {
		
		if(root.getLeft()==null && root.getRight()==null)
			return root.getData();
		
		if(root.getLeft()!=null){
			return root.getData()+getUncoveredLeftSum(root.getLeft());
		}
		else
			return root.getData()+getUncoveredLeftSum(root.getRight());
	}

	private static int getTotalSum(TreeNode root) {
		if(root==null){
			return 0;
		}	
		return root.getData()+getTotalSum(root.getLeft())+getTotalSum(root.getRight());
	}

}
