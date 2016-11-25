package com.practice.DS.tree;

public class LCA {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		
		System.out.println(findLca(root, 5,1).getData());
	}

	private static TreeNode findLca(TreeNode root, int i, int j) {
		if(root==null)
			return null;
		
		if(root.getData()==i || root.getData()==j)
			return root;
		
		TreeNode leftLca = findLca(root.getLeft(), i, j);
		TreeNode rightLca = findLca(root.getRight(), i, j);
		
		if(leftLca!=null && rightLca!=null)
			return root;
		
		return leftLca==null?rightLca:leftLca;
	}

}
