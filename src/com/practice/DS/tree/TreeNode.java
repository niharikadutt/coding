package com.practice.DS.tree;

public class TreeNode {
	
	private int data;
	private TreeNode left;
	private TreeNode right;
	private int liss = 0;


	public TreeNode(int data){
		this.data = data;
	}
	
	public TreeNode(TreeNode node){
		this.data = node.getData();
		this.right = node.getRight();
		this.left = node.getLeft();
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public int getLiss() {
		return liss;
	}

	public void setLiss(int liss) {
		this.liss = liss;
	}

}
