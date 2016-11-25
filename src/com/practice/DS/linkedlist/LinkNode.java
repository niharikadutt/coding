package com.practice.DS.linkedlist;

public class LinkNode {
	private int data;
	private LinkNode next;
	private LinkNode down;
	
	public LinkNode(int data){
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkNode getNext() {
		return next;
	}
	public void setNext(LinkNode next) {
		this.next = next;
	}
	public LinkNode getDown() {
		return down;
	}
	public void setDown(LinkNode down) {
		this.down = down;
	}
	
}
