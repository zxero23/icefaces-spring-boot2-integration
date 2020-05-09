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

package org.icefaces.samples.showcase.example.ace.textAreaEntry;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;

@Named(TextAreaEntryCharCountBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class TextAreaEntryCharCountBean implements Serializable
{
    public static final String BEAN_NAME = "textAreaEntryCharCountBean";
	public String getBeanName() { return BEAN_NAME; }
    
	private int maxlength = 50;
	private String comment;
    
    public int getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(int maxlength) {
		this.maxlength = maxlength;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
