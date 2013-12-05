<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kanmenzhu.system.security.entity.LuRole" %>
<%@page import="com.kanmenzhu.fsp.entity.LuOrder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统-导出订单</title>
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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
	function exportList(){
		$("#exportXls").attr("action","exportListOD.shtml");
		
		$("#exportXls").submit();
	}  
	function showXls(){
		$("#exportXls").attr("action","showXlsOD.shtml");
		$("#exportXls").submit();
	}
</script>
<%
Map mapStatus = new HashMap();
mapStatus.put(LuOrder.UNSUBMIT_ADUIT,"未提交订单");
mapStatus.put(LuOrder.ADUIT_ING,"审核中订单");
mapStatus.put(LuOrder.ADUIT_SUCCESS,"审核通过订单");
mapStatus.put(LuOrder.ADUIT_FAIL,"审核失败订单");
mapStatus.put(LuOrder.ADUIT_END,"供应商提供订单");
mapStatus.put(LuOrder.ADUIT_REAL,"最终订单");
request.setAttribute("mapStatus",mapStatus);
%>
</head>
<body>
<s:form action="exportListOD.shtml" id="exportXls">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">订单管理 >> 导出订单</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</tr>
  <tr>
    <td>
    <table id="subtree1" width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
          <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" >
			<tr>
			 <td width="2%"><img src="images/ico07.gif" width="20" height="18" /></td>
			 <td>导出订单  ： </td>
			 <td>学校：<s:select name="depId" list="depList" headerKey="" headerValue="全部" listValue="name" listKey="id">
			 </s:select>
			 </td>
			 <td>开始日期:<s:textfield name="beginTime" readonly="true" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
			 <td>结束日期:<s:textfield name="endTime" readonly="true" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
			 <td>订单状态:
			 <s:select name="status" list="#request.mapStatus" headerKey="" headerValue="全部"  >
			 </s:select>
			 </td>
			</tr>
          </table>
          </td>
       </tr>
         <tr>
           <td height="60"  width="50%"  align="center">
          	 <span class="newfont07" >
               <input type="button" name="search" class="right-button08" value="查询" onClick="showXls();" />
               <input type="button" name="export" class="right-button08" value="导出订单" onClick="exportList();" />
             </span>
           </td>
         </tr>
     </table>
     <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" >
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					 <tr>
                    <td height="20" colspan="6" align="center" bgcolor="#EEEEEE" class="tablestyle_title">订单明细</td>
                    </tr>
                  <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">物品</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">物品单价</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">物品数量</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">供货单位</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">送货时间</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">备注</td>
                  </tr>
                  <s:iterator value="odetailList" var="detail"  status="status">
                  <tr align="center">
				   <td height="20" bgcolor="#FFFFFF">
					<s:text name="odetailList[%{#status.index}].goodName"/>
				   </td>
                   <td height="20" bgcolor="#FFFFFF"><s:text name="odetailList[%{#status.index}].price"/></td>
                   <td bgcolor="#FFFFFF" ><s:text name="odetailList[%{#status.index}].goodNum"/>
                   	<s:text name="odetailList[%{#status.index}].goodUnit"/>
					</td>
					<td height="20" bgcolor="#FFFFFF"><s:text name="odetailList[%{#status.index}].depName"/></td>
					<td bgcolor="#FFFFFF">
					<s:text name="odetailList[%{#status.index}].send" />
					</td>
                    <td bgcolor="#FFFFFF"><s:text name="odetailList[%{#status.index}].memo" /></td>
                  </tr>
				  </s:iterator>
                </table>
     </td>
  </tr>
</table>
</s:form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="nn.gif" />
</div>

</body>
</html>