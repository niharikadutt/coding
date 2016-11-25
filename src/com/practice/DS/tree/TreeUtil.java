package com.practice.DS.tree;

public class TreeUtil {

	public static void printInorder(TreeNode root){
		if(root==null)
			return;
		
		printInorder(root.getLeft());
		System.out.println(root.getData());
		printInorder(root.getRight());
	}
}
