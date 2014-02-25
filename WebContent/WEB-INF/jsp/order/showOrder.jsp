<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kanmenzhu.system.security.entity.LuRole" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统-显示订单</title>
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
			$("#showOrder").attr("action","addAudit.shtml");
			$("#showOrder").submit();
		} else if (type == 'auditNoPass') {
			$("#showOrder").attr("action","auditNoPassOD.shtml");
			$("#showOrder").submit();
		} else if (type == 'auditPass') {
			$("#showOrder").attr("action","auditPassOD.shtml");
			$("#showOrder").submit();
		}else if (type == 'auditReal') {
			$("#showOrder").attr("action","auditRealOD.shtml");
			$("#showOrder").submit();
		}else if (type == 'auditNoReal') {
			$("#showOrder").attr("action","auditNoRealOD.shtml");
			$("#showOrder").submit();
		}else if (type == 'updateReal') {
			$("#showOrder").attr("action","updateRealOD.shtml");
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
			  		$("#standard-"+idx).text(data.standard);
	  		  		$("#factory-"+idx).text(data.factory);
	  		  		$("#unit-"+idx).text(data.unit);
	  		  		var num = $("#num-"+idx).val();
			  		var price = $("#price-"+idx).text();
			  		var sum = num * price;
			  		$("#sum-"+idx).text(sum.toFixed(2));
			  		sumAll();
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
			  $("#standard-0").text(data.standard);
	  		  $("#factory-0").text(data.factory);
	  		  $("#unit-0").text(data.unit);
	  		  var num = $("#num-0").val();
			  var price = $("#price-0").text();
			  var sum = num * price;
			  $("#sum-0").text(sum.toFixed(2));
			  sumAll();

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
	  			'$("#standard-'+l+'").text(data.standard);'+
	  			'$("#factory-'+l+'").text(data.factory);'+
	  			'$("#unit-'+l+'").text(data.unit);'+
	  			' var num = $("#num-'+l+'").val();'+
				' var price = $("#price-'+l+'").text();'+
				' var sum = num * price;'+
				 ' $("#sum-'+l+'").text(sum.toFixed(2));sumAll();'+
				  '});'+
			  '});'+
			  '';
			  js = js +  '$("#del-'+l+'").click(function(){'+
				  'var did = $("#del-'+l+'").attr("odid");'+
				  'if(confirm("确认删除详单？")){'+
					'$.post("delDetailOD.shtml?detailId="+did,function(data){'+
						'if(0==data){'+
						'$("#odetail-'+l+'").remove();'+
						'alert("删除成功!");'+
					'	}else{'+
					'		alert("删除失败!");'+
					'	}'+
				    '});'+
				  '}'+
		   	   ' });';
		   	js = js + '$("#num-'+i+'").change(function(){'+
			' var num = $("#num-'+i+'").val();'+
			' var price = $("#price-'+i+'").text();'+
			' var sum = num * price;'+
			 ' $("#sum-'+i+'").text(sum.toFixed(2));sumAll();'+
			  '});';
     	
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
        $("#"+name+" #sum-0").attr("id","sum-"+i);
        $("#sum-"+i).text("");
        $("#unit-"+i).attr("name","odetailList["+i+"].goodUnit");
        $("#num-"+i).attr("name","odetailList["+i+"].goodNum");
        $("#num-"+i).val("");
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
			  $("#standard"+i).text(data.standard);
	  		  $("#factory"+i).text(data.factory);
	  		  $("#unit"+i).text(data.unit);
			  });
		var js = '$("#goodid-'+i+'").change(function(){'+
	  		  '$.post("getdepGD.shtml?goodid="+$("#goodid-'+i+'").val(),function(data){'+
	  			 ' $("#price-'+i+'").text(data.price);'+
	  			  '$("#dep-'+i+'").text(data.name);'+
	  			'$("#standard-'+i+'").text(data.standard);'+
	  			'$("#factory-'+i+'").text(data.factory);'+
	  			'$("#unit-'+i+'").text(data.unit);'+
	  			' var num = $("#num-'+i+'").val();'+
				' var price = $("#price-'+i+'").text();'+
				' var sum = num * price;'+
				 ' $("#sum-'+i+'").text(sum.toFixed(2));sumAll();'+
	  			  '});'+
	  		  '});'+
	  		  '';
		$("<scri"+"pt>"+js+"</scr"+"ipt>").attr({id:'js'+i,type:'text/javascript'}).insertAfter($("#mainjs"));
      
		var change = '$("#num-'+i+'").change(function(){'+
			' var num = $("#num-'+i+'").val();'+
			' var price = $("#price-'+i+'").text();'+
			' var sum = num * price;'+
			 ' $("#sum-'+i+'").text(sum.toFixed(2));sumAll();'+
			  '});';
		$("<scri"+"pt>"+change+"</scr"+"ipt>").attr({id:'change'+i,type:'text/javascript'}).insertAfter($("#mainjs"));
     	 $("#del-"+i).click(function(){
     		 alert("删除="+i);
     	 	$(this).closest("td").closest("tr").remove();
     	 	sumAll();
  	    });
    }//end addLine()
	function sumAll(){
		var total=0;
		$("div[id^='sum-']").each(function(i){  
		    if($(this).text()!=""){
		    	total=total+parseFloat($(this).text());
		    }
		  });  
		$("#divTotal").text("总金额:"+total.toFixed(2)+"元      ");
	}
