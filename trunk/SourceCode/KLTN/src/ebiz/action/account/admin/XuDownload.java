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
package ebiz.action.account.admin;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ebiz.action.BaseAction;

/**
 * @author ThuyNT
 */
public class XuDownload extends BaseAction {

    /**
     * [Logout(Customer)].
     *
     * @param mapping ActionMapping
     * @param form ActionForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception Exception
     * @see ActionForward Struts1 Framework
     */
    @SuppressWarnings("finally")
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

       // HttpSession se = request.getSession();
        response.setContentType("application/text");
        // response.setContentType("text/plain; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=xu.txt");
        response.setContentType("application/pdf");
        try {
            ServletOutputStream out = response.getOutputStream();
            StringBuffer sb = generateCsvFileBuffer();

            InputStream in = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));

            byte[] outputByte = new byte[4096];
            // copy binary contect to output stream
            while (in.read(outputByte, 0, 4096) != -1) {
                out.write(outputByte, 0, 4096);
            }
            in.close();
            out.flush();
            out.close();
        } finally {

            return null;
        }

    }
    /**
     * [Give the description for method].
     * @return
     */
    private static StringBuffer generateCsvFileBuffer() {
        StringBuffer writer = new StringBuffer();

        writer.append("DisplayName");
        writer.append(',');
        writer.append("Age");
        writer.append(',');
        writer.append("HandPhone");
        writer.append('\n');

        writer.append("mkyong");
        writer.append(',');
        writer.append("26");
        writer.append(',');
        writer.append("0123456789");
        writer.append('\n');

        return writer;
    }

}
