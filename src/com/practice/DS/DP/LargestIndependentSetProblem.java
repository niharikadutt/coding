package com.practice.DS.DP;

import com.practice.DS.tree.TreeNode;

public class LargestIndependentSetProblem {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(4));
		root.getLeft().getLeft().setLeft(new TreeNode(9));
		root.getLeft().getRight().setLeft(new TreeNode(9));
		//root.getLeft().getLeft().setLeft(new TreeNode(8));
		root.getLeft().setRight(new TreeNode(5));
		//root.getLeft().getRight().setRight(new TreeNode(9));
		//root.getLeft().getRight().getRight().setRight(new TreeNode(10));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		System.out.println(findLISS(root));
	}
	
	private static int findLISS(TreeNode root){
		if(root==null)
			return 0;
		
		if(root.getLiss()!=0){
			return root.getLiss();
		}
		
		if(root.getLeft()==null && root.getRight()==null){
			root.setLiss(1);
			return 1;
			
		}
		
		int lissExcl = findLISS(root.getLeft())+findLISS(root.getRight());
		
		int lissIncl = 1;
		if(root.getLeft()!=null)
			lissIncl+=findLISS(root.getLeft().getLeft())+findLISS(root.getLeft().getRight());
		if(root.getRight()!=null)
			lissIncl+=findLISS(root.getRight().getLeft())+findLISS(root.getRight().getRight());
		
		root.setLiss(Integer.max(lissExcl, lissIncl));
		
		return root.getLiss();
	}

}

