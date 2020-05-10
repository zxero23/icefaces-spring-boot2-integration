 /*
 * Copyright 2004-2014 ICEsoft Technologies Canada Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS
 * IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.icefaces.samples.showcase.example.ace.tooltip; 

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;

import org.icefaces.samples.showcase.util.FacesUtils;
import org.icefaces.ace.component.tooltip.Tooltip;

@Named(RequestScopedDelegateTooltipBean.BEAN_NAME)
@RequestScoped
public class RequestScopedDelegateTooltipBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String BEAN_NAME = "requestScopedDelegateTooltipBean";
	public String getBeanName() { return BEAN_NAME; }
	
	private Tooltip tooltip;
	
	public RequestScopedDelegateTooltipBean() { }

	public Tooltip getTooltip() {
		return tooltip;
	}
	
	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

    @ManagedProperty(value="#{delegateTooltipBean}")
    private DelegateTooltipBean delegateTooltipBean;

	public DelegateTooltipBean getDelegateTooltipBean() {
		return delegateTooltipBean;
	}

	public void setDelegateTooltipBean(DelegateTooltipBean delegateTooltipBean) {
		this.delegateTooltipBean = delegateTooltipBean;
	}
     
    public void listener(org.icefaces.ace.event.TooltipDelegateDisplayEvent event) {
       	
    	int index = extractIndex();
    	
    	if(getDelegateTooltipBean().isCancelListener() != false) {        	
    		if (index % 2 == 0){
    			//odd rows    				
    			event.cancelDisplay();    		
    		}
        	else {
        		//even rows
        		//do nothing      		
        	}
    	}    	        
    }

	private int extractIndex() {
		//extract 'form:tooltip_activeComponent' request parameter, which has the client id of the component that triggered the tooltip
    	String reqParam = FacesUtils.getRequestParameter(tooltip.getClientId()+"_activeComponent");
    	
    	//expected format is 'form:carTable:7:carName'   	
		// and for portlets it's '_delegateTooltip_WAR_showcaseportlet_:form:carTable:7:carName'
    	int startIndex = reqParam.indexOf("form:carTable:") + "form:carTable:".length();    	
    	int endIndex = reqParam.lastIndexOf(":");	  	
    	int index = 0;
    	
    	try {    		
    		index = Integer.parseInt(reqParam.substring(startIndex, endIndex).trim());   		  
        } catch (NumberFormatException nfe) {
        	System.out.println("NumberFormatException: " + nfe.getMessage());
        }   	
		return index;
	}
    
}
