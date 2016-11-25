package com.practice.DS.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalPrint {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(4));
		root.getRight().setRight(new TreeNode(5));
		
		printDiagonal(root);
	}

	private static void printDiagonal(TreeNode root) {
		if(root==null)
			return;
		
		Map<Integer, List<TreeNode>> map = new HashMap<>();
		printDiagonalUtil(root,0, map);
		
		map.forEach((k, v)->{
			v.forEach(n-> System.out.println(n.getData()));
		});
	}

	private static void printDiagonalUtil(TreeNode root, int d, Map<Integer, List<TreeNode>> map) {
		if(root==null)
			return;
		
		if(map.containsKey(d)){
			List<TreeNode> list = map.get(d);
			list.add(root);
		}
		else{
			List<TreeNode> node = new ArrayList<>();
			node.add(root);
			map.put(d, node);
		}
		printDiagonalUtil(root.getLeft(), d+1, map);
		printDiagonalUtil(root.getRight(), d, map);
		
	}

}
