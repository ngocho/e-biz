/**
 * BillStatus.java
 * 
 * @version 1.0
 *
 * Mar 6, 2012
 * 
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
 * 
 * Modification Logs:
 *   DATE        AUTHOR        DESCRIPTION
 *  ------------------------------------------------------------
 *  10:48:58 AM DanhDTC .
 *
 */
package ebiz.util;

/**
 * This class is used for BillStatus.
 * @author DanhDTC
 *
 */
public enum BillType {
    /**
     * Bill unpaid, pre-checkout.
     */
    UNPAID,
    /**
     * Unpaid, checked out and will paid when delivery.
     */
    WILL_PAID_WHEN_DELIVERY,
    /**
     * Paid by Xu, hasn't delivered.
     */
    PAID_BY_XU,
    /**
     * Paid through Nganluong.vn but not delivered.
     */
    PAID_THROUGH_NGANLUONG,
    /**
     * Paid and deliverd.
     */
    DONE,
    /**
     * Must delivered today.
     */
    MUST_DELIVER_TODAY;
    
    @Override
    public String toString() {
        return this.ordinal() + "";
    }
    /**
     * Get BillType from a number defined ordinal status.
     *
     * @param status ordinal
     * @return type.
     */
    public static BillType valueOf(int status) {
        int index = 0;
        if (status == index) {
            return UNPAID;
        }
        ++index;
        if (status == index) {
            return WILL_PAID_WHEN_DELIVERY;
        }
        ++index;
        if (status == index) {
            return PAID_BY_XU;
        }
        ++index;
        if (status == index) {
            return PAID_THROUGH_NGANLUONG;
        }
        ++index;
        if (status == index) {
            return DONE;
        }
        ++index;
        if (status == index) {
            return MUST_DELIVER_TODAY;
        }
        throw new NumberFormatException("Status must between 0 and 5.");
    }
}
