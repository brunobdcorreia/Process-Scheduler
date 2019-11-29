package ufba.mata58.scheduler.main;

import java.util.ArrayDeque;
import java.util.ArrayList;

import ufba.mata58.scheduler.processes.Process;
import ufba.mata58.scheduler.algorithms.*;

public class Simulation {
	private static Integer quantum = 0;
	private static Integer overload = 0;
	private static Integer timeInDisk = 0;
	private static SchedulingAlgorithm schedulingAlgorithm = new FCFS();
	private static PagingAlgorithm pagingAlgorithm = new FIFO();
	private static ArrayList<Process> processes = new ArrayList<Process>();
	
	public Simulation() { }
	
	public static void addProcess(Process process) {
		if(process != null && processes != null) {
			processes.add(process);
		} else {
			System.out.println("Essa caralha ta nula");
		}
	}
	
	public static void removeProcess(int index) {
		if(!processes.isEmpty()) {
			processes.remove(index);
		}
	}

	public static Integer getQuantum() {
		return quantum;
	}

	public static void setQuantum(Integer quantum) {
		Simulation.quantum = quantum;
	}

	public static Integer getOverload() {
		return overload;
	}

	public static void setOverload(Integer overload) {
		Simulation.overload = overload;
	}

	public static Integer getTimeInDisk() {
		return timeInDisk;
	}
	
	public static void setTimeInDisk(Integer timeInDisk) {
		Simulation.timeInDisk = timeInDisk;
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

	public static ArrayList<Process> getProcesses() {
		return processes;
	}

	public static void setProcesses(ArrayList<Process> processes) {
		Simulation.processes = processes;
	}

	
	
}
