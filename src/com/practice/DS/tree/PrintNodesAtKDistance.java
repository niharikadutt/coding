package com.practice.DS.tree;

public class PrintNodesAtKDistance {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		root.getRight().getLeft().setLeft(new TreeNode(6));
		root.getRight().getRight().setRight(new TreeNode(7));
		
		printAtKDistance(root, root.getRight().getRight().getData(),2);
	}

	private static int printAtKDistance(TreeNode root, int data, int k) {
		if(root==null)return -1;
		
		if(root.getData()==data)
		{
			printDown(root.getLeft(), k);
			printDown(root.getRight(), k);
		}
		
		int l = printAtKDistance(root.getLeft(), data, k);
		if(l!=-1){
			if(k-l==0){
				System.out.println(root.getData());
			}
			else{
				printDown(root.getRight(), k-l);
				return l+1;
			}
		}
		
		int r = printAtKDistance(root.getRight(), data, k);
		if(r!=-1){
			if(k-r==0){
				System.out.println(root.getData());
			}
			else{
				printDown(root.getLeft(), k-r);
				return r+1;
			}
		}
		
		return -1;
	}

	private static void printDown(TreeNode root, int k) {
		if(root==null || k<0)
			return;
		
		if(k==0){
			System.out.println(root.getData());
			return;
		}
		
		printDown(root.getLeft(), k-1);
		printDown(root.getRight(), k-1);
	}
}
