package com.practice.DS.tree;

public class PrintCousin {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(14));
		root.getRight().setRight(new TreeNode(8));
		Result r = new Result();
		printCousin(root, null, 12, 0, r);
	}

	private static void printCousin(TreeNode root, TreeNode parent, int data, int level, Result r) {
		 if(root==null)
			 return;
		 
		 if(root.getData()==data){
			 r.level = level;
			 r.parent = parent;
			 return;
		 }
		 
		 if(level==r.level && parent!=r.parent){
			 System.out.println(root.getData()+" ");
		 }
		 
		 printCousin(root.getLeft(), root, data, level+1, r);
		 printCousin(root.getRight(), root, data, level+1, r);
		 
		 
	}

}

class Result{
	int level;
	TreeNode parent;
}
