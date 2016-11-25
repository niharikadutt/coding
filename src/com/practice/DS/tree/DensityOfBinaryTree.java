package com.practice.DS.tree;

public class DensityOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(4));
		root.getRight().setRight(new TreeNode(5));
		
		System.out.println(getDensity(root));		
		
	}

	private static int getDensity(TreeNode root) {
		if(root==null)
			return 0;
		
		Size size = new Size();
		
		int height = getDensityUtil(root, size);
		
		return size.size/height;
	}

	private static int getDensityUtil(TreeNode root, Size size) {
		if(root==null)
			return 0;
		
		int l = getDensityUtil(root.getLeft(), size);
		int r = getDensityUtil(root.getLeft(), size);
		
		size.size++;
		
		return l+r+1;
	}
}
class Size{
	int size;
}
