package ufba.mata58.scheduler.memory;

import java.util.ArrayList;
import ufba.mata58.scheduler.processes.Process;
import ufba.mata58.scheduler.processes.ProcessState;

public class Disk {
	private ArrayList<Process> awaiting;
	private Process currentProcess;
	
	public Disk() {
		awaiting = new ArrayList<Process>();
	}
	
	public void useDisk() {
		awaiting.get(0).setProcessState(ProcessState.IN_DISK);
		currentProcess = awaiting.get(0);
		awaiting.remove(0);
	}
	
	public Process freeDisk() {
		Process process = currentProcess;
		currentProcess = null;
		return process;
	}
	
	public Process getCurrentProcess() {
		return currentProcess;
	}

	public ArrayList<Process> getAwaiting() {
		return awaiting;
	}

	public void setAwaiting(ArrayList<Process> awaiting) {
		this.awaiting = awaiting;
	}

	public void setCurrentProcess(Process currentProcess) {
		this.currentProcess = currentProcess;
	}
}
