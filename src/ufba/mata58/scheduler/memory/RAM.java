package ufba.mata58.scheduler.memory;

import java.util.ArrayList;
import ufba.mata58.scheduler.processes.Process;

public class RAM {
	private final byte capacity = 50;
	private ArrayList<Page> pages;
	
	public RAM() { 
		pages = new ArrayList<Page>(capacity);
	}
	
	public void addProcess(Process p) {
		if(p.getProcessPages().size() + pages.size() > capacity) {
			//Troca as paginas.
		} else {
			for(Page page : p.getProcessPages()) {
				if(page != null) {
					pages.add(page);
				}
			}
		}
	}
}
