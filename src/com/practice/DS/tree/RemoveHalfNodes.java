package com.practice.DS.tree;

public class RemoveHalfNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		root.getRight().getLeft().setLeft(new TreeNode(6));
		root.getRight().getRight().setRight(new TreeNode(7));
		
		root = removeHalfNodes(root);
		
		printInorder(root);

	}

	private static TreeNode removeHalfNodes(TreeNode root) {		
		if(root==null){
			return null;
		}
		
		root.setLeft(removeHalfNodes(root.getLeft()));
		root.setRight(removeHalfNodes(root.getRight()));
		
		if(root.getLeft()==null && root.getRight()==null)
			return root;
		
		if(root.getLeft()==null){
			TreeNode newNode = new TreeNode(root.getRight());
			return newNode;
		}
		else if(root.getRight()==null){
			TreeNode newNode = new TreeNode(root.getLeft());
			return newNode;
		}
		
		return root;
		
	}
	
	private static void printInorder(TreeNode root){
		if(root==null)
			return;
		
			printInorder(root.getLeft());
			System.out.println(root.getData());
			printInorder(root.getRight());
		}

}
