<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>武强县文教局审核系统-角色列表</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/xiangmu.js"></script>
<script language="javascript" src="js/jquery-1.10.0.min.js"></script>
</head>
<script language="javascript">

function addGD() {
	window.location.href = "registGD.shtml";
}

function doDelete(id){
	if(confirm("是否真要删除?")){
		$.post("deleteGD.shtml?goods.id="+id,function(data){
			if(0==data){
				alert("删除成功!");
				$("#tr"+id).remove();
			}else{
				alert("删除失败!");
			}
		});
	}
	
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
</script>

<body onload="on_load()">
<s:form action="listGD.shtml">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">商品管理  >> 商品列表</td>
				</tr>
			</table>
			</td>
		</tr>
	</table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20">
	              <input name="Submit2" type="button" class="right-button08" value="添加" onclick="addGD();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="8" align="center" bgcolor="#EEEEEE" class="tablestyle_title">物品列表</td>
                    </tr>
                  <tr>
				    <td width="5%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">物品名称</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">价格</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">规格</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">厂商品牌</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">供应商</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">备注</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <s:iterator value="goodsList" var="gd">
                  <tr align="center" id="tr${gd.id}">
				   <td bgcolor="#FFFFFF"><input type="checkbox" name="gd.id"/></td>
                    <td height="20" bgcolor="#FFFFFF"><a href="showGD.shtml?goods.id=${gd.id}"><s:property value="#gd.name"/></a></td>
                  	<td bgcolor="#FFFFFF"><s:property value="#gd.price"/>/<s:property value="#gd.unit"/></td>
					<td bgcolor="#FFFFFF"><s:property value="#gd.standard"/></td>              
                  	<td bgcolor="#FFFFFF"><s:property value="#gd.factory"/></td>
                   	<td bgcolor="#FFFFFF"><s:property value="#gd.deptName"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#gd.memo"/></td>
                    <td bgcolor="#FFFFFF"><a id="${gd.id}" href="javascript:doDelete(${gd.id});">删除</a></td>
                  </tr>
				  </s:iterator>
                  
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33">
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">${pb.totalPage}</span> 页 | 第 <span class="right-text09">${pb.curPage }</span> 页</td>
                <td width="49%" align="right">[<a href="${pb.firstUrl }" class="right-font08">首页</a> | <a href="${pb.prevUrl}" class="right-font08">上一页</a> | <a href="${pb.nextUrl}" class="right-font08">下一页</a> | <a href="${pb.lastUrl}" class="right-font08">末页</a>] </td>
                <td width="1%"></td>
              </tr>
          </table>
          </td>
        </tr>
      </table></td>
  </tr>
</table>
</s:form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="nn.gif" />
</div>

</body>
</html>
