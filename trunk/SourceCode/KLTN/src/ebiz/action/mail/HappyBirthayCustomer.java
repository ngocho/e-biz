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

import org.apache.struts.action.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.blo.customer.CustomerBLO;
import ebiz.dto.account.customer.Customer;
import ebiz.util.CommonUtil;

import java.util.List;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author ThuyNT
 *
 */
public class HappyBirthayCustomer extends Action {
    /**
     * [HappyBirthayCustomer].
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

        // String flag=request.getParameter("flag");
        List<Customer> customerList = CustomerBLO.getCustomerList();
        for (Customer customer : customerList) {
            if (customer.getCustomerEmail() != null) {
                // birthday = current date
                if (CommonUtil.equalDateFormat(customer.getCustomerBirth(), new Date())) {
                    StringBuffer msgBody = new StringBuffer();
                    // design content of mail
                    msgBody.append("<body background='Images/Commons/bkg_body.gif' >");
                    msgBody.append("<h1>Chúc mừng sinh nhật");
                    msgBody.append(customer.getCustomerName());
                    msgBody.append("</h1>");
                    msgBody.append("</body>");
                    Properties props = new Properties();
                    Session session = Session.getDefaultInstance(props, null);
                    msgBody.append("<h1>Chúc mừng sinh nhật ");
                    msgBody.append(customer.getCustomerId());
                    msgBody.append("</h1>");
                    msgBody.append("<br>");
                    msgBody.append("<img scr=\'  \'>");
                    try {
                        MimeMessage msg = new MimeMessage(session);
                        msg.setFrom(new InternetAddress("uit.mmt@gmail.com", "Food.com"));
                        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(customer.getCustomerEmail(),
                                "User"));
                        msg.setSubject("Chúc mừng sinh nhật", "UTF-8");
                        msg.setContent(msgBody.toString(), "text/html");
                        Transport.send(msg);

                    } catch (AddressException e) {
                        e.printStackTrace();
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
        return null;
    }
}
