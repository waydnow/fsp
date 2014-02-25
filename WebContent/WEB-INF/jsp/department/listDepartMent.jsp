<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>武强县文教局审核系统-单位列表</title>
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

<script language="javascript">
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}
	function doDelete(id){
		if(confirm("是否真要删除?")){
			$.post("deleteDP.shtml?id="+id,function(data){
				if(0==data){
					alert("删除成功!");
					$("#tr"+id).remove();
				}else{
					alert("删除失败!");
				}
			});
		}
		
	}


</script>
</head>
<body>
<s:form action="listDP.shtml">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		  <td width="25%" align="left">单位管理  >> 单位列表 </td>
			<td width="5%"><img src="images/ico07.gif" width="20" height="18" /></td>
			<td width="70%">查看内容：单位名称
             <s:textfield name="department.name"></s:textfield>
			 <input name="Submit" type="submit" class="right-button02" value="查 询" /></td>
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td>
          <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				<tr>
                    <td height="20" colspan="6" align="center" bgcolor="#EEEEEE" class="tablestyle_title">单位列表</td>
                  </tr>
                  <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">单位名称</td>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">单位类型</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">负责人</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">地址</td>
                    <td width="5%" align="center" bgcolor="#EEEEEE">联系电话</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <s:iterator value="dplist" var="dp">
                  <tr align="center" id="tr${dp.id}">
                    <td height="20" bgcolor="#FFFFFF"><a href="showDP.shtml?department.id=${dp.id}"><s:property value="#dp.name"/></a></td>
                    <td bgcolor="#FFFFFF">
                    <s:if test="%{#dp.type == 'SUPPLIER'}" >
                    	供应商
                    </s:if>
                    <s:if test="%{#dp.type == 'SCHOOL'}" >
                    	学校
                    </s:if>
                    <s:if test="%{#dp.type == 'MANAGER'}" >
                    	文教局
                    </s:if>
                    </td>
                    <td bgcolor="#FFFFFF"><s:property value="#dp.manager"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#dp.address"/></td>
                    <td bgcolor="#FFFFFF"><s:property value="#dp.phone"/></td>
                    <td bgcolor="#FFFFFF"><a id="${dp.id}" href="javascript:doDelete(${dp.id});">删除</a></td>
                  </tr>
				  </s:iterator>
                  
                </table></td>
              </tr>
              <span>
	              <input name="Submit2" type="button" class="right-button08" value="添加单位" onclick="javascript:window.location='registDP.shtml';"/>
          	  </span>
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
      </table>
    </td>
  </tr>
</table>
</s:form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="images/nn.gif" />
</div>

</body>
</html>
