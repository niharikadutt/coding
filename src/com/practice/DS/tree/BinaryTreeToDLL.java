package com.practice.DS.tree;

public class BinaryTreeToDLL {
	
	private static TreeNode head=null;
	private static TreeNode prev=null;
	
	private static TreeNode root=null;

	public static void main(String[] args) {
		root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));
		
		convertBTToDLL(root);
		print(head);
	}

	private static void convertBTToDLL(TreeNode root) {
		if(root==null)
			return;
		
		convertBTToDLL(root.getLeft());
		if(prev==null){
			head=root;
		}
		else{
			root.setLeft(prev);
			prev.setRight(root);
		}
		
		prev = root;
		
		convertBTToDLL(root.getRight());
	}
	
	private static void print(TreeNode root) {
		if(root==null){
			return;
		}
		System.out.println(root.getData());
		//print(root.getLeft());
		print(root.getRight());
		
	}

}
