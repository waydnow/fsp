<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>武强县文教局审核系统-登录</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.divColumn
{
         float: left;
         width: 24%;
         display:block;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/ztree/zTreeStyle.css" type="text/css">
<script language="javascript" src="js/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/ztree/jquery.ztree.excheck-3.5.js"></script>
<script language="javascript">

var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
	
var zNodes =[
 			{ id:1, pId:0, name:"随意勾选 1", open:true},
 			{ id:11, pId:1, name:"随意勾选 1-1", open:true},
 			{ id:111, pId:11, name:"随意勾选 1-1-1"},
 			{ id:112, pId:11, name:"随意勾选 1-1-2"},
 			{ id:12, pId:1, name:"随意勾选 1-2", open:true},
 			{ id:121, pId:12, name:"随意勾选 1-2-1"},
 			{ id:122, pId:12, name:"随意勾选 1-2-2"},
 			{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
 			{ id:21, pId:2, name:"随意勾选 2-1"},
 			{ id:22, pId:2, name:"随意勾选 2-2", open:true},
 			{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
 			{ id:222, pId:22, name:"随意勾选 2-2-2"},
 			{ id:23, pId:2, name:"随意勾选 2-3"}
 		];
 		
 		
 		
 		$(document).ready(function(){
 			zNodes=${initMenu};
 			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
 			//$.fn.zTree.setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
 			//$.fn.zTree.expandAll(true);
 			var treeObj = $.fn.zTree.getZTreeObj("treeDemo"); 
 			treeObj.expandAll(true); 
 		});
 		function check(){
				var treeObj = $.fn.zTree.getZTreeObj("treeDemo"); 
				var nodes=treeObj.getCheckedNodes(true);
				var submitNodes="";
				$.each(nodes,function(idx,node){
					submitNodes=submitNodes+node.id+",";
				});
				$("#selectMenuId").val(submitNodes);
				return true;
			}
 		var curSel="";//当前被选择的角色ul id
 		function refreshTree(rid){
 			var oid="u"+rid;
 			$('#'+curSel).css('background-color','');
 			curSel=oid;
 			$('#'+oid).css('background-color','#89a582');
			$.post("ajaxPermissionPA.shtml?rid="+rid,function(data){
				var dat=eval(data);
				zNodes=dat;
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	 			//$.fn.zTree.setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
	 			//$.fn.zTree.expandAll(true);
	 			var treeObj = $.fn.zTree.getZTreeObj("treeDemo"); 
	 			treeObj.expandAll(true); 
	 			$("#rid").val(rid);
			});
 		}
 		//0:over 1:out
 		function changColor(uid,mouseType){
 			if(uid==curSel){
 				return;
 			}
 			if(mouseType==0){
 				$('#'+uid).css('background-color','#89a582');
 			}else{
 				$('#'+uid).css('background-color','');
 			}
 		}
</script>
</head>
<body>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="62" background="images/nav04.gif">
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td width="21" align="left">权限管理 >> 配置权限</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
<div>
	<div class="divColumn" style="margin-left: 5px;">
		<div id="left" style="border-style:solid;border-width:0px;border-right:1px solid;width:140px;">
			<s:iterator value="rlist" id="role">
				<ul id="u${role.id}" style="width:100px;height:fitilen;border:1px solid #555;cursor:pointer;"
				  onclick="refreshTree(${role.id})" onmouseover="changColor('u${role.id}',0);"
				  onmouseout="changColor('u${role.id}',1);">
				${role.name}
				</ul>
			</s:iterator>
			
		</div>
	</div>
	<div class="divColumn">
		<div class="content_wrap">
			<div class="zTreeDemoBackground left">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
		<s:form action="savePA" onsubmit="return check();">
			<s:hidden id="selectMenuId" name="selectMenuId"/>
			<s:hidden id="rid" name="rid"/>
			<s:submit value="确认"/>
		</s:form>
	</div>
</div>
</body>
</html>