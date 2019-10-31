package ufba.mata58.scheduler.algorithms;

import java.util.ArrayDeque;

public abstract class Algorithm {
	protected ArrayDeque<Process> processQueue;
	
	public Algorithm() {
		processQueue = new ArrayDeque<Process>();
	}
	
	protected abstract void schedule();
	protected abstract double calculateTurnaroundTime();
}
