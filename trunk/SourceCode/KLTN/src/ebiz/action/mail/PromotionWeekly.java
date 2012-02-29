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

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

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
import ebiz.dto.account.customer.Customer;
import ebiz.util.CommonUtil;

public class PromotionWeekly extends Action {
    /**  . */
    private static final Logger log = Logger.getLogger(SendMailRegister.class.getName());
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

        //List<FoodForm> formList = new ArrayList<FoodForm>();
       // formList = FoodBLO.getFoodListByStatus(CommonConstant.HOME_NUMBER_DEFAUL, "1");
        // get customer list
        List<Customer> customerList = CustomerBLO.getCustomerList();
        for (Customer customer : customerList) {
            if (customer.getCustomerEmail() != null) {
                // birthday = current date
                if (CommonUtil.equalDateFormat(customer.getCustomerBirth(), new Date())) {
                    StringBuffer msgBody = new StringBuffer();
                    // design content of mail
                    msgBody.append("<h1>Hiện tại trang web chúng tôi đang có các mặt hàng khuyến mãi hấp dẫn");
                    msgBody.append("</h1>");
                    msgBody.append("Vui lòng click link sau để có cơ hội mua những sản phẩm khuyến mãi");
                    msgBody.append("<br>");
                    msgBody.append("<a href=\"http://12.test-kltn1.appspot.com/\"/>FoodShop</a>");

                    Properties props = new Properties();
                    Session session = Session.getDefaultInstance(props, null);
                    try {
                        Message msg = new MimeMessage(session);
                        msg.setFrom(new InternetAddress("uit.mmt@gmail.com", "Food.com"));
                        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(customer.getCustomerEmail(),
                                "User"));
                        msg.setSubject("Sản phẩm khuyến mãi");
                        msg.setContent(msgBody.toString(), "text/html");
                        Transport.send(msg);

                    } catch (AddressException e) {
                        log.info(e.getMessage());
                    } catch (MessagingException e) {
                        log.info(e.getMessage());
                    }

                }
            }

        }
        // String msgBody;
        // // String flag=request.getParameter("flag");
        // String email = "hailam349@gmail.com";
        // Properties props = new Properties();
        // Session session = Session.getDefaultInstance(props, null);
        // msgBody = "Chúc mừng bạn đã đăng kí thành công!";
        // log.info("Send Mail Register Success");
        // try {
        // MimeMessage msg = new MimeMessage(session);
        // msg.setFrom(new InternetAddress("uit.mmt@gmail.com", "Food E-commerce.com"));
        // msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email, "User"));
        // msg.setSubject("Thông tin khuyến mãi", "UTF-8");
        // msg.setText(msgBody);
        // Transport.send(msg);
        //
        // } catch (AddressException e) {
        // // ...
        // } catch (MessagingException e) {
        // // ...
        // }
        return null;

    }
}
