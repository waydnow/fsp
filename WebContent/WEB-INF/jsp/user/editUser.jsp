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
<script language="javascript" src="js/jquery-1.10.0.min.js"></script>
<script language="javascript">
	function checkSubmit(){
		if($("#name").val()==""){
			alert("请输入单位名称!");
			return false;
			}
		if($("#manager").val()==""){
			alert("请输入负责人!");
			return false;
			}
		document.updateUA.submit();
		}
</script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td bgcolor="#4AA3D8"></td>
  </tr>
  <tr>
    <td>
	<s:form action="updateUA.shtml">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
        <td width="31%" height="35" class="login-text02">单位<br /></td>
        <td width="69%">
        	<s:property value="user.depName"/>
        </td>
        </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">用户名<br /></td>
        <td width="69%"><s:property value="user.loginName"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密码<br /></td>
        <td><s:password name="user.pwd" id="pwd"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">确认密码<br /></td>
        <td><s:password name="user.pwd" id="pwd"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">用户角色<br /></td>
        <td width="69%">
        	<s:property value="user.role"/> 
		</td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系电话<br /></td>
        <td width="69%"><s:textfield name="user.phone" id="phone"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">手机<br /></td>
        <td width="69%"><s:textfield name="user.mobile" id="mobile"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系邮箱<br /></td>
        <td width="69%"><s:textfield name="user.email" id="email"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系人<br /></td>
        <td width="69%"><s:textfield name="user.name" id="name" /></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input type="button" value="保存" class="right-button02" onclick="checkSubmit();"/></td>
      </tr>
    </table>
    </s:form>
	</td>
  </tr>
</table>

</body>
</html>