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

package org.icefaces.samples.showcase.example.ace.buttonGroup;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;
import javax.inject.Named;

@Named(ButtonGroupBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class ButtonGroupBean implements Serializable {

    public static final String BEAN_NAME = "buttonGroup";
	public String getBeanName() { return BEAN_NAME; }

    private boolean cb1 = false;
	private boolean cb2 = false;
	private boolean cb3 = false;
	private boolean cb4 = false;
    private boolean r1 = false;
	private boolean r2 = false;
	private boolean r3 = false;
	private boolean r4 = false;
	private String checkboxDescription;
	private String radioDescription;

    public boolean isCb1() {
        return cb1;
    }

    public void setCb1(boolean cb1) {
        this.cb1 = cb1;
    }
	
    public boolean isCb2() {
        return cb2;
    }

    public void setCb2(boolean cb2) {
        this.cb2 = cb2;
    }
	
    public boolean isCb3() {
        return cb3;
    }

    public void setCb3(boolean cb3) {
        this.cb3 = cb3;
    }
	
    public boolean isCb4() {
        return cb4;
    }

    public void setCb4(boolean cb4) {
        this.cb4 = cb4;
    }
	
    public boolean isR1() {
        return r1;
    }

    public void setR1(boolean r1) {
        this.r1 = r1;
    }
	
    public boolean isR2() {
        return r2;
    }

    public void setR2(boolean r2) {
        this.r2 = r2;
    }
	
    public boolean isR3() {
        return r3;
    }

    public void setR3(boolean r3) {
        this.r3 = r3;
    }
	
    public boolean isR4() {
        return r4;
    }

    public void setR4(boolean r4) {
        this.r4 = r4;
    }
    
    public String getCheckboxDescription() {
		if (cb1) checkboxDescription = "Checkbox 1";
		else if (cb2) checkboxDescription = "Checkbox 2";
		else if (cb3) checkboxDescription = "Checkbox 3";
		else if (cb4) checkboxDescription = "Checkbox 4";
		else checkboxDescription = "None";
		return checkboxDescription;
    }
	
    public String getRadioDescription() {
		if (r1) radioDescription = "Radio 1";
		else if (r2) radioDescription = "Radio 2";
		else if (r3) radioDescription = "Radio 3";
		else if (r4) radioDescription = "Radio 4";
		else radioDescription = "None";
		return radioDescription;
    }
}
