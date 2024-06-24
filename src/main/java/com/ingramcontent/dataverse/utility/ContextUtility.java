package com.ingramcontent.dataverse.utility;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.kie.api.runtime.process.ProcessContext;
import org.kie.api.runtime.process.WorkflowProcessInstance;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class ContextUtility implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    public ContextUtility() {
    }

	public static Object getProcessVariable(ProcessContext context, String variable) {
		WorkflowProcessInstance instance = (WorkflowProcessInstance) context.getProcessInstance();
		return instance.getVariable(variable);		
	}
	
	public static void setProcessVariable(ProcessContext context, String variable, Object obj) {
		WorkflowProcessInstance instance = (WorkflowProcessInstance) context.getProcessInstance();
		instance.setVariable(variable, obj);
	}	
	
	public static long getInstanceId(ProcessContext context) {
		return context.getProcessInstance().getId();
	}

    public static void initializeMetadata(ProcessContext context, JSONArray jsonArray)  {
		
		if (jsonArray == null || jsonArray.size() == 0) {
			return;
		}
		
	    Iterator<JSONObject> i = jsonArray.iterator();
 
	    // take each value from the json array separately
	    while (i.hasNext()) {
	        JSONObject jsonObject = i.next();
	        updateVariable(context, jsonObject);
	    }
	}
	
    private static void updateVariable(ProcessContext context, JSONObject jsonObject)  {
    	
    	if(jsonObject == null) {
    		return;
    	}
    	
    	String key = (String)jsonObject.get(Constant.PARAMETER_NAME);
    	String value = (String)jsonObject.get(Constant.PARAMETER_VALUE);
    	
    	switch (key) {
			case Constant.PRODUCER_URL:
				setProcessVariable(context, Constant.PRODUCER_URL, value);
			break;
			case Constant.XFORMER_URL:
				setProcessVariable(context, Constant.XFORMER_URL, value);
			break;
			case Constant.CONSUMER_URL:
				setProcessVariable(context, Constant.CONSUMER_URL, value);
			break;
		}
    	
    }
}