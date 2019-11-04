package ufba.mata58.scheduler.processes;

public class CPUBoundProcess extends Process {

	public CPUBoundProcess(int arrivalTime, int executionTime, int deadline, int priority) {
		super(arrivalTime, executionTime, deadline, priority);
	}	
}
