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

/**
 * @author ThuyNT
 */
public class Paging implements Serializable {

    /** . */
    private static final long serialVersionUID = 1L;
    private int id;
    private String cursorString;
    /**
     * Get value of id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value for id.
     * 
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Get value of cursorString.
     * 
     * @return the cursorString
     */
    public String getCursorString() {
        return cursorString;
    }
    /**
     * Set the value for cursorString.
     * 
     * @param cursorString the cursorString to set
     */
    public void setCursorString(String cursorString) {
        this.cursorString = cursorString;
    }

}
