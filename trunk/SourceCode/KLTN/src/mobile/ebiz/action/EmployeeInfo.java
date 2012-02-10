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
package mobile.ebiz.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobile.ebiz.blo.MobileBLO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import ebiz.action.BaseAction;
import employee.ebiz.blo.EmployeeBLO;
import employee.ebiz.dto.Employee;

/**
 * @author nthanhphong
 */
public class EmployeeInfo extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		List<JSONObject> objList = new ArrayList<JSONObject>();

		// call function get thong tin khuyen mai

		try {

			objList = MobileBLO.createEmployeeInfo();
			out = response.getWriter();
			out.println(objList);
			out.flush();
		} catch (JSONException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return mapping.findForward(null);

	}

	/**
	 * 
	 * @param content
	 *            (username@password)
	 * @return 1: successful; -1: username not exist; 0: password not correct
	 */
	public int login(String content) {
		String[] list = content.split("@");
		return EmployeeBLO.isLoginID(list[0], list[1]);
	}

	/**
	 * 
	 * @param content
	 *            (username@password@fullname@email@phone@address@birthday)
	 * @return true: successful; fasle: not successful
	 */
	public boolean update(String content) {
		try {
			String[] list = content.split("@");
			Employee employee = EmployeeBLO.getEmployeeByID(list[0]);
			if (null != employee
					&& employee.getEmployeePassword().equals(list[1])) {
				employee.setEmployeeFullname(list[2]);
				employee.setEmployeeMail(list[3]);
				employee.setEmployeePhone(list[4]);
				employee.setEmployeeAddress(list[5]);
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				employee.setEmployeeBirth(formatter.parse(list[6]));
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param content
	 *            (username@oldpassword@newpassword)
	 * @return true: change successful; false: not successful
	 */
	public boolean changepass(String content) {
		String[] list = content.split("@");
		if (EmployeeBLO.isLoginID(list[0], list[1]) == 1) {
			Employee employee = EmployeeBLO.getEmployeeByID(list[0]);
			employee.setEmployeePassword(list[2]);
			EmployeeBLO.updateEmployee(employee);
			return true;
		} else {
			return false;
		}
	}
}
