package ufba.mata58.scheduler.memory;

public class Page {
	private Process ownerProcess;
	private static short pageId = 1;
	
	public Page() { }

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
