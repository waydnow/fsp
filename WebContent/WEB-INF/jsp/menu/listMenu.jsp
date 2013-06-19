<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(images/left.gif);
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language="JavaScript">
function tupian(idt){
    var nametu="xiaotu"+idt;
    var tp = document.getElementById(nametu);
    tp.src="images/ico05.gif";
	
	for(var i=1;i<30;i++)
	{
	  
	  var nametu2="xiaotu"+i;
	  if(i!=idt*1)
	  {
	    var tp2=document.getElementById('xiaotu'+i);
		if(tp2!=undefined)
	    {tp2.src="images/ico06.gif";}
	  }
	}
}

function list(idstr){
	var name1="subtree"+idstr;
	var name2="img"+idstr;
	var objectobj=document.all(name1);
	var imgobj=document.all(name2);
	
	if(objectobj.style.display=="none"){
		for(i=1;i<10;i++){
			var name3="img"+i;
			var name="subtree"+i;
			var o=document.all(name);
			if(o!=undefined){
				o.style.display="none";
				var image=document.all(name3);
				//alert(image);
				image.src="images/ico04.gif";
			}
		}
		objectobj.style.display="";
		imgobj.src="images/ico03.gif";
	}
	else{
		objectobj.style.display="none";
		imgobj.src="images/ico04.gif";
	}
}

</SCRIPT>

<body>
<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
<s:form action="listMenu.shtml" >
	<tr>
		<TD>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="207" height="55" background="images/nav01.gif">
						<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
							  <tr>
									<td width="25%" rowspan="2"><img src="images/ico02.gif" width="35" height="35" /></td>
									<td width="75%" height="22" class="left-font01">hello！<span class="left-font02">${user.name}</span></td>
							  </tr>
							  <tr>
									<td height="22" class="left-font01">[&nbsp;<a href="logoutUA.shtml" target="_top" class="left-font01">退出</a>&nbsp;]</td>
							</tr>
						</table>
						</td>
				</tr>
			</table>
		<s:iterator value="menuList" var="mu">
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
          <tr>
            <td height="29">
				<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%"><img name="img${mu.id}" id="img${mu.id}'" src="images/ico04.gif" width="8" height="11" /></td>
						<td width="92%"><a href="javascript:" target="mainFrame" class="left-font03" onClick="list('${mu.id}');"><s:property value="#mu.name"/></a></td>
					</tr>
				</table>
			</td>
			</tr>
			<tr>
			<td>
				<table id="subtree${mu.id}" style="DISPLAY: none" width="80%" border="0" align="center" cellpadding="0" 
				cellspacing="0" class="left-table02">
				<s:set value="menuMap[#mu.id]" var="subList"/>
				<s:iterator value="subList" var="submu">
				<tr>
				  <td width="9%" height="20" ><img id="xiaotu${submu.id}" src="images/ico06.gif" width="8" height="12" /></td>
				  <td width="91%"><a href="${submu.link}" target="mainFrame" class="left-font03" onClick="tupian('${submu.id}');">${submu.name}</a></td>
				</tr>
				</s:iterator>	  
     			</table>
			</td>
          </tr>	
        </TABLE>
        </s:iterator>
        
	  </TD>
  </tr>
</s:form>
</table>
</body>
</html>