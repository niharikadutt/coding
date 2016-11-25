package com.practice.DS.linkedlist;

public class FlatteingLinkedList {
	
	/*
	 * 1. Recursive solution
	 * 2. Call method for right
	 * 3. merge node and its right node
	 */
	public static void main(String[] args) {
		LinkNode a = new LinkNode(5);
		a.setNext(new LinkNode(10));
		a.getNext().setNext(new LinkNode(19));
		a.getNext().getNext().setNext(new LinkNode(28));
		a.setDown(new LinkNode(7));
		a.getDown().setDown(new LinkNode(8));
		a.getNext().getNext().setDown(new LinkNode(22));
		
		LinkNode list = flattenList(a);
		print(list);
	}

	
	private static LinkNode flattenList(LinkNode node){
		if(node==null || node.getNext()==null)
			return node;
		
		node.setNext(flattenList(node.getNext()));
		
		node = merge(node, node.getNext());
		return node;
	}
	
	private static LinkNode merge(LinkNode node1, LinkNode node2){
		if(node1==null) return node2;
		if(node2==null) return node1;
		
		LinkNode temp = null;
		if(node1.getData()<node2.getData()){
			temp = node1;
			temp.setDown(merge(node1.getDown(), node2));
		}
		else{
			temp = node2;
			temp.setDown(merge(node1, node2.getDown()));
		}
		
		return temp;
	}
	
	private static void print(LinkNode node){
		while(node!=null){
			System.out.println(node.getData());
			node = node.getDown();
		}
	}

	
	
	
}

