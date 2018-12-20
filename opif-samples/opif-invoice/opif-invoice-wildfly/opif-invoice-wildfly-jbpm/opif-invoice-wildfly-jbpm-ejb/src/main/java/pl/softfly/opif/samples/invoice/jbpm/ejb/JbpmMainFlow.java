package pl.softfly.opif.samples.invoice.jbpm.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;

@Startup
@javax.ejb.Singleton
@LocalBean
public class JbpmMainFlow {

	@Inject
	//@Singleton
	private RuntimeManager singletonManager;

	@PostConstruct
	public void startProcess() {
		RuntimeEngine runtime = singletonManager.getRuntimeEngine(null);
		KieSession ksession = runtime.getKieSession();
		ProcessInstance processInstance = ksession.startProcess("pl.softfly.opif.samples.invoice.process.jbpm.MainFlow");
		singletonManager.disposeRuntimeEngine(runtime);
	}

}
