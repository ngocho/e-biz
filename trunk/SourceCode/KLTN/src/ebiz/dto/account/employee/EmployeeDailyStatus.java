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
package ebiz.dto.account.employee;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class EmployeeDailyStatus {
    private Long id;
    private String idEmployee;
    private Date date;
    //status of daily work of employee
    private int status;
    private boolean isAssign;
    private int numberJob;
    /**
     * Get value of id.
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the value for id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get value of idEmployee.
     * @return the idEmployee
     */
    public String getIdEmployee() {
        return idEmployee;
    }
    /**
     * Set the value for idEmployee.
     * @param idEmployee the idEmployee to set
     */
    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }
    /**
     * Get value of date.
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    /**
     * Set the value for date.
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * Get value of status.
     * @return the status
     */
    public int getStatus() {
        return status;
    }
    /**
     * Set the value for status.
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    /**
     * Get value of isAssign.
     * @return the isAssign
     */
    public boolean isAssign() {
        return isAssign;
    }
    /**
     * Set the value for isAssign.
     * @param isAssign the isAssign to set
     */
    public void setAssign(boolean isAssign) {
        this.isAssign = isAssign;
    }
    /**
     * Get value of numberJob.
     * @return the numberJob
     */
    public int getNumberJob() {
        return numberJob;
    }
    /**
     * Set the value for numberJob.
     * @param numberJob the numberJob to set
     */
    public void setNumberJob(int numberJob) {
        this.numberJob = numberJob;
    }
    

}
