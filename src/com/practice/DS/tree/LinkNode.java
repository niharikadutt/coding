package com.practice.DS.tree;

public class LinkNode {
	
	private int data;
	private LinkNode prev;
	private LinkNode next;
	
	public LinkNode(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkNode getPrev() {
		return prev;
	}

	public void setPrev(LinkNode prev) {
		this.prev = prev;
	}

	public LinkNode getNext() {
		return next;
	}

	public void setNext(LinkNode next) {
		this.next = next;
	}


}
