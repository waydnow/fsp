<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统-添加用户</title>
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
		if($("#loginName").val()==""){
			alert("请输入用户名!");
			return false;
			}
		if($("#pwd").val()==""){
			alert("请输入密码!");
			return false;
			}
		document.addUA.submit();
		}
</script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">系统管理>>添加用户</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
    
  </tr>
  <tr>
 	<td><s:actionmessage/></td>
    <td>
	<s:form action="addUA.shtml">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
        <td width="31%" height="35" class="login-text02">单位：</td>
        <td width="69%">
        	<s:select list="dps" var="department" listValue="name" listKey="id" name="user.deptId">
        	</s:select>
			<a href="registDP.shtml">添加新单位</a>
        </td>
        </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">用户名：</td>
        <td width="69%"><s:textfield name="user.loginName" id="loginName"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密码：</td>
        <td><s:password name="user.pwd" id="pwd"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">确认密码：</td>
        <td><s:password name="user.pwd" id="pwd"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">用户角色：</td>
        <td width="69%">
			<s:select name="roleids" list="roleList"  var="role" listKey="id" listValue="name" multiple="false"></s:select>
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
        <td width="69%"><s:textfield name="user.name" id="name"/></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input type="button" value="注册" class="right-button02" onclick="checkSubmit();"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" class="right-button02"  value="重置"/>
        </td>
      </tr>
    </table>
    </s:form>
	</td>
  </tr>
</table>

</body>
</html>