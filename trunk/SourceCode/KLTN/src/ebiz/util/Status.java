/**
 * Status.java
 * 
 * @version 1.0
 *
 * Mar 5, 2012
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
 *  3:11:28 PM   DanhDTC.     Initial.
 *
 */
package ebiz.util;

/**
 * This class is used for Status.
 * @author DanhDTC
 *
 */
public enum Status {
    /**
     * Hết hàng.
     */
    UNAVAILABLE,
    /**
     * Đang khuyến mãi.
     * In promotion.
     */
    PROMOTION,
    /**
     * Còn hàng, giá bán vẫn bình thường.
     */
    NORMAL,
    /**
     * Hết hạn sử dụng.
     * Out of date.
     */
    EXPIRED,
    /**
     * Khác.
     * Đang bổ sung thông tin.
     */
    OTHERS
   
}
