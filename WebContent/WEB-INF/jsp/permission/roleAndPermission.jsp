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
 			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
 			zTree.setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
 		});
</script>
</head>
<body>
<h1>Checkbox 勾选操作</h1>
<h6>[ 文件路径: excheck/checkbox.html ]</h6>
<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="right">
		<ul class="info">
			<li class="title"><h2>1、setting 配置信息说明</h2>
				<ul class="list">
				<li class="highlight_red">使用 checkbox，必须设置 setting.check 中的各个属性，详细请参见 API 文档中的相关内容</li>
				<li><p>父子关联关系：<br/>
						被勾选时：<input type="checkbox" id="py" class="checkbox first" checked /><span>关联父</span>
						<input type="checkbox" id="sy" class="checkbox first" checked /><span>关联子</span><br/>
						取消勾选时：<input type="checkbox" id="pn" class="checkbox first" checked /><span>关联父</span>
						<input type="checkbox" id="sn" class="checkbox first" checked /><span>关联子</span><br/>
						<ul id="code" class="log" style="height:20px;"></ul></p>
				</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
</body>
</html>