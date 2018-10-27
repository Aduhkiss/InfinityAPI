package net.angusbeefgaming.api.util;

public class Message {
	String info;
	
	public Message(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return info;
	}
}