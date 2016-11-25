package com.practice.DS.linkedlist;

public class SortAlternateAscAndDsc {

	/*
	 * 1. Split in two lists
	 * 2. reverse descending order list
	 * 3. merge two lists
	 */
	public static void main(String[] args) {
		LinkNode a = new LinkNode(2);
		a.setNext(new LinkNode(4));
		a.getNext().setNext(new LinkNode(7));
		a.getNext().getNext().setNext(new LinkNode(8));
		a.getNext().getNext().getNext().setNext(new LinkNode(10));
		
		LinkNode b = new LinkNode(1);
		b.setNext(new LinkNode(3));
		b.getNext().setNext(new LinkNode(12));
		
		LinkNode node = mergeList(a, b);
		print(node);
	}

	private static LinkNode mergeList(LinkNode a, LinkNode b){
		if(a==null) return b;
		if(b==null) return a;
		
		LinkNode temp = null;
		if(a.getData()>b.getData()){
			temp = b;
			b.setNext(mergeList(a, b.getNext()));
		}
		else{
			temp = a;
			a.setNext(mergeList(a.getNext(), b));
		}
		
		return temp;
		
	}
	
	private static void print(LinkNode node){
		while(node!=null){
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
}
