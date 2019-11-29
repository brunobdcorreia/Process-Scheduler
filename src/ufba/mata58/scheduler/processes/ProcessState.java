package ufba.mata58.scheduler.processes;

public enum ProcessState {
	IDLE, 
	EXECUTING,
	IN_DISK,
	IN_DISK_QUEUE,
	IN_READY_QUEUE,
	OVERLOAD;
}
