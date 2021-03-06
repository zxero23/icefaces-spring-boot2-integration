
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

package org.icefaces.samples.showcase.example.ace.dragDrop;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.DragDropEvent;
import org.icefaces.samples.showcase.dataGenerators.ImageSet;
import org.icefaces.samples.showcase.dataGenerators.ImageSet.ImageInfo;

@Named(DataTableIntegrationBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class DataTableIntegrationBean implements Serializable
{
   public static final String BEAN_NAME = "dataTableIntegrationBean";
	public String getBeanName() { return BEAN_NAME; }
   
   private List<DragDropItem> availableItems;
   private List<DragDropItem> purchasedItems;
   
   public DataTableIntegrationBean()
   {
       initializeData();
   }
    
   private void initializeData()
   {
        availableItems = new ArrayList<DragDropItem>();
        double basePrice = 140;
        double price;
        DecimalFormat doubleFormater = new DecimalFormat("#.##");
        ArrayList<ImageInfo> gadgetImages = ImageSet.getImages(ImageSet.ImagesSelect.GADGETS);
        for(int i = 0; i<gadgetImages.size(); i++)
        {
            DragDropItem item = new DragDropItem(gadgetImages.get(i));
            item.setId(i);
            item.setQuantity(1);
            item.setType("electronic device");
            price = (0.33+basePrice+(i+1)*basePrice/2);
            item.setPrice(Double.valueOf(doubleFormater.format(price+price*0.05)));
            availableItems.add(item);
        }
         purchasedItems = new ArrayList<DragDropItem>();
    }
   
   
   public void handleDrop(DragDropEvent e)
   {
       DragDropItem item = (DragDropItem)e.getData();
       purchasedItems.add(item);
       availableItems.remove(item);
   }
   
   public void resetShoppingCart(ActionEvent e)
   {
       initializeData();
   }

    public List<DragDropItem> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<DragDropItem> availableItems) {
        this.availableItems = availableItems;
    }

    public List<DragDropItem> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(List<DragDropItem> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }
}
