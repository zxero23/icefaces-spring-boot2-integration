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

package org.icefaces.samples.showcase.example.ace.chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;

import org.icefaces.ace.model.chart.SectorSeries;

@Named(ChartPieBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class ChartPieBean implements Serializable
{
    public static final String BEAN_NAME = "chartPieBean";
	public String getBeanName() { return BEAN_NAME; }
    
    private List<SectorSeries> pieData = new ArrayList<SectorSeries>() {{
        add(new SectorSeries() {{
            add("Heavy Industry", 12);
            add("Retail", 9);
            add("Light Industry", 14);
            add("Out of Home", 16);
            add("Commuting", 7);
            add("Orientation", 9);
            setShowDataLabels(true);
            setDataLabelFormatString("%.2f%%") ;
            setSliceMargin(4);
            setFill(false);
        }});
    }};
    
    public List<SectorSeries> getPieData() {
        return pieData;
    }

    public void setPieData(List<SectorSeries> pieData) {
        this.pieData = pieData;
    }
}
