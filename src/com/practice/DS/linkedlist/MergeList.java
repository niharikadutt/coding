package com.practice.DS.linkedlist;

public class MergeList {

	public static void main(String[] args) {
		LinkNode a = new LinkNode(2);
		a.setNext(new LinkNode(4));
		a.getNext().setNext(new LinkNode(7));
		a.getNext().getNext().setNext(new LinkNode(8));
		a.getNext().getNext().getNext().setNext(new LinkNode(10));
		
		LinkNode b = new LinkNode(1);
		b.setNext(new LinkNode(3));
		b.getNext().setNext(new LinkNode(12));
		
		LinkNode result = merge(a, b);
		print(result);
	}
	
	private static LinkNode merge(LinkNode a, LinkNode b){
		LinkNode a_curr = a;
		LinkNode b_curr = b;
		
		LinkNode a_next = null;
		LinkNode b_next = null;
		
		while(a_curr!=null && b_curr!=null){
			a_next = a_curr.getNext();
			b_next = b_curr.getNext();
			
			a_curr.setNext(b_next);
			b_curr.setNext(a_next);
			
			a_curr = a_next;
			b_curr = a_curr;
		}
		return a_curr;
	}
	
	private static void print(LinkNode node){
		while(node!=null){
			System.out.println(node.getData());
			node = node.getDown();
		}
	}


}
