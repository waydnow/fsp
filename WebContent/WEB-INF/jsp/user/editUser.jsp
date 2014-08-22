<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统-添加单位</title>
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
<script language="javascript">
function checkSubmit(){
	//if($("#pwd").val()==""){
	//	alert("请输入密码!");
	//	return false;
	//}
	//if($("#pwdcopy").val()==""){
	//	alert("请输入确认密码!");
	//	return false;
	//}
	if ($("#pwdcopy").val()!=$("#pwd").val()) {
		alert("密码与确认密码不一致!");
		return false;
	}
	document.updateUA.submit();
}
</script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">用户列表>>用户修改</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</td>
  </tr>
  <tr>
    <td>
    <font color="red"><s:actionmessage/></font>
	<s:form action="updateUA.shtml">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
        <td width="31%" height="35" class="login-text02">单位：</td>
        <td width="69%">
        &nbsp;<s:property value="user.depName"/>
        </td>
        </tr>
      <tr>
      <s:hidden name="user.loginName"></s:hidden>
        <td width="31%" height="35" class="login-text02">用户名：</td>
        <td width="69%">&nbsp;<b><s:property value="user.loginName"/></b></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密码：</td>
        <td><s:password name="user.pwd" id="pwd"/> 注:不修改密码，不需要填写</td>
      </tr>
      <tr>
        <td height="35" class="login-text02">确认密码：</td>
        <td><s:password name="user.pwdCopy" id="pwdcopy"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">用户角色：</td>
        <td width="69%">
        	&nbsp;<s:property value="user.role"/> 
		</td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系电话：</td>
        <td width="69%"><s:textfield name="user.phone" id="phone"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">手机：</td>
        <td width="69%"><s:textfield name="user.mobile" id="mobile"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系邮箱：</td>
        <td width="69%"><s:textfield name="user.email" id="email"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系人：</td>
        <td width="69%"><s:textfield name="user.name" id="name" /></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input type="button" value="保存" class="right-button02" onclick="checkSubmit();"/>
        <input name="Submit2" type="button" class="right-button02" value="返回" onclick="javascript:history.go(-1);"/>
        </td>
      </tr>
    </table>
    </s:form>
	</td>
  </tr>
</table>

</body>
</html>