<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统-添加角色</title>
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
			alert("请输入角色名称!");
			return false;
			}
		document.addRO.submit();
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
	
	<s:form action="addRO.shtml">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">名称<br /></td>
        <td width="69%"><s:textfield name="good.name" id="name"/></td>
      </tr>
      <tr>
        <td height="35" class="login-text02">单价<br /></td>
        <td>
        	<s:textfield name="good.price" id="price"/>
        	<select name="good.unit" >
        		<option value="两">两</option>
        		<option value="斤">斤</option>
        		<option value="公斤">公斤</option>
        	</select>
        </td>
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
</html