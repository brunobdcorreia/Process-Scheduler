package ufba.mata58.scheduler.algorithms;

import java.util.ArrayList;

import ufba.mata58.scheduler.main.Simulation;
import ufba.mata58.scheduler.processes.Process;
import ufba.mata58.scheduler.processes.ProcessState;

public final class FCFS extends SchedulingAlgorithm {
	@Override
	protected void schedule() {
		ArrayList<Process> processes = Simulation.getProcesses();
		Simulation.getDisk().setAwaiting(processes);
		Simulation.getDisk().useDisk();
		
		for(Process p : Simulation.getDisk().getAwaiting()) 
			p.setProcessState(ProcessState.IN_DISK_QUEUE);		
		
		Process ready = Simulation.getDisk().freeDisk();
		ready.setProcessState(ProcessState.IN_READY_QUEUE);
		
		Simulation.getRam().addProcess(ready);
	}
	
	@Override
	protected double calculateTurnaroundTime() {
		return 0.0;
	}
}
