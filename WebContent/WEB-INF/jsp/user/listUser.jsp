<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户列表</title>
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

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/xiangmu.js"></script>
<script language="javascript" src="js/jquery-1.10.0.min.js"></script>

<script language="javascript">
	function selectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

	function on_load() {
		var loadingmsg = document.getElementById("loadingmsg");
		var mainpage = document.getElementById("mainpage");
		loadingmsg.style.display = "";
		mainpage.style.display = "none";

		loadingmsg.style.display = "none";
		mainpage.style.display = "";
	}
</script>
</head>
<body onload="on_load()">
		<table id="mainpage" width="100%" border="0" cellspacing="0"
			cellpadding="0">

			<tr>
				<td height="30"><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td height="62" background="images/nav04.gif">
								<s:form action="listUA.shtml" method="post">
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="25%" align="left">用户管理  >> 用户列表 </td>
										<td width="5%"><img src="images/ico07.gif" width="20" height="18" /></td>
										<td width="70%">名称: <s:textfield name="user.name"/>
											<input name="Submit" type="submit" class="right-button02" value="搜索" /></td>
										<td width="132" align="left">
										</td>
									</tr>
								</table>
								</s:form>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td><table id="subtree1" width="100%" border="0" cellspacing="0" cellpadding="0">

						<tr>
							<td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">

									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td height="40" class="font42"><table width="100%"
												border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
												class="newfont03">

												<tr>
													<td height="20" colspan="7" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">用户列表</td>
												</tr>
												<tr>
													<td width="10%" align="center" bgcolor="#EEEEEE">登录名</td>
													<td width="10%" height="20" align="center" bgcolor="#EEEEEE">联系人</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">部门</td>
													<td width="6%" align="center" bgcolor="#EEEEEE">电话</td>
													<td width="6%" align="center" bgcolor="#EEEEEE">手机</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">电子邮箱</td>
													<td width="4%" align="center" bgcolor="#EEEEEE">删除</td>
												</tr>
												<s:iterator value="userList" var="u">
													<tr align="center" id="tr${u.id}">
														<td bgcolor="#FFFFFF"><a href="editUA.shtml?user.id=${u.id}">${u.loginName}</a></td>
														<td height="20" bgcolor="#FFFFFF">${u.name}</td>
														<td bgcolor="#FFFFFF">${u.depName}</td>
														<td bgcolor="#FFFFFF">${u.phone}</td>
														<td bgcolor="#FFFFFF">${u.mobile}</td>
														<td bgcolor="#FFFFFF">${u.email}</td>
														<td bgcolor="#FFFFFF">
														<s:if test="#u.deptId!=0">
														<a href="javascript:window.location='delUA.shtml?user.id=${u.id}';">删除</a>
														</s:if>
														</td>
													</tr>
												</s:iterator>

											</table></td>
									</tr>
								</table></td>
						</tr>
						
						<tr>
							<td height="30" align="center">
							<input name="Submit2" type="button" class="right-button08" value="添加新用户" onclick="javascript:window.location='registUA.shtml';" />
							</td>
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

	<div id="loadingmsg"
		style="width: 100px; height: 18px; top: 0px; display: none;">
		<img src="images/nn.gif" />
	</div>

</body>
</html>
