package ufba.mata58.scheduler.algorithms;

import java.util.ArrayDeque;

import ufba.mata58.scheduler.memory.Page;

public abstract class PagingAlgorithm {
	protected ArrayDeque<Page> pageList;
	
	public PagingAlgorithm() {
		pageList = new ArrayDeque<Page>();
	}
	
	public ArrayDeque<Page> getPageList() {
		return pageList;
	}



	public void setPageList(ArrayDeque<Page> pageList) {
		this.pageList = pageList;
	}

	public abstract void replacePage();
}
