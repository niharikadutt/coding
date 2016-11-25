package com.practice.DS.tree;

public class CountSingleValuedTree {
	
//	private static int count = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(3));
		root.getRight().setRight(new TreeNode(3));
		root.getRight().getLeft().setLeft(new TreeNode(3));
		root.getRight().getRight().setRight(new TreeNode(3));
		
		System.out.println(count(root));
	}
	
	private static int count(TreeNode root){
		Count c = new Count();
		countSingleValuedTrees(root, c);
		return c.count;
	}

	private static boolean countSingleValuedTrees(TreeNode root, Count c) {
		if(root==null)
			return true;
		
		boolean l = countSingleValuedTrees(root.getLeft(), c);
		boolean r = countSingleValuedTrees(root.getRight(), c);
		
		if(l==false || r==false)
			return false;
		
		if(root.getLeft()!=null && root.getLeft().getData()!=root.getData())
			return false;
		
		if(root.getRight()!=null && root.getRight().getData()!=root.getData())
			return false;
		
		c.count++;
		
		return true;
			
	}

}

class Count{
	int count=0;
}
