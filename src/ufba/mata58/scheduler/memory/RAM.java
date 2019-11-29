package ufba.mata58.scheduler.memory;

import java.util.ArrayDeque;

public class RAM {
	private final byte capacity = 50;
	private ArrayDeque<Page> pages;
	
	public RAM() { 
		pages = new ArrayDeque<Page>();
		
		for(int i =  0; i < capacity; ++i) {
			pages.add(new Page());
		}
	}
}
