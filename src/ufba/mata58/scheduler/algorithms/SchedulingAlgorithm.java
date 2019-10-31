package ufba.mata58.scheduler.algorithms;

import java.util.ArrayDeque;

public abstract class SchedulingAlgorithm {
	protected ArrayDeque<Process> processQueue;
	
	public SchedulingAlgorithm() {
		processQueue = new ArrayDeque<Process>();
	}
	
	protected abstract void schedule();
	protected abstract double calculateTurnaroundTime();
}
