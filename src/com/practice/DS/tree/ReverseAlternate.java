package com.practice.DS.tree;

public class ReverseAlternate {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		root.getRight().getLeft().setLeft(new TreeNode(6));
		root.getRight().getRight().setRight(new TreeNode(7));
		
		TreeNode res = reverse(root);
		
		printInorder(res);
	}

	private static TreeNode reverse(TreeNode root) {
		if(root==null)
			return null;
		if(root.getLeft()!=null && root.getRight()!=null)
			reverseUtil(root.getLeft(), root.getRight(), 1);
		return root;
	}

	private static void reverseUtil(TreeNode left, TreeNode right, int lvl) {
		if(left==null || right==null)
			return;
		
		if(lvl%2!=0){
			int temp = left.getData();
			left.setData(right.getData());
			right.setData(temp);		
		}
		
		reverseUtil(left.getLeft(), right.getRight(), lvl+1);
		reverseUtil(left.getRight(), right.getLeft(), lvl+1);
	}
	
	private static void printInorder(TreeNode root){
		if(root==null)
			return;
		printInorder(root.getLeft());
		System.out.println(root.getData());
		printInorder(root.getRight());
		}

}
