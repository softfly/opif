package pl.softfly.opif.samples.invoice.flows.jbpm.workitemhandler;

import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import pl.softfly.oipf.document.validation.scheme.DocumentValidationSchemeBean;
import pl.softfly.oipf.entity.DocumentHeader;

import java.util.HashMap;

public class DocumentValidationSchemeWorkItemHandler implements WorkItemHandler {

    DocumentValidationSchemeBean documentValidationSchemeBean = new DocumentValidationSchemeBean();

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        manager.abortWorkItem(workItem.getId());
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        DocumentHeader documentHeader = (DocumentHeader) workItem.getParameter("input1");

        documentValidationSchemeBean.valid(documentHeader);

        HashMap<String, Object> results = new HashMap<String, Object>();
        results.put("output1", documentHeader);

        manager.completeWorkItem(workItem.getId(), results);
    }

}
