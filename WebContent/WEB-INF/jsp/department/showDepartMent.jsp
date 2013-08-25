<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统-单位列表</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" >
<script language="javascript" src="js/jquery-1.10.0.min.js"></script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">系统管理>>查看单位</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
  </tr>
  <tr>
    <td>
	
	<s:form action="updateDP.shtml">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
        <td width="31%" height="35" class="login-text02">单位名称：</td>
        <td width="69%"><s:property value="department.name"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">地址：</td>
        <td><s:property value="department.address" /></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">负责人：</td>
        <td width="69%"><s:property value="department.manager"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系电话：</td>
        <td width="69%"><s:property value="department.phone"/></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td>
        <a style="text-decoration: none;" href="editDP.shtml?department.id=${department.id}">
        <input type="button" value="修改" class="right-button02" />
        </a>&nbsp;&nbsp;&nbsp;&nbsp;
        <!-- <input type="reset" class="right-button02"  value="重置"/> --></td>
      </tr>
    </table>
    </s:form>
	</td>
  </tr>
</table>

</body>
</html>