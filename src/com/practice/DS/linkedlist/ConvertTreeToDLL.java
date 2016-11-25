package com.practice.DS.linkedlist;

import com.practice.DS.tree.TreeNode;

public class ConvertTreeToDLL {
    
    // head --> Pointer to head node of created doubly linked list
	static TreeNode head;
      
    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static TreeNode prev = null;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
				
		 treeToDoublyList(root);	
		 printList(head);
	}
	
	private static void treeToDoublyList(TreeNode root){
		if(root==null){
			return;
		}
		treeToDoublyList(root.getLeft());
		
		if(prev!=null){
			root.setLeft(prev);
			prev.setRight(root);
		}
		else{
			head = root;
		}
		
		prev = root;
		
		treeToDoublyList(root.getRight());
		
		
	}
	
	private static void printList(TreeNode node)
    {
        while (node != null) 
        {
            System.out.print(node.getData() + " ");
            node = node.getRight();
        }
    }
	

}


