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
<script type="text/javascript">
$(document).ready(function(){
	$("#school").hide();
	if ($("#dtype").val()=='SUPPLIER') {
		$("#school").show();
	}
	$("#dtype").change(function(){
		var type = $("#dtype").val();
		if(type=='SUPPLIER'){
			$("#school").show();
		}else{
			$("#school").hide();
		}
		
	});
});

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
					<td width="21" align="left">单位管理 >> 查看单位</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
  </tr>
  <tr>
    <td>
	
<s:form action="editDP.shtml">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
        <td width="31%" height="35" class="login-text02">单位名称：</td>
        <td width="69%"><s:property value="department.name"/></td>
      </tr>
      <tr>
      <td width="31%" height="35" class="login-text02">单位类型：</td>
        <td width="69%"><s:select list="mapType" name="department.type" id="dtype" disabled="true"></s:select></td>
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
      <tr id="school">
      	<td width="31%" height="35" class="login-text02">供应学校：</td>
        <td width="69%">
        	<s:iterator value="schools" var="s">
        	${s.name}
        	</s:iterator>
        </td>
      </tr>
      <tr>
        <td height="35"> &nbsp;
        </td>
        <td>
			<input name="Submit2" type="button" class="right-button02" value="修改" onclick="javascript:window.location='editDP.shtml?department.id=${department.id}';"/>&nbsp;
			<input name="Submit2" type="button" class="right-button02" value="返回" onclick="javascript:history.go(-1);"/>
        </td>
      </tr>
    </table>
    <s:hidden name="department.openDepts" id="openDeptIds"/>
    </s:form>
	</td>
  </tr>
</table>

</body>
</html>