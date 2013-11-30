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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="js/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript"  id="mainjs" >
 var i= 0;
 var name = "odetail-0";
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
		if (type == "add") {
			document.addOD.submit();
		} else if (type == "addAudit") {
			document.addAuditOD.submit();
		}
		
	}

	$(document).ready(function(){
		$("#del-0").attr("style","display:none");
		$.post("getdepGD.shtml?goodid="+$("#goodid-0").val(),function(data){
			  $("#price-0").text(data.price);
			  $("#dep-0").text(data.name);
			  });
		  $("#goodid-0").change(function(){
		  $.post("getdepGD.shtml?goodid="+$("#goodid-0").val(),function(data){
			  $("#price-0").text(data.price);
			  $("#dep-0").text(data.name);
			  });
		  });
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
<s:form action="addOD.shtml">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">订单管理 >> 添加订单</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

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
                  <s:iterator value="odetailList"  status="status" >
                  <tr align="center" id="odetail-0">
				   <td height="20" bgcolor="#FFFFFF">
				   <s:select list="goodsList" var="good" listValue="name"  name="odetailList[%{#status.index}].goodId" listKey="id"  id="goodid-0">
        			</s:select>
				   </td>
                   <td height="20" bgcolor="#FFFFFF"><div id="price-0"></div></td>
                   <td bgcolor="#FFFFFF" ><s:textfield name="odetailList[%{#status.index}].goodNum"  id="num-0" cssStyle="width:60px;"/>
                   		<s:select id="unit-0"  name="odetailList[%{#status.index}].goodUnit"  list="{'两','斤','公斤'}">
        				</s:select>
					</td>
					<td height="20" bgcolor="#FFFFFF"><div id="dep-0"></div></td>
					<td bgcolor="#FFFFFF"><s:textfield  name="odetailList[%{#status.index}].sendTime"  id="time-0"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
                    <td bgcolor="#FFFFFF"><s:textfield id="memo-0" name="odetailList[%{#status.index}].memo" /></td>
                    <td bgcolor="#FFFFFF"><input id="del-0" type="button" value="删除" /> </td>
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
                    <input name="add" type="button"  class="right-button08"  value="添加物品" onClick="addLine()" />
                    <input name="add" type="button"  class="right-button08"  value="保存订单" onClick="checkSubmit('add')" />
                    <input name="add" type="button"  class="right-button08"  value="保存并提交订单" onClick="checkSubmit('addAudit')" />
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