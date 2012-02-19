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
package ebiz.blo.common;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

/**
 * @author ThuyNT
 *
 */
public class SendMail {
    private static Queue queue = QueueFactory.getDefaultQueue();
    /**
     * 
     * when register account success -> send mail
     * @param email
     */
    public static void registerSuccess(String email){

      TaskOptions url=TaskOptions.Builder.withUrl("/sendMailRegister.vn");
      url.param("email", email);
      queue.add(url);
    }
    
    public static void createOrderBill(String idOrder){

        TaskOptions url=TaskOptions.Builder.withUrl("/sendMailOrderBill.vn");
        url.param("idOrder", idOrder);
        queue.add(url);
      }

}
