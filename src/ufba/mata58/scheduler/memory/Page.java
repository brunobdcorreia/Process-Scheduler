package ufba.mata58.scheduler.memory;

public class Page {
	private Process ownerProcess;
	private int id;
	private static short pageId = 1;
	
	public Page() { 
		id = pageId;
	}

	public Process getOwnerProcess() {
		return ownerProcess;
	}

	public void setOwnerProcess(Process ownerProcess) {
		this.ownerProcess = ownerProcess;
	}

	public static short getPageId() {
		return pageId;
	}

	public static void setPageId(short pageId) {
		Page.pageId = pageId;
	}
	
}
