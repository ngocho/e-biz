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

import ebiz.blo.provider.ProviderBLO;
import ebiz.dto.account.provider.Provider;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.logging.Logger;
/**
 * @author ThuyNT
 */
public class AuthenticationProvider extends Action {
    /** Logger. */
    private static final Logger log = Logger.getLogger(SendMailRegister.class.getName());
    /**
     * [AuthenticationProvider].
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
        String msgBody;
        // String flag=request.getParameter("flag");
        String id = request.getParameter("id");
        Provider pro = ProviderBLO.getProviderById(id);
        if (pro != null) {
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            msgBody = "Mã chứng thực :" + pro.getActiveCode();
            log.info("Send Mail Register Success");
            try {
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("uit.mmt@gmail.com", "Food E-commerce.com"));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(pro.getProviderEmail(), "User"));
                msg.setSubject("Mã chứng thực cho cửa hàng", "UTF-8");
                msg.setText(msgBody, "UTF-8");
                Transport.send(msg);

            } catch (AddressException e) {
                log.info("error AddressException");
            } catch (MessagingException e) {
                log.info("error MessagingException");
            }
        }
        return null;
    }
}
