package ufba.mata58.scheduler.memory;

import java.util.ArrayDeque;
import ufba.mata58.scheduler.processes.Process;
import ufba.mata58.scheduler.processes.ProcessState;

public class Disk {
	private ArrayDeque<Process> awaiting;
	private Process currentProcess;
	
	public Disk() {
		awaiting = new ArrayDeque<Process>();
	}
	
	private void useDisk() {
		awaiting.getFirst().setProcessState(ProcessState.IN_DISK);
		currentProcess = awaiting.getFirst();
		awaiting.removeFirst();
	}
	
	private void freeDisk() {
		currentProcess = null;
	}
	
	public Process getCurrentProcess() {
		return currentProcess;
	}
}
