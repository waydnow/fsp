<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.kanmenzhu.system.security.entity.LuRole" %>
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

	$(document).ready(function(){
		$("#school").hide();
		$("#dtype").change(function(){
			var type = $("#dtype").val();
			if(type=='SUPPLIER'){
				$("#school").show();
			}else{
				$("#school").hide();
			}
			
		});
		$("#checksAll").change(function(){
			var cf=$("#checksAll").prop("checked");
			$('input[name="listSchool"]').each(function(){
				$(this).prop("checked",cf);
			});
		});
	});
	
	function checkSubmit(){
		if($("#name").val()==""){
			alert("请输入单位名称!");
			return false;
			}
		if($("#manager").val()==""){
			alert("请输入负责人!");
			return false;
		}
		getSelectDepts();
		document.addDP.submit();
	}
	
	function getSelectDepts(){
		var checkIds="";
		$('input[name="listSchool"]:checked').each(function(){
			checkIds=checkIds+$(this).val()+",";
		});
		$("#openDeptIds").val(checkIds);
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
					<td width="21" align="left">单位管理 >> 添加单位</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
  </tr>
  <tr>
    <td>
	
	<s:form action="addDP.shtml">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">单位名称：</td>
        <td width="69%"><s:textfield name="department.name" id="name"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">单位类型：</td>
        <td width="69%">
      	<s:select list="mapType" name="department.type" id="dtype"></s:select>
        </td>
      </tr>
      <tr>
        <td height="35" class="login-text02">地址：</td>
        <td><s:textfield name="department.address" id="address"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">负责人：</td>
        <td width="69%"><s:textfield name="department.manager" id="manager"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">联系电话：</td>
        <td width="69%"><s:textfield name="department.phone" id="phone"/></td>
      </tr>
      <tr id="school">
      	<td width="31%" height="35" class="login-text02">供应学校：</td>
        <td width="69%">
        	<input type="checkbox" id="checksAll" />全选<br/>
        	<s:iterator value="schools" var="s" >
        	<input type="checkbox" name="listSchool" value="${s.id}"/>${s.name}
        	</s:iterator>
        </td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input type="button" value="保存" class="right-button02" onclick="checkSubmit();"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" class="right-button02"  value="重置"/></td>
      </tr>
    </table>
    <s:hidden name="department.openDepts" id="openDeptIds"/>
    </s:form>
	</td>
  </tr>
</table>

</body>
</html>