package com.practice.DS.tree;

public class ConsecutiveIncreasingPath {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.setLeft(new TreeNode(11));
		root.setRight(new TreeNode(9));
		root.getLeft().setLeft(new TreeNode(13));
		root.getLeft().setRight(new TreeNode(12));
		root.getRight().setLeft(new TreeNode(13));
		root.getRight().setRight(new TreeNode(8));
		
		System.out.println(maxConsecutivePath(root));
	}

	private static int maxConsecutivePath(TreeNode root) {
		
		if(root==null)
			return 0;
		
		return maxConsecutivePathUtil(root, root.getData(), 0);
	}

	private static int maxConsecutivePathUtil(TreeNode root, int prevValue, int prevLen) {
		if(root==null){
			return prevLen;
		}
		
		int curVal = root.getData();
		if(curVal == prevValue+1){
			return Integer.max(maxConsecutivePathUtil(root.getLeft(), curVal, prevLen+1), 
					maxConsecutivePathUtil(root.getRight(), curVal, prevLen+1));
		}
		int newPathLen =  Integer.max(maxConsecutivePathUtil(root.getLeft(), curVal, 1), 
					maxConsecutivePathUtil(root.getRight(), curVal, 1));
		return Integer.max(prevLen, newPathLen);
	}

}
