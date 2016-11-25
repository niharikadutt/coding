package com.practice.DS.tree;

public class RemoveNodesAfterK {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		root.getRight().getLeft().setLeft(new TreeNode(6));
		root.getRight().getRight().setRight(new TreeNode(7));
		
		TreeNode res = removeNodes(root, 2, 0);
		printInorder(res);
		
	}

	private static TreeNode removeNodes(TreeNode root, int k, int level) {
		if(root==null){
			return null;
		}
		
		root.setLeft(removeNodes(root.getLeft(), k, level+1));
		root.setRight(removeNodes(root.getRight(), k, level+1));
		
		if(root.getLeft()==null && root.getRight()==null && level>k)
			return null;
		
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
