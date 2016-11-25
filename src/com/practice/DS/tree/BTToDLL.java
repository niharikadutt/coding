package com.practice.DS.tree;

public class BTToDLL {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));
		
	   // root = convertToDLL(root);
	    root = convertToDLL2(root);
	}

	private static TreeNode convertToDLL2(TreeNode root) {
		
		if(root==null)
			return null;
		
		TreeNode left = convertToDLL2(root.getLeft());
		TreeNode right = convertToDLL2(root.getRight());
		TreeNode head = null;
		if(left==null){
			head=root;
		}
		else{
			head = left;
			left.getLeft().setRight(root);
			root.setLeft(left.getLeft());
		}
		if(right==null){
			head.setLeft(root);
			root.setRight(head);
		}
		else{
			head.setLeft(right);
			left.getLeft().setRight(root);
			root.setLeft(left.getLeft());
		}
		return null;
	}

	private static TreeNode convertToDLL(TreeNode root) {
		if(root==null)
			return null;
		
		TreeNode left = convertToDLL(root.getLeft());
		TreeNode right = convertToDLL(root.getRight());
		
		root.setLeft(root);
		root.setRight(root);
		
		return concatenate(concatenate(left, root), right);
	}

	private static TreeNode concatenate(TreeNode left, TreeNode right) {
		if(left==null)
			return right;
		
		if(right==null)
			return left;
		
		TreeNode leftLast = left.getLeft();
		TreeNode rightLast = right.getRight();
		
		leftLast.setRight(right);
		right.setLeft(leftLast);
		
		left.setLeft(rightLast);
		rightLast.setRight(left);
		
		return left;
	}

}
