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
<script language="javascript" src="js/jquery-1.10.0.min.js"></script>
<script language="javascript">
	var isGetImgCode =  false;
	$(document).ready(function(){
	   $("#rndImgCode").hide();
		//点击时，切换图片
		$("#getImgCode").click(function(){
			isGetImgCode = true;
			$("#rndImgCode").show();
			$("#rndImgCode").attr("src","randImage.shtml?rnd="+Math.random());
			});//click end
		$("#imgCode").focus(function(){
			if(isGetImgCode){
				return null;
				}
			isGetImgCode = true;
			$("#rndImgCode").show();
			$("#rndImgCode").attr("src","randImage.shtml?rnd="+Math.random());
			});//focus end
		});//ready end
	function checkSubmit(){
		if($("#loginName").val()==""){
			alert("请输入用户名!");
			return false;
			}
		if($("#pwd").val()==""){
			alert("请输入密码!");
			return false;
			}
		if($("#imgCode").val()==""){
			alert("请输入验证码!");
			return false;
			}
		document.addUA.submit();
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
	
	<s:form action="loginUA">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">用户名<br /></td>
        <td width="69%"><s:textfield name="loginName" id="loginName"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">密码<br /></td>
        <td><s:password name="pwd" id="pwd"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系电话<br /></td>
        <td width="69%"><s:textfield name="loginName" id="phone"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">手机<br /></td>
        <td width="69%"><s:textfield name="loginName" id="mobile"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系邮箱<br /></td>
        <td width="69%"><s:textfield name="loginName" id="email"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系人<br /></td>
        <td width="69%"><s:textfield name="loginName" id="name"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">验证码<br /></td>
        <td><s:textfield name="verifyCode" id="imgCode" maxlength="4" onkeypress="if (window.event.keyCode == 13) checkSubmit();" cssStyle="width:60px;"></s:textfield>
		          <img id="rndImgCode" title="验证码"/><a href="#"  id="getImgCode" class="login-text02">刷新验证码</a></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input type="button" value="保存" class="right-button02" onclick="checkSubmit();"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" class="right-button02"  value="重置"/></td>
      </tr>
    </table>
    </s:form>
	
	
	</td>
  </tr>
</table>

</body>
</html>