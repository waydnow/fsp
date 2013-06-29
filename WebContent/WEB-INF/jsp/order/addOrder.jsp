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
<script language="javascript" type="text/javascript"  id="mainjs" >
 var i= 0;
 var name = "odetail";
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
	
	$(document).ready(function(){
		$("#del").attr("style","display:none");
		$.post("getdepGD.shtml?goodid="+$("#goodid").val(),function(data){
			  $("#price").text(data.price);
			  $("#dep").text(data.name);
			  });
		  $("#goodid").change(function(){
		  $.post("getdepGD.shtml?goodid="+$("#goodid").val(),function(data){
			  $("#price").text(data.price);
			  $("#dep").text(data.name);
			  });
		  });
		});
	

	function addLine(){
		$("#odetail").clone().insertAfter($("#"+name));
		i++;
		name = "odetail-"+i;
        $("#odetail:last-child").attr("id",name);
        $("#"+name+" #goodid").attr("id","goodid-"+i);
        $("#"+name+" #price").attr("id","price-"+i);
        $("#"+name+" #dep").attr("id","dep-"+i);
        $("#"+name+" #del").attr("id","del-"+i);
        $("#"+name+" #num").attr("id","num-"+i);
        $("#num-"+i).attr("name","odetailList["+i+"].goodNum");
        $("#"+name+" #unit").attr("id","unit-"+i);
        $("#unit-"+i).attr("name","odetailList["+i+"].goodUnit");
        $("#"+name+" #time").attr("id","time-"+i);
        $("#time-"+i).attr("name","odetailList["+i+"].sendTime");
        $("#del-"+i).removeAttr("style");
			
		$.post("getdepGD.shtml?goodid="+$("#goodid-"+i).val(),function(data){
			  $("#price-"+i).text(data.price);
			  $("#dep-"+i).text(data.name);
			  });
		var js = '$("#goodid-'+i+'").change(function(){'+
	  		  '$.post("getdepGD.shtml?goodid="+$("#goodid-'+i+'").val(),function(data){'+
	  			 ' $("#price-'+i+'").text(data.price);'+
	  			  '$("#dep-'+i+'").text(data.name);'+
	  			  '});'+
	  		  '});'+
	  		  '';
		$("<scri"+"pt>"+js+"</scr"+"ipt>").attr({id:'js'+i,type:'text/javascript'}).insertAfter($("#mainjs"));
      
     	 $("#del-"+i).click(function(){
     	 	$(this).closest("td").closest("tr").remove();
  	    });
    }//end addLine()

</script>
</head>
<body>
<s:form action="listGDshtml">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" id="odtable">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					 <tr>
                    <td height="20" colspan="7" align="center" bgcolor="#EEEEEE" class="tablestyle_title">订单列表</td>
                    </tr>
                  <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">物品</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">物品单价</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">物品数量</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">供货单位</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">送货时间</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">备注</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <s:iterator value="odetailList"  status="status" >
                  <tr align="center" id="odetail">
				   <td height="20" bgcolor="#FFFFFF">
				   <s:select list="goodsList" var="good" listValue="name" listKey="id"  id="goodid">
        			</s:select>
				   </td>
                   <td height="20" bgcolor="#FFFFFF"><div id="price"></div></td>
                   <td bgcolor="#FFFFFF" ><s:textfield name="odetailList[%{#status.index}].goodNum"  id="num" cssStyle="width:60px;"/><select id="unit" name="odetailList[%{#status.index}].goodUnit" >
        					<option value="两">两</option>
        					<option value="斤">斤</option>
        					<option value="公斤">公斤</option>
        				</select>
					</td>
					<td height="20" bgcolor="#FFFFFF"><div id="dep"></div></td>
					<td bgcolor="#FFFFFF"><s:textfield  name="odetailList[%{#status.index}].sendTime"  id="time"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
                    <td bgcolor="#FFFFFF"><s:textfield id="memo" name="odetailList[%{#status.index}].memo" /></td>
                    <td bgcolor="#FFFFFF"><input id="del" type="button" value="删除" /> </td>
                  </tr>
				  </s:iterator>
             
                </table></td>
              </tr>
              <tr>
               <td height="60"  width="50%"  align="center">
              	 <span class="newfont07" >
                    <input name="add" type="button"  class="right-button08"  value="添加" onClick="addLine()" />
                    <input name="add" type="button"  class="right-button08"  value="保存" onClick="add()" />
                    </span>
                </td>
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