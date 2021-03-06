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

package org.icefaces.samples.showcase.example.ace.slider;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;
import javax.faces.event.ValueChangeEvent;

import org.icefaces.samples.showcase.dataGenerators.ImageSet;
import org.icefaces.samples.showcase.dataGenerators.ImageSet.ImageInfo;

@Named(SliderListener.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class SliderListener implements Serializable {
    public static final String BEAN_NAME = "sliderListener";
	public String getBeanName() { return BEAN_NAME; }
    private int sliderValue;
    private ImageInfo image;

    public SliderListener() {
        initializeInstanceVariables();
    }
    
    private void initializeInstanceVariables()
    {
        this.sliderValue = 0;
        this.image = ImageSet.getImage(ImageSet.ImageSelect.LIGHTBULB_OFF);
    }
    
    public void handleSwitch(ValueChangeEvent e)
    {
        if((Integer)e.getNewValue() == 0)
            this.image = ImageSet.getImage(ImageSet.ImageSelect.LIGHTBULB_OFF);
        else
            this.image = ImageSet.getImage(ImageSet.ImageSelect.LIGHTBULB_ON);
    }

    public int getSliderValue() {
        return sliderValue;
    }

    public void setSliderValue(int sliderValue) {
        this.sliderValue = sliderValue;
    }

    public ImageInfo getImage() {
        return image;
    }

    public void setImage(ImageInfo image) {
        this.image = image;
    }
}