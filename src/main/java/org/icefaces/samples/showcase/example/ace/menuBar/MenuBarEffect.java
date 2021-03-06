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

package org.icefaces.samples.showcase.example.ace.menuBar;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;

@Named(MenuBarEffect.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class MenuBarEffect implements Serializable {
    public static final String BEAN_NAME = "menuBarEffect";
	public String getBeanName() { return BEAN_NAME; }
    public static final String DEFAULT_EFFECT = "Slide";
    
    private LinkedHashMap <String, String> availableEffects;
    private String effectName;
    private int effectDuration;
    private int showDelay;
    private int hideDelay;
    
    public MenuBarEffect() {
        availableEffects = populateAvailableEffects();
        effectName = availableEffects.get(DEFAULT_EFFECT);
        effectDuration = 400;
        this.showDelay=400;
        this.hideDelay=400;
    }
    
    private LinkedHashMap<String, String> populateAvailableEffects()
    {
        LinkedHashMap <String, String> list = new LinkedHashMap <String, String>();
        list.put("Slide","slide");
        list.put("Fade", "fade");
        return list;
    }
    
    public LinkedHashMap<String, String> getAvailableEffects() {return availableEffects;}
    public String getEffectName() { return effectName; }
    public int getEffectDuration() { return effectDuration; }
    
    public void setEffectName(String effectName) { this.effectName = effectName; }
    public void setEffectDuration(int effectDuration) { this.effectDuration = effectDuration; }

    public int getShowDelay() {
        return showDelay;
    }

    public void setShowDelay(int showDelay) {
        this.showDelay = showDelay;
    }

    public int getHideDelay() {
        return hideDelay;
    }

    public void setHideDelay(int hideDelay) {
        this.hideDelay = hideDelay;
    }
}
