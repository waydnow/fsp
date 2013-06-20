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
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
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
			}
</script>
</head>
<body>
<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
</div>
<s:form action="savePA" onsubmit="return check();">
	<s:hidden id="selectMenuId" name="selectMenuId"/>
	<s:submit value="确认"/>
</s:form>
</body>
</html>