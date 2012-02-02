/**
 * Licensed to Open-Ones Group under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Open-Ones Group licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ebiz.form;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
/**
 * @author ThuyNT
 *
 */
public class ProviderVO implements Serializable{
    
    /**  . */
    private static final long serialVersionUID = 1L;
    private List<ProviderStatus> fStatusList ;
    private List<PFoodName> fNameList ;
    
    public ProviderVO() {
    	
    	//initialize ProviderStatus
    	fStatusList = new ArrayList<ProviderStatus>();
    	ProviderStatus status = new ProviderStatus();
    	status.setId("0");
    	status.setDisplay("Tất cả");
    	ProviderStatus status1 = new ProviderStatus();
    	status1.setId("1");
    	status1.setDisplay("Sản phẩm khuyến mãi");
    	ProviderStatus status2 = new ProviderStatus();
    	status2.setId("2");
    	status2.setDisplay("Sản phẩm không khuyến mãi");
    	ProviderStatus status3 = new ProviderStatus();
    	status3.setId("3");
    	status3.setDisplay("Sản phẩm đã hết ");
    	ProviderStatus status4 = new ProviderStatus();
    	status4.setId("4");
    	status4.setDisplay("Sản phẩm chưa bán");
    	
    	//add to list
    	fStatusList.add(status);
    	fStatusList.add(status1);
    	fStatusList.add(status2);
    	fStatusList.add(status3);
    	fStatusList.add(status4);
    	
    	//initialize PFoodName
    	fNameList = new ArrayList<PFoodName>();
    	PFoodName food = new PFoodName();
    	food.setId("foodName");
    	food.setDisplay("Tên");
    	PFoodName food1= new PFoodName();
    	food1.setId("price");
    	food1.setDisplay("Giá ");
    	PFoodName food2= new PFoodName();
    	food2.setId("uploadDate");
    	food2.setDisplay("Thời gian");
    	
    	fNameList.add(food);
    	fNameList.add(food1);
    	fNameList.add(food2);
    	
	}

	public List<ProviderStatus> getfStatusList() {
		return fStatusList;
	}

	public void setfStatusList(List<ProviderStatus> fStatusList) {
		this.fStatusList = fStatusList;
	}

	public List<PFoodName> getfNameList() {
		return fNameList;
	}

	public void setfNameList(List<PFoodName> fNameList) {
		this.fNameList = fNameList;
	}
}
