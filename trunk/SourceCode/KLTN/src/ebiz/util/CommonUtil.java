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
package ebiz.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ThuyNT
 */
public class CommonUtil {
    /**
     * [isBlankOrNull].
     * 
     * @param s String
     * @return boolean
     */
    public static boolean isBlankOrNull(String s) {
        if (s == null || s == "") {
            return true;
        }
        return false;
    }
    /**
     * [isBlankOrNull].
     * 
     * @param s String
     * @return boolean
     */
    public static boolean isBlank(Long s) {
        if (s == null) {
            return true;
        }
        return false;
    }
    public static boolean isBlankOrZero(Long l) {
        if (l == null || l.equals(0) || l == 0) {
            return true;
        }
        return false;
    }

    // public static boolean isBlankOrZero(int l) {
    // if (l == null || l.equals(0) || l == 0) {
    // return true;
    // }
    // return false;
    // }
    /**
     * [nullToBlank].
     * 
     * @param s String
     * @return String
     */
    public static String nullToBlank(String s) {
        if (s == null) {
            s = "";
        }
        return s;
    }
    /**
     * [isNull].
     * 
     * @param obj Object
     * @return boolean
     */
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }
    /**
     * [convertDateToString].
     * 
     * @param date Date
     * @return String
     */
    public static String convertDateToString(Date date) {
        SimpleDateFormat dateformatYYYYMMDD = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder nowYYYYMMDD = new StringBuilder(dateformatYYYYMMDD.format(date));
        return nowYYYYMMDD.toString();
    }
    /**
     * [convertStringToDate].
     * 
     * @param strDate String
     * @return Date
     */
    public static Date convertStringToDate(String strDate) {
        System.out.println("DATE" + strDate);
        if (strDate != null) {
            Date date;
            try {
                DateFormat formatter;
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                date = (Date) formatter.parse(strDate);
                System.out.println("Today is " + date);
            } catch (ParseException e) {
                System.out.println("Exception :" + e);
                return null;
            }
            return date;
        }
        return null;
    }
    /**
     * [formatDate].
     * 
     * @param date Date
     * @return String
     */
    public static String formatDate(Date date) {
        SimpleDateFormat dateformatYYYYMMDD = new SimpleDateFormat("dd/MM/yyyy");
        return dateformatYYYYMMDD.format(date);
    }
    /**
     * [formatDateToDate].
     * 
     * @param date Date
     * @return Date
     */
    public static Date formatDateToDate(Date date) {
        SimpleDateFormat dateformatYYYYMMDD = new SimpleDateFormat("dd/MM/yyyy");
        String sDate = dateformatYYYYMMDD.format(date).toString();
        return convertStringToDate(sDate);
    }
    /**
     * [shortString].
     * 
     * @param s String
     * @param len int
     * @return String
     */
    public static String shortString(String s, int len) {
        if (s != null && s.length() >= len) {
            return s.substring(0, len);
        }
        return s;
    }
    /**
     * [equalDateFormat].
     * 
     * @param date1 Date
     * @param date2 Date
     * @return boolean
     */
    public static boolean equalDateFormat(Date date1, Date date2) {
        if (formatDate(date1).equals(formatDate(date2))) {
            return true;
        }
        return false;

    }

    // validate
    public static boolean checkNumeric(String value) {
        System.out.println("value checkNummeric" + value);
        // long result;
        try {
            Long.parseLong(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
