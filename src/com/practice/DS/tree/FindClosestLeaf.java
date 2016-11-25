package com.practice.DS.tree;

public class FindClosestLeaf {
	
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(1));
		root.getRight().setRight(new TreeNode(5));
		root.getRight().getLeft().setLeft(new TreeNode(6));
		root.getRight().getRight().setRight(new TreeNode(7));
		
		findClosestLeaf(root, root.getRight());
		
		System.out.println(min);
	}

	private static void findClosestLeaf(TreeNode root, TreeNode data) {	
		
		findLeafDown(data, 0);
		
		findLeafViaRoot(root, data);
	}

	private static int findLeafViaRoot(TreeNode root, TreeNode data) {
		if(root==null)
			return -1;
		
		if(root==data){
			return 0;
		}
		
		int l = findLeafViaRoot(root.getLeft(), data);
		if(l!=-1){
			findLeafDown(root.getRight(), l+2);
			return l+1;
		}
		
		int r = findLeafViaRoot(root.getRight(), data);
		if(r!=-1){
			findLeafDown(root.getLeft(), r+2);
			return r+1;
		}
		
		return -1;

	}

	private static void findLeafDown(TreeNode data, int level) {
		if(data==null){
			return;
		}
		
		if(data.getLeft()==null && data.getRight()==null){
			if(level<min){
				min = level;
			}
		}
		
		findLeafDown(data.getLeft(), level+1);
		findLeafDown(data.getRight(), level+1);
	}
	
	
	
	
	
	

}