</script>
</head>
<body>
<s:form action="updateOD.shtml" id="showOrder">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">订单管理  >> 订单详情</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
  </tr>
  <tr>
    <td><table id="subtree1" width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" >
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					 <tr>
                    <td height="20" colspan="12" align="center" bgcolor="#EEEEEE" class="tablestyle_title">订单明细</td>
                    </tr>
                  <tr>
                    <td width="10%" height="20" align="center" bgcolor="#EEEEEE">物品</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">物品数量</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">厂家名称</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">规格</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">单价(元)</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">单位</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">供货单位</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">送货时间</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">总价金额(元)</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">备注</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <s:iterator value="odetailList" var="detail"  status="status">
                  <tr align="center" id="odetail-<s:property value='#status.index'/>">
				   <td height="20" bgcolor="#FFFFFF">
					<s:select list="goodsList" var="good" listValue="name"  name="odetailList[%{#status.index}].goodId" listKey="id"  id="goodid-%{#status.index}"> </s:select>
				   </td>
                   <td bgcolor="#FFFFFF" ><s:textfield name="odetailList[%{#status.index}].goodNum"  id="num-%{#status.index}" cssStyle="width:40px;"/>
					</td>
					<td height="20" bgcolor="#FFFFFF"><div id="factory-<s:property value='#status.index'/>"></div></td>
					<td height="20" bgcolor="#FFFFFF"><div id="standard-<s:property value='#status.index'/>"></div></td>
					<td height="20" bgcolor="#FFFFFF"><div id="price-<s:property value='#status.index'/>"></div></td>
					<td height="20" bgcolor="#FFFFFF"><font id="unit-<s:property value='#status.index'/>"></font></td>
					<td height="20" bgcolor="#FFFFFF"><div id="dep-<s:property value='#status.index'/>"></div></td>
					<td bgcolor="#FFFFFF">
					<s:textfield name="odetailList[%{#status.index}].sendTime"   id="time-%{#status.index}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
						<s:param name="value"><s:text name="odetailList[%{#status.index}].send"/></s:param>
					</s:textfield>
					</td>
					<td height="20" bgcolor="#FFFFFF"><div id="sum-<s:property value='#status.index'/>"></div></td>
                    <td bgcolor="#FFFFFF"><s:textfield id="memo-%{#status.index}" name="odetailList[%{#status.index}].memo" /></td>
                    <td bgcolor="#FFFFFF"><a id="del-<s:property value='#status.index'/>"
						odid='<s:text name="odetailList[%{#status.index}].id"/>'>
                    	删除</a> </td>
                  </tr>
				  </s:iterator>
             	<tr align="center" id="odetail-last"></tr>
                </table></td>
              </tr>
              <tr>
              <td height="60"  width="10%" align="center"  class="newfont02">
              <font id="divTotal"></font>&nbsp;&nbsp;&nbsp;
              	学校： <s:select name="order.deptId" list="depList" listValue="name" listKey="id" disabled="true">
			 </s:select>&nbsp;&nbsp;&nbsp;
              	订单备注：<s:textarea  name="order.memo" />  </td>
          	 </tr>
              <tr>
               <td height="60"  width="50%"  align="center">
              	 <span class="newfont07" >
              	 <s:if test="%{roleList!=null}">
              	 <s:iterator value="roleList" var="role">
              		 <s:if test="#role.type=='MANAGER'">
	              	 	<s:if test = "%{order.status == 1}">
	                    <input name="add" type="button"  class="right-button08"  value="审核通过" onClick="checkSubmit('auditPass')" />
	              	 	<input name="add" type="button"  class="right-button08"  value="审核不通过" onClick="checkSubmit('auditNoPass')" />
	              	 	</s:if>
              	 	</s:if>
              	 	<s:if test="#role.type=='SCHOOL'">
              	 		<s:if test = "%{order.status == 0||order.status == 3}">
	              	 	<input name="add" type="button"  class="right-button08"  value="添加物品" onClick="addLine()" />
	              	 	<input name="add" type="button"  class="right-button08"  value="更新订单" onClick="checkSubmit('update')" />
	              	 	<input name="add" type="button"  class="right-button08"  value="提交订单" onClick="checkSubmit('audit')" />
	                    <input name="add" type="button"  class="right-button08"  value="保存并提交订单" onClick="checkSubmit('updateAudit')" />
	              	 	</s:if>
	              	 	<s:if test = "%{order.status ==4}">
	              	 	<input name="add" type="button" class="right-button08" title="供货订单正确，进行确认"  value="确认供货订单" onClick="checkSubmit('auditReal')" />
	              	 	<input name="add" type="button" class="right-button08" title="供货订单不正确，返回供应商修改"  value="返回供应商" onClick="checkSubmit('auditNoReal')" />
	              	 	</s:if>
              	 	</s:if>
              	 	<s:if test="#role.type=='SUPPLIER'">
              	 		<s:if test = "%{order.status == 2}">
	              	 	<input name="add" type="button"  class="right-button08"  value="添加物品" onClick="addLine()" />
	              	 	<input name="add" type="button"  class="right-button08"  value="保存供应订单" onClick="checkSubmit('updateReal')" />
	              	 	</s:if>
              	 	</s:if>
              	 </s:iterator>
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