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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/jquery-1.10.0.min.js"></script>
<script language="javascript">
	function checkSubmit(){
		if($("#price").val()==""){
			alert("请输入单价名称!");
			return false;
			}
		if($("#name").val()==""){
			alert("请输入物品名称!");
			return false;
			}
		document.updateGD.submit();
		}
</script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">商品管理  >> 商品编辑</td>
				</tr>
			</table>
			</td>
		</tr>
	</table></td>
 </tr>
  <tr>
    <td bgcolor="#4AA3D8"></td>
  </tr>
  <tr>
    <td>
	<s:form action="updateGD.shtml">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="31%" height="35" class="login-text02">名称：</td>
        <td width="69%"><s:textfield name="goods.name" id="name"/></td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">供应商：</td>
        <td width="69%">
        <s:select name="goods.deptId" list="depList" listValue="name" listKey="id">
		</s:select>
		</td>
      </tr>
      
      <tr>
        <td height="35" class="login-text02">单价：</td>
        <td>
        	<s:textfield name="goods.price" id="price"/>&nbsp;元
        </td>
      </tr>
      <tr>
        <td height="35" class="login-text02">单位：</td>
        <td>
        <s:select name="goods.unit"  list="{'两','斤','公斤','袋'}">
        </s:select>
        </td>
      </tr>
      <tr>
        <td height="35" class="login-text02">规格：</td>
        <td width="69%"><s:textfield name="goods.standard" id="standard"/>
        </td>
      </tr>
      <tr>
        <td height="35" class="login-text02">厂家品牌：</td>
        <td width="69%"><s:textfield name="goods.factory" id="factory"/>
        </td>
      </tr>
      <tr>
        <td width="31%" height="35" class="login-text02">备注：</td>
        <td width="69%"><s:textfield name="goods.memo" id="memo"/></td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td><input type="button" value="保存" class="right-button02" onclick="checkSubmit();"/>
        &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" class="right-button02"  value="重置"/></td>
      </tr>
	</table>
    </s:form>
	</td>
  </tr>
</table>

</body>
</html>