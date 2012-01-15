<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<div class="col-left sidebar"><div class="block block-currency">
    <div class="block-title">
        <strong><span>Select Your Currency</span></strong>    </div>
    <div class="block-content">
        <select name="currency" title="Select Your Currency" onchange="setLocation(this.value)">
                    <option value="#" selected="selected">
                US Dollar - USD            </option>
                    <option value="#">
                 Việt Nam - VNĐ           </option>
                </select>
    </div>
</div>
<div class="block block-layered-nav">
    <div style="background:#009900" >
        <strong><span style="text-transform:uppercase">MENU</span></strong>    </div>
    <div class="block-content">
                            <p class="block-subtitle">TÙY CHỌN</p>
            <dl id="narrow-by-list">
                                                                    <dt class="odd">MÓN ĂN</dt>
                                                                    
                    <dd class="odd">
<ol>
<logic:present name="Attribute">
<logic:iterate id="element" name="Attribute">
    <li>
                <a href="#">
                <bean:write name="element"/>
                </a>
               </li>
</logic:iterate>
</logic:present>
</ol>
</dd>
                                                                    <dt class="even">GIÁ TIỀN</dt>
                    <dd class="even">
<ol>
<logic:present name="Price">
<logic:iterate id="element" name="Price">
    <li>
                <a href="#"><span class="price"><bean:write name="element" property="startPrice"/></span> - <span class="price">
<span class="price"><bean:write name="element" property="endPrice"/></span></a>
                </li>
</logic:iterate>
</logic:present > 
</ol>
</dd>
                                            </dl>
            </div>
</div>
<div class="block block-banner">
    <div class="block-content">
                    <a href="#" title="Điện thoại số">
                    <img src="resource_files/col_left_callout.jpg" alt=""> </a>            </div>
</div>
<div class="block block-tags">
</div>
</div>