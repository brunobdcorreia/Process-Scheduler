package ufba.mata58.scheduler.processes;

public class IOBoundProcess extends Process {

	public IOBoundProcess(int arrivalTime, int executionTime, int deadline, int priority) {
		super(arrivalTime, executionTime, deadline, priority);
	}
}
