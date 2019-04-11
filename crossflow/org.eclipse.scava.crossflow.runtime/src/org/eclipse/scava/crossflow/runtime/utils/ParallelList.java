package org.eclipse.scava.crossflow.runtime.utils;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

import org.eclipse.scava.crossflow.runtime.Workflow;

public class ParallelList<E> extends LinkedList<E> {

	private Semaphore semaphore;
	private ExecutorService executor;

	public void init(Workflow w) {
		semaphore = new Semaphore(w.getParallelization());
		executor = CFThreadPoolExecutorServiceFactory.getExecutor(w.getParallelization());
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

}
