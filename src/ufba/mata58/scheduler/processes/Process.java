package ufba.mata58.scheduler.processes;

import java.util.HashSet;
import java.util.Random;

public abstract class Process {
	protected static Random rand = new Random();
	protected static HashSet<Integer> registeredPids = new HashSet<Integer>();
	protected int processId = 0;
	protected int arrivalTime;
	protected int executionTime;
	protected int deadline;
	protected int priority;
	protected boolean done = false;
	
	
	public Process(int arrivalTime, int executionTime, int deadline, int priority) {
		int newPid = rand.nextInt(256);
		
		while(registeredPids.contains(newPid)) {
			newPid = rand.nextInt(256);
		}
		
		this.arrivalTime = arrivalTime;
		this.executionTime = executionTime;
		this.deadline = deadline;
		this.priority = priority;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(int arrivalTime) {
		if(arrivalTime >= 0)
			this.arrivalTime = arrivalTime;
	}
	
	public int getExecutionTime() {
		return executionTime;
	}
	
	public void setExecutionTime(int executionTime) {
		if(executionTime >= 0)
			this.executionTime = executionTime;
	}
	
	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		if(deadline >= 0)
			this.deadline = deadline;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		if(priority >= 0)
			this.priority = priority;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean finished) {
		this.done = finished;
	}
}
