package ufba.mata58.scheduler.processes;

import java.util.HashSet;
import java.util.Random;

import ufba.mata58.scheduler.gui.ProcessModel;
import ufba.mata58.scheduler.main.Simulation;

public class Process {
	protected int processId = 0;
	protected int arrivalTime;
	protected int executionTime;
	protected int deadline;
	protected int priority;
	protected int nPages;
	protected boolean done = false;
	protected ProcessState processState;
	
	public Process(int arrivalTime, int executionTime, int deadline, int priority, int nPages) {		
		this.processId = Simulation.getProcesses().size() + 1;
		this.arrivalTime = arrivalTime;
		this.executionTime = executionTime;
		this.deadline = deadline;
		this.priority = priority;
		this.nPages = nPages;
		this.processState = ProcessState.IDLE;
	}
	
	public int getPid() {
		return processId;
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
	
	public ProcessState getProcessState() {
		return processState;
	}
	
	public void setProcessState(ProcessState newState) {
		this.processState = newState;
	}
	
	@Override
	public String toString() {
		return "Pid: " + processId;
	}
}
