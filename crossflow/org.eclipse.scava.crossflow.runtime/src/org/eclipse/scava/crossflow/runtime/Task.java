package org.eclipse.scava.crossflow.runtime;

import org.eclipse.scava.crossflow.runtime.utils.CrossflowLogger.SEVERITY;
import org.eclipse.scava.crossflow.runtime.utils.Result;

public abstract class Task {

	protected boolean cacheable = true;

	public abstract String getId();

	public abstract Workflow getWorkflow();

	protected BuiltinStream<Result> resultsTopic;

	public void log(SEVERITY level, String message) {
		getWorkflow().logger.log(level, message, getClass().getName());
	}

	public void setResultsTopic(BuiltinStream<Result> resultsTopic) {
		this.resultsTopic = resultsTopic;
	}

	public BuiltinStream<Result> getResultsTopic() {
		return resultsTopic;
	}

	public void sendToResultsTopic(Result res) throws Exception {
		getResultsTopic().send(res);
	}

	public boolean isCacheable() {
		return cacheable;
	}

	public void setCacheable(boolean cacheable) {
		this.cacheable = cacheable;
	}

	/**
	 * Gets called upon workflow termination -- implementers of task should
	 * override this if they have any termination code to run
	 */
	public void close() {
		// implement any termination-specific functionality here
	};

	/**
	 * Call this within consumeXYZ() to denote task blocked due to some reason
	 * 
	 * @param reason
	 */
	protected void taskBlocked(String reason) throws Exception {
		getWorkflow().setTaskBlocked(this, reason);
	}

	/**
	 * Call this within consumeXYZ() to denote task is now unblocked
	 * 
	 * @param reason
	 */
	protected void taskUnblocked() throws Exception {
		getWorkflow().setTaskUnblocked(this);
	}
}
