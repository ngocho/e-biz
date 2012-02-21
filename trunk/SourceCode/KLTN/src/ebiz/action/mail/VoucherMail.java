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
import ebiz.dto.checkout.VoucherBill;

/**
 * @author Administrator
 *
 */
public class VoucherMail extends Action {
	private static final Logger log = Logger.getLogger(SendMailRegister.class.getName());
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
     String idVoucher = request.getParameter("idVoucher");
     if(idVoucher != null){
    	 Long id = Long.parseLong(idVoucher);
    	 VoucherBill voucher = CustomerBLO.getVoucherByID(id);
    	 Properties props = new Properties();
         Session session = Session.getDefaultInstance(props, null);
         try {
        	 StringBuffer msgBody = new StringBuffer();
        	 msgBody.append("Mã voucher : " + voucher.getKeyVoucher());
        	 msgBody.append("</br>");
        	 msgBody.append("Voucher chỉ có giá trị 3 ngày kể từ ngày mua " + voucher.getStartDate() );
        	 MimeMessage msg = new MimeMessage(session);
             msg.setFrom(new InternetAddress("uit.mmt@gmail.com", "Food.com"));
             msg.addRecipient(Message.RecipientType.TO, new InternetAddress(voucher.getEmail(), "Customer"));
             msg.setSubject("Thông tin Voucher","UTF-8");
             msg.setContent(msgBody.toString(), "text/html");
             log.info("send Voucher info");
             Transport.send(msg);
             log.info("send Voucher info OK");

         } catch (AddressException e) {
             e.printStackTrace();
         } catch (MessagingException e) {
             e.printStackTrace();
         }

     }
    	return null;
    }

}
