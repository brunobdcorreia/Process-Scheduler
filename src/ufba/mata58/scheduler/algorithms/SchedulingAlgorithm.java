package ufba.mata58.scheduler.algorithms;

import java.util.ArrayDeque;
import ufba.mata58.scheduler.processes.Process;

public abstract class SchedulingAlgorithm {
	protected ArrayDeque<Process> processQueue;
	
	public SchedulingAlgorithm() {
		processQueue = new ArrayDeque<Process>();
	}
	
	public ArrayDeque<Process> getProcessQueue() {
		return processQueue;
	}

	public void setProcessQueue(ArrayDeque<Process> processQueue) {
		this.processQueue = processQueue;
	}

	protected abstract void schedule();
	protected abstract double calculateTurnaroundTime();
}
