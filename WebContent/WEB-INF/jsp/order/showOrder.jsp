<%@page import="java.util.List"%>
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
 var index = <% out.print(((List) request.getAttribute("odetailList")).size()); %>;
 var i= index-1;
 var name = "odetail-"+i;
 	function checkSubmit(type){
		for(var j=0;j<=i;j++){
			var obj = $("#odetail-"+j);
			if(obj!=null){
				if($("#num-"+j).val()==0){
					alert("采购物品数量不能为0!");
					return;
				}
				if($("#time-"+j).val()==""){
					alert("送货时间不能为空!");
					return;
				}
			}
		}
		if (type == 'update') {
			$("#showOrder").submit();
		} else if (type == 'audit') {
			$("#showOrder").attr("action","auditOD.shtml");
			$("#showOrder").submit();
		} else if (type == 'updateAudit') {
			document.updateAuditOD.submit();
		} else if (type == 'auditNoPass') {
			$("#showOrder").attr("action","auditNoPassOD.shtml");
			$("#showOrder").submit();
		} else if (type == 'auditPass') {
			$("#showOrder").attr("action","auditPassOD.shtml");
			$("#showOrder").submit();
		}
	}
	
	$(document).ready(function(){
		$("#del-0").attr("style","display:none");
		var length = 1;
		function post(idx){
			$.ajax({
				type:"POST",
				url:"getdepGD.shtml",
				data:"goodid="+$("#goodid-"+idx).val(),
				timeout:5000,
				success:function(data){
					$("#price-"+idx).text(data.price);
					$("#dep-"+idx).text(data.name);
					if(length<index){
						post(length);
						length++;
					}
				}
			});
		};
		
		$.ajax({
			type:"POST",
			url:"getdepGD.shtml",
			data:"goodid="+$("#goodid-0").val(),
			timeout:5000,
			success:function(data){
				$("#price-0").text(data.price);
				$("#dep-0").text(data.name);
				if(length<index){
					post(length);
					length++;
				}
			}
		});
		
		for ( var l = 0; l < index; l++) {
			var js = '$("#goodid-'+l+'").change(function(){'+
			  '$.post("getdepGD.shtml?goodid="+$("#goodid-'+l+'").val(),function(data){'+
				 ' $("#price-'+l+'").text(data.price);'+
				  '$("#dep-'+l+'").text(data.name);'+
				  '});'+
			  '});'+
			  '';
			$("<scri"+"pt>"+js+"</scr"+"ipt>").attr({id:'jschangepost'+l,type:'text/javascript'}).insertAfter($("#mainjs"));
		}
		  
	});

	function addLine(){
		$("#odetail-0").clone().insertBefore($("#odetail-last"));
		i++;
		name = "odetail-"+i;
        $("tbody #odetail-0").last().attr("id",name);
        $("#"+name+" #goodid-0").attr("id","goodid-"+i);
        $("#goodid-"+i).attr("name","odetailList["+i+"].goodId");
        $("#"+name+" #price-0").attr("id","price-"+i);
        $("#"+name+" #dep-0").attr("id","dep-"+i);
        $("#"+name+" #del-0").attr("id","del-"+i);
        $("#"+name+" #num-0").attr("id","num-"+i);
        $("#num-"+i).attr("name","odetailList["+i+"].goodNum");
        $("#num-"+i).val("");
        $("#"+name+" #unit-0").attr("id","unit-"+i);
        $("#unit-"+i).attr("name","odetailList["+i+"].goodUnit");
        $("#"+name+" #time-0").attr("id","time-"+i);
        $("#time-"+i).attr("name","odetailList["+i+"].sendTime");
        $("#time-"+i).val("");
        $("#"+name+" #memo-0").attr("id","memo-"+i);
        $("#memo-"+i).attr("name","odetailList["+i+"].memo");
        $("#memo-"+i).val("");
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
<s:form action="updateOD.shtml" id="showOrder">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table id="subtree1" width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" >
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					 <tr>
                    <td height="20" colspan="7" align="center" bgcolor="#EEEEEE" class="tablestyle_title">订单明细</td>
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
                  <s:iterator value="odetailList"  status="status">
                  <tr align="center" id="odetail-<s:property value='#status.index'/>">
				   <td height="20" bgcolor="#FFFFFF">
				   <s:select list="goodsList" var="good" listValue="name"  name="odetailList[%{#status.index}].goodId" listKey="id"  id="goodid-%{#status.index}">
        			</s:select>
				   </td>
                   <td height="20" bgcolor="#FFFFFF"><div id="price-<s:property value='#status.index'/>"></div></td>
                   <td bgcolor="#FFFFFF" ><s:textfield name="odetailList[%{#status.index}].goodNum"  id="num-%{#status.index}" cssStyle="width:60px;"/>
                   		<s:select id="unit-%{#status.index}"  name="odetailList[%{#status.index}].goodUnit"  list="{'两','斤','公斤'}">
        				</s:select>
					</td>
					<td height="20" bgcolor="#FFFFFF"><div id="dep-<s:property value='#status.index'/>"></div></td>
					<td bgcolor="#FFFFFF">
					<s:textfield name="odetailList[%{#status.index}].sendTime"  id="time-%{#status.index}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
					</s:textfield>
					</td>
                    <td bgcolor="#FFFFFF"><s:textfield id="memo-%{#status.index}" name="odetailList[%{#status.index}].memo" /></td>
                    <td bgcolor="#FFFFFF"><input id="del-<s:property value='#status.index'/>" type="button" value="删除" /> </td>
                  </tr>
				  </s:iterator>
             	<tr align="center" id="odetail-last"></tr>
                </table></td>
              </tr>
              <tr>
              <td height="60"  width="10%" align="center"  class="newfont02">订单备注：<s:textarea  name="order.memo" />  </td>
          	 </tr>
              <tr>
               <td height="60"  width="50%"  align="center">
              	 <span class="newfont07" >
              	 	<s:if test = "%{(order.status == 0||order.status == 3)&&roleList}">
              	 	<input name="add" type="button"  class="right-button08"  value="添加物品" onClick="addLine()" />
              	 	<input name="add" type="button"  class="right-button08"  value="更新订单" onClick="checkSubmit('update')" />
              	 	<input name="add" type="button"  class="right-button08"  value="提交订单" onClick="checkSubmit('audit')" />
                    <input name="add" type="button"  class="right-button08"  value="保存并提交订单" onClick="checkSubmit('updateAudit')" />
              	 	</s:if>
              	 	<s:if test = "%{order.status == 1}">
                    <input name="add" type="button"  class="right-button08"  value="审核通过" onClick="checkSubmit('auditPass')" />
              	 	<input name="add" type="button"  class="right-button08"  value="审核不通过" onClick="checkSubmit('auditNoPass')" />
              	 	</s:if>
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