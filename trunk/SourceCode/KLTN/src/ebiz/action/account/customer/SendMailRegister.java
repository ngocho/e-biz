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
package ebiz.action.account.customer;

import org.apache.struts.action.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailRegister extends Action {//send mail thong bao dang ki thanh cong
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
    String msgBody;
//    String flag=request.getParameter("flag");
    String email=request.getParameter("email");
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);
    msgBody ="Chúc mừng bạn đã đăng kí thành công!";
    try {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("uit.mmt@gmail.com", "Food.com"));
        msg.addRecipient(Message.RecipientType.TO,
                         new InternetAddress(email, "User"));
            msg.setSubject("Dang ki thanh vien");
        msg.setText(msgBody);
        Transport.send(msg);
        

    } catch (AddressException e) {
        // ...
    } catch (MessagingException e) {
        // ...
    }
    return null;

    }
}
