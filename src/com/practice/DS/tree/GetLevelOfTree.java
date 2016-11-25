package com.practice.DS.tree;

public class GetLevelOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(14));
		root.getRight().setRight(new TreeNode(8));
		
		System.out.println(getLevel(root, 12, 1));
	}

	private static int getLevel(TreeNode root, int data, int level) {
		if(root==null)
			return -1;
		
		if(root.getData()==data){
			return level;
		}
		
		int l = getLevel(root.getLeft(), data, level+1);
		
		if(l!=-1){
			return l;
		}
		return getLevel(root.getRight(), data, level+1);

	}

}
