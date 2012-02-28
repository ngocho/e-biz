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
package ebiz.action.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.checkout.OrderBill;
import ebiz.util.CommonUtil;
/**
 * @author ThuyNT
 */
public class OrderBillMail extends Action {
    /**
     * [OrderBillMail].
     * 
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception Exception
     * @see ActionForward Struts1 Framework
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String idOrder = request.getParameter("idOrder");
                                                  
        if (idOrder != null) {
            Long id = Long.parseLong(idOrder);
                                                      
            OrderBill bill = CustomerBLO.getBillById(id);
            if (bill != null) {
                // get info
                StringBuffer msgBody = new StringBuffer();
                // design content of mail
                msgBody.append("<body background='Images/Commons/bkg_body.gif' >");
                msgBody.append("<h1>THÔNG TIN HÓA ĐƠN");
                msgBody.append("</h1>");
                msgBody.append("</body>");
                msgBody.append("<br>");
                msgBody.append("<ul>");
                msgBody.append("<li>");
                msgBody.append("Mã hóa đơn: " + bill.getId());
                msgBody.append("</li>");
                msgBody.append("<li>");
                msgBody.append("Tổng số tiền: <span style=\'color:red\'>" + bill.getSumPrice() + "</span>");
                msgBody.append("</li>");
                msgBody.append("<li>");
                msgBody.append("Thời gian giao hàng: " + CommonUtil.convertDateToString(bill.getDateShip()));
                msgBody.append("</li>");
                msgBody.append("<li>");
                msgBody.append("Vào lúc: " + bill.getNote());
                msgBody.append("</li>");
                msgBody.append("<li>");
                msgBody.append("Địa chỉ giao hàng: " + bill.getAddress());
                msgBody.append("</li>");
                msgBody.append("</ul>");
                msgBody.append("</body>");
                Properties props = new Properties();
                Session session = Session.getDefaultInstance(props, null);
                try {
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress("uit.mmt@gmail.com", "Food.com"));
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(bill.getEmail(), "User"));
                    msg.setSubject("Thông tin hóa đơn", "UTF-8");
                    msg.setContent(msgBody.toString(), "text/html");
                    Transport.send(msg);

                } catch (AddressException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }
}
