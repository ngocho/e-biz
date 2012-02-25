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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ThuyNT
 */
public class Pankuzu {
    List<HashMap<String, String>> pankuzuList = new ArrayList<HashMap<String, String>>();

    public void setLink(String id, String value) {
        HashMap<String, String> link = new HashMap<String, String>();
        link.put(id, value);
        pankuzuList.add(link);
    }
    /**
     * Remove link pankuzu when click pankuzu
     * 
     * @param id
     */
    public void removePankuzu(String id) {
        int index;
        // xac dinh vi tri index
        index = getIndex(id);
        if (index != (-1)) {
            // remove tu vi tri index --> cuoi
            for (int i = index; i < pankuzuList.size(); i++) {
                pankuzuList.remove(i);
            }
        }
    }
    /**
     * Remove pankuzu when clik button back
     * 
     * @param id
     */
    public void removeLink(String id) {

        pankuzuList.remove(pankuzuList.size() - 1);

    }
    /**
     * click nut back cua trinh duyet
     * 
     * @param id ??
     */
    // public void removeBack(String id) {
    //
    // pankuzuList.remove(pankuzuList.size() - 1);
    //
    // }

    public HashMap<String, String> getLink(String id) {
        for (HashMap<String, String> link : pankuzuList) {
            if (link.containsKey(id)) {
                return link;
            }
        }
        return null;

    }
    public int getIndex(String id) {
        for (int i = 0; i < pankuzuList.size(); i++) {
            if (pankuzuList.get(i).containsKey(id)) {
                return i;
            }
        }
        return -1;
    }

}
