<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统-添加订单</title>
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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
var i = 0;
var b = 0;
    function addRow() {
        var root = document.getElementById("table1");

        var newRow = root.insertRow();

        var cell1 = newRow.insertCell();
        cell1.innerHTML = '<input type=checkbox name="materialDetaillist[' + i + '].id">';

        var cell2 = newRow.insertCell();
        cell2.innerHTML = '<input type=text name="materialDetaillist[' + i + '].name">';

        var cell3 = newRow.insertCell();
        cell3.innerHTML = '<input type=text name="materialDetaillist[' + i + '].unit">';

        var cell4 = newRow.insertCell();
        cell4.innerHTML = '<input type=text name="materialDetaillist[' + i + '].charge">';

        var cell5 = newRow.insertCell();
        cell5.innerHTML = '<input type=text name="materialDetaillist[' + i + '].liechtenstein">';

        var cell6 = newRow.insertCell();
        cell6.innerHTML = '<input type=text name="materialDetaillist[' + i + '].price">';

        var cell7 = newRow.insertCell();
        cell7.innerHTML = '<input type=text name="materialDetaillist[' + i + '].amount">';

        i = i + 1;
        b++;

    }
    
    function deleteLines() {

        var arr = document.getElementsByName("ch1");

        var strIds = "";
        var count = 0;
        for ( var i = 0; i < arr.length; i++) {
            if (arr[i].checked == true) {

                if (null == arr[i].value || "" == arr[i].value) {
                    document.all("tbo").deleteRow(i);
                    i = i - 1;
                } else {
                    strIds = strIds + ':' + arr[i].value;
                    count = 1;
                }
            }
        }
        if (count == 0) {
            alert('请选择要删除的行');
            return false;
        }
        var oForm = document.getElementById('materialDetailupdateform');
        oForm.action = "/contract/materialDetailDelete.do?strID=" + strIds;
        oForm.submit();
    }

    function deleteRow() {
        if (i == 1) {
            return;
        }
        var root = document.getElementById("table1");
        root.deleteRow(i);
        i = i - 1;
    }

	function checkSubmit(){
		if($("#memo").val()==""){
			alert("请输入订单描述!");
			return false;
			}
		if($("#price").val()==""){
			alert("请输入单价!");
			return false;
			}
		document.addOD.submit();
		}
</script>
</head>
<body>
<s:form action="listGDshtml">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" value="删除" />
	              <input name="add" type="button" value="添加" onClick="addRow()" /></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="13" align="center" bgcolor="#EEEEEE" class="tablestyle_title">订单列表</td>
                    </tr>
                  <tr>
				    <td width="5%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">物品</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">物品单价</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">物品数量</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">供货单位</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">送货时间</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">备注</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <s:iterator value="odetailList" id="odetail" status="status" >
                  <tr align="center">
				   <td bgcolor="#FFFFFF"><input type="checkbox" /></td>
				   <td height="20" bgcolor="#FFFFFF">
				   <s:select list="goodsList" var="good" listValue="name" listKey="id" >
        			</s:select>
				   </td>
                   <td height="20" bgcolor="#FFFFFF">XXXXX</td>
                   <td bgcolor="#FFFFFF" ><s:textfield name="odetailList[%{#status.index}].goodNum"  cssStyle="width:60px;"/><select name="odetailList[%{#status.index}].goodUnit" >
        					<option value="两">两</option>
        					<option value="斤">斤</option>
        					<option value="公斤">公斤</option>
        				</select>
					</td>
					<td height="20" bgcolor="#FFFFFF">XXXwuwuXX</td>
					<td bgcolor="#FFFFFF"><s:textfield  name="odetailList[%{#status.index}].sendTime"  id="d12"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
                    <td bgcolor="#FFFFFF"><s:textfield name="odetailList[%{#status.index}].memo" /></td>
                    <td bgcolor="#FFFFFF"><input name="del" type="button" value="删除" onClick="return deleteLines()" /> </td>
                  </tr>
				  </s:iterator>
                  
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
  </tr>
</table>
</s:form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="nn.gif" />
</div>

</body>
</html>