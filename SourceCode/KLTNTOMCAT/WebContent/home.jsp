<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<tiles:insert definition="baseLayout" flush="true">
  <tiles:put name="title" value="Home" />
  <tiles:put name="header" value="/header.jsp" />
  <tiles:put name="content" value="/content.jsp" />
  <tiles:put name="footer" value="/footer.jsp" />
  <tiles:put name="right" value="/right.jsp" />
  <tiles:put name="left" value="/left.jsp" />
  <tiles:put name="pankuzu" value="/pankuzu.jsp" />
</tiles:insert>