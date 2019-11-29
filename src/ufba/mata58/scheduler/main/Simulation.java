package ufba.mata58.scheduler.main;

import java.util.ArrayDeque;

import ufba.mata58.scheduler.processes.Process;
import ufba.mata58.scheduler.algorithms.*;

public class Simulation {
	private static short quantum;
	private static short overload;
	private static SchedulingAlgorithm schedulingAlgorithm;
	private static PagingAlgorithm pagingAlgorithm;
	private static ArrayDeque<Process> processes;
	
	public Simulation() {
		quantum = overload = 0;
		processes = new ArrayDeque<Process>();
		schedulingAlgorithm = new FCFS();
		pagingAlgorithm = new FIFO();
		schedulingAlgorithm.setProcessQueue(processes);	
	}
	
	public static void addProcess(Process process) {
		if(process != null) {
			processes.add(process);
		}
	}

	public static short getQuantum() {
		return quantum;
	}

	public static void setQuantum(short quantum) {
		Simulation.quantum = quantum;
	}

	public static short getOverload() {
		return overload;
	}

	public static void setOverload(short overload) {
		Simulation.overload = overload;
	}

	public static SchedulingAlgorithm getSchedulingAlgorithm() {
		return schedulingAlgorithm;
	}

	public static void setSchedulingAlgorithm(SchedulingAlgorithm schedulingAlgorithm) {
		Simulation.schedulingAlgorithm = schedulingAlgorithm;
	}

	public static PagingAlgorithm getPagingAlgorithm() {
		return pagingAlgorithm;
	}

	public static void setPagingAlgorithm(PagingAlgorithm pagingAlgorithm) {
		Simulation.pagingAlgorithm = pagingAlgorithm;
	}

	public static ArrayDeque<Process> getProcesses() {
		return processes;
	}

	public static void setProcesses(ArrayDeque<Process> processes) {
		Simulation.processes = processes;
	}
}
