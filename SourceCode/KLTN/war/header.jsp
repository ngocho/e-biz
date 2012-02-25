<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="header">
  <div class="header-row1" >
    <ul class="super-links"  id="customer_super_links" style="margin-right:400px;">
      <li><span style='color:black;' ><bean:message key="home.header.language" /></span>
<c:if test="${language =='vi'}">
<select name="language" onchange="setLocation(this.value)">
<option value="/changeLanguage.vn?lang=vi">
<bean:message key="home.header.option1" />
</option>
<option value="/changeLanguage.vn?lang=en" >
<bean:message key="home.header.option2" />
</option>
</select>
</c:if>
<c:if test="${language =='en'}">
<select name="language" onchange="setLocation(this.value)">
<option value="/changeLanguage.vn?lang=en" selected="selected">
<bean:message key="home.header.option2" />
</option>
<option value="/changeLanguage.vn?lang=vi" >
<bean:message key="home.header.option1" />
</option>
</select>
</c:if>
<%-- <c:if test="${language == null}">
<select name="language" onchange="setLocation(this.value)">
<option value="/changeLanguage.vn?lang=vi" selected="selected">
<bean:message key="home.header.option1" />
</option>
<option value="/changeLanguage.vn?lang=en" >
<bean:message key="home.header.option2" />
</option>
</select>
</c:if> --%>
</li>
</ul>
 </div>
 <div class="header-row2" id="headerNav">
                
<div class="nav-container" id="headerHome">
    <ul id="nav" style="width:738px;" >
        <li class="level0 nav-1 level-top first parent">
        <a
          href="home.vn"
          class="level-top">
<img src="Images/Commons/icon-trang-chu.png" width="20" height="20" style="margin-left:-70px;" /><span style="margin-left:10px;margin-top:-10px;" class="nav-text"> <bean:message key="home.name" /></span>
        </a>
<a
          href="category.vn?typeProduct=1"
          class="level-top">

<span class="nav-text"><bean:message key="home.nav.menu1" /></span>
        </a>
        <a
          href="category.vn?typeProduct=2"
          class="level-top">

<span class="nav-text"><bean:message key="home.nav.menu2" /></span>
        </a>
</li>
  <li class="level0 nav-4 level-top first parent">
<a
          href="category.vn?typeProduct=3"
          class="level-top">

<span class="nav-text"><bean:message key="home.nav.menu3" /></span>
        </a>
        </li>
          <li class="level0 nav-4 level-top first parent">
<a
          href="category.vn?typeProduct=4"
          class="level-top">

<span class="nav-text"><bean:message key="home.nav.menu4" /></span>
        </a>

 <li class="level0 nav-2 level-top parent">
<a
          href="provider.vn"
          class="level-top">
<span class="nav-text"><bean:message key="home.nav.menu5" /></span>
        </a>

</li> 
  <c:if test="${user !=null}">
    <li class="level0 nav-2 level-top parent">
<a         href="customer.vn"
            class="level-top">
<span class="nav-text"><bean:message key="home.nav.menu6" /></span>
        </a>
</li>
</c:if>

</ul>
</div>
 <html:form action="/search.vn" method="GET">
<fieldset class="form-search">
    <legend>Search Site</legend>
   <p>
   <html:text property="searchText" size="32" value="Nhập tên thức ăn" onfocus="this.value='' ;" styleClass="input-text input-reset inactive" />
            <html:hidden property="type" value="0"/>
             <html:hidden property="attr" value="0"/>
              <html:hidden property="price" value="0"/>
               <html:hidden property="status" value="0"/>

    <input src="Images/Commons/btn_go.png" alt="Tìm kiếm" class="btn"
            type="image" onclick ="" />
        </p>
</fieldset>
</html:form>
            </div>
      </div>
