package org.eclipse.scava.crossflow.tests;

import org.apache.activemq.broker.BrokerService;
import org.eclipse.scava.crossflow.runtime.Workflow;

public class WorkflowTests {
	
	protected BrokerService brokerService;
	
	public void waitFor(Workflow workflow) throws Exception {
		while (!workflow.hasTerminated()) {
			Thread.sleep(100);
		}
	}
	
	protected void startBroker() throws Exception {
		
		if (brokerService != null) {
			stopBroker();
		}
		
		brokerService = new BrokerService();
		brokerService.setUseJmx(true);
		brokerService.addConnector("tcp://localhost:61616");
		brokerService.start();
	}
	
	protected void stopBroker() throws Exception {
		if (brokerService != null) {
			brokerService.deleteAllMessages();
			brokerService.stopGracefully("", "", 1000, 1000);
			brokerService = null;
		}
	}
	
}
