package ufba.mata58.scheduler.algorithms;

import java.util.ArrayDeque;

import ufba.mata58.scheduler.memory.Page;

public abstract class PagingAlgorithm {
	protected ArrayDeque<Page> pageList;
	
	public PagingAlgorithm() {
		pageList = new ArrayDeque<Page>();
	}
	
	protected abstract void replacePage();
}
