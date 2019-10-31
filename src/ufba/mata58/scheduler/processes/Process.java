package ufba.mata58.scheduler.processes;

public abstract class Process {
	protected int processId;
	protected int arrivalTime;
	protected int executionTime;
	protected int deadline;
	protected int priority;
	
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
}
