package com.kanmenzhu.fsp.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.Region;

import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.fsp.entity.LuOrder;
import com.kanmenzhu.fsp.entity.LuOrderDetail;
import com.kanmenzhu.fsp.service.GoodsService;
import com.kanmenzhu.fsp.service.OrderDetailService;
import com.kanmenzhu.fsp.service.OrderService;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.system.security.service.RoleService;
import com.kanmenzhu.web.BaseAction;

@SuppressWarnings("deprecation")
public class OrderAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LuOrder order;
	
	private List<LuOrder> orderList;
	private List<LuOrderDetail> odetailList;
	private List<LuGoods> goodsList;
	private List<LuRole> roleList;
	private List<LuDepartment> depList;
	private Map<Integer, LuDepartment> goodDept;
	private Map<Integer,LuGoods> goodMap;
	/** 订单开始时间 */
	private String beginTime;
	/** 订单结束时间 */
	private String endTime;
	/** 下载文件名称 */
	private String fileName;
	/** 订单状态 */
	private String status;
	private Integer depId;
	
	private OrderService orderService;
	private OrderDetailService odetailService;
	private DepartmentService departmentService;
	private GoodsService goodsService;
	private RoleService roleService;
	
	public String regist(){
		order = null;
		//判断当前用户是否为文教部门
		depList = new ArrayList<LuDepartment>();
		List<LuRole> roles = roleService.getRoles(getCurrentUser());
		boolean isTrue = false;
		for (LuRole role:roles) {
			if (LuRole.MANAGER.equals(role.getType())) {
				isTrue = true;
			}
		}
		if (isTrue) {
			depList = departmentService.getByType(LuRole.SCHOOL);		
		}else {
			LuDepartment dep = departmentService.getDepartmentByUser(getCurrentUser());
			if (null!=dep) {
				depList.add(dep);
			}
		}		
		roleList = roleService.getRoles(getCurrentUser());
		goodsList = goodsService.getGoodsByTag(LuGoods.OK);
		odetailList = new ArrayList<LuOrderDetail>();
		LuOrderDetail detail = new LuOrderDetail();
		odetailList.add(detail);		
		logger.info("####订单页面####");
		return "regist";
	}
	
	public String add(){
		if(order != null){
			order.setCreateTime(new Date());
			order.setCreateUserId(getCurrentUser().getId());
//			order.setDeptId(getCurrentUser().getDeptId());
			order.setStatus(LuOrder.UNSUBMIT_ADUIT);
			orderService.save(order);
			if (odetailList!=null) {
				for (LuOrderDetail orderDetail : odetailList) {
					if (null!=orderDetail) {
						orderDetail.setCreateTime(new Date());
						orderDetail.setOrderId(order.getId());
						orderDetail.setStatus(order.getStatus());
						orderDetail.setUserId(getCurrentUser().getId());
						orderDetail.setDeptId(order.getDeptId());
						odetailService.save(orderDetail);
					}
				}
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"创建订单ID="+order.getId()+"学校ID"+order.getDeptId());
		}else {
			logger.error("保存订单时，订单为NULL，操作人："+getCurrentUser().getLoginName());
		}		
		return list();
	}
	
	public String update() throws Exception{
		if (order!=null) {
			orderService.update(order);
			for (LuOrderDetail detail : odetailList) {
				if (null == detail.getId()) {
					detail.setCreateTime(new Date());
					detail.setOrderId(order.getId());
					detail.setStatus(order.getStatus());
					detail.setUserId(getCurrentUser().getId());
					detail.setDeptId(order.getDeptId());
					odetailService.save(detail);
				}else {
					odetailService.update(detail);
				}
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"更新订单ID="+order.getId());
		}
		return show();
	}
	
	
	public String addAudit(){
		if(order != null){
			order.setCreateTime(new Date());
			order.setCreateUserId(getCurrentUser().getId());
			order.setDeptId(getCurrentUser().getDeptId());
			order.setStatus(LuOrder.ADUIT_ING);
			order.setSubmitTime(new Date());
			orderService.save(order);
			if (odetailList!=null) {
				for (LuOrderDetail orderDetail : odetailList) {
					if (null!=orderDetail) {
						orderDetail.setCreateTime(new Date());
						orderDetail.setOrderId(order.getId());
						orderDetail.setStatus(order.getStatus());
						orderDetail.setDeptId(order.getDeptId());
						orderDetail.setUserId(getCurrentUser().getId());
						odetailService.save(orderDetail);
					}
				}
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"创建并送审订单ID="+order.getId());
		}else {
			logger.error("保存订单时，订单为NULL，操作人："+getCurrentUser().getLoginName());
		}		
		return list();
	}

	public String list(){
		//根据用户权限获取订单
		try {
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
			Date start = null;
			Date end = null;
			if (StringUtils.isNotBlank(beginTime)) {
				start = format2.parse(beginTime);
			}
			if (StringUtils.isNotBlank(endTime)) {
				Calendar endtime = Calendar.getInstance();
				endtime.setTime(format2.parse(endTime));
				endtime.add(Calendar.DATE, 1);
				end = endtime.getTime();
			}
			roleList = roleService.getRoles(getCurrentUser());
			if (roleList!=null) {
				for (LuRole role : roleList) {
					if (LuRole.SCHOOL.equals(role.getType())) {
						//学校可查询所有状态订单
						orderList = orderService.getOrdersByTime(start, end);
						for (LuOrder order : orderList) {
							LuDepartment dep = departmentService.get(order.getDeptId(), LuDepartment.class);
							order.setDeptName(dep.getName());
							Date send = order.getCreateTime();
							System.out.println("时间"+send.toString());
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String time = format.format(send);
							order.setCreate(time);
						}
						return "list";
					}else if (LuRole.MANAGER.equals(role.getType())) {
						orderList = orderService.getOrdersByManager(start,end);
						//文教局可查询审核中及审核通过及审核未通过的订单
					}else if (LuRole.SUPPLIER.equals(role.getType())) {
						//供应商可查询审核通过的订单
						orderList = orderService.getOrdersBySupplier(start,end);
					}
				}
				for (LuOrder order : orderList) {
					LuDepartment dep = departmentService.get(order.getDeptId(), LuDepartment.class);
					order.setDeptName(dep.getName());
					Date send = order.getCreateTime();
					System.out.println("时间"+send.toString());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String time = format.format(send);
					order.setCreate(time);
				}
			}
		} catch (ParseException e) {
			logger.error("时间转换错误",e);
		}
		
		return "list";
	}
	
	public String show() throws Exception{
		//判断当前用户是否为文教部门
		depList = new ArrayList<LuDepartment>();
		List<LuRole> roles = roleService.getRoles(getCurrentUser());
		boolean isTrue = false;
		for (LuRole role:roles) {
			if (LuRole.MANAGER.equals(role.getType())) {
				isTrue = true;
			}
		}
		if (isTrue) {
			depList = departmentService.getByType(LuRole.SCHOOL);		
		}else {
			LuDepartment dep = departmentService.getDepartmentByUser(getCurrentUser());
			if (null!=dep) {
				depList.add(dep);
			}
		}				
		roleList = roleService.getRoles(getCurrentUser());
		goodsList = goodsService.getAll(-1, -1);
		for (LuGoods goods : goodsList) {
			if (goods.getDelTag()==LuGoods.DELETE) {
				goods.setName(goods.getName()+"(已删除)");
			}
		}
		if (order!=null) {
			order = orderService.get(order.getId(), LuOrder.class);
			odetailList = odetailService.getOrderDetailByOrderId(order.getId());
			for (LuOrderDetail detail : odetailList) {
				Date send = detail.getSendTime();
				System.out.println("时间"+send.toString());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = format.format(send);
				detail.setSend(time);
			}
		}
		return "show";
	}
	
	public String delete(){
		if (order!=null) {
			order = orderService.get(order.getId(), LuOrder.class);
			odetailList = odetailService.getOrderDetailByOrderId(order.getId());
			for (LuOrderDetail detail : odetailList) {
				odetailService.delete(detail);
			}
			orderService.delete(order);
			logger.info("用户"+getCurrentUser().getLoginName()+"将订单ID="+order.getId()+"删除！");
		}
		return list();
	}
	
	
	public String audit(){
		if (order!=null) {
			order.setSubmitTime(new Date());
			order.setStatus(LuOrder.ADUIT_ING);
			orderService.update(order);
			logger.info("用户"+getCurrentUser().getLoginName()+"送审订单ID="+order.getId());
		}
		return list();
	}
	
	public String updateAudit(){
		if (order!=null) {
			order.setSubmitTime(new Date());
			order.setStatus(LuOrder.ADUIT_ING);
			orderService.update(order);
			for (LuOrderDetail detail : odetailList) {
				if (null == detail.getId()) {
					detail.setCreateTime(new Date());
					detail.setOrderId(order.getId());
					detail.setStatus(LuOrder.ADUIT_ING);
					detail.setUserId(getCurrentUser().getId());
					odetailService.save(detail);
				}else {
					odetailService.update(detail);
				}
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"更新并送审订单ID="+order.getId());
		}
		return "show";
	}
	
	public String auditPass(){
		if (order!=null) {
			order.setAuditTime(new Date());
			order.setStatus(LuOrder.ADUIT_SUCCESS);
			orderService.update(order);
			for (LuOrderDetail detail : odetailList) {
				detail.setStatus(LuOrder.ADUIT_SUCCESS);
				odetailService.update(detail);
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"审核订单ID="+order.getId()+"通过!");
		}
		return list();
	}
	
	public String auditNoPass(){
		if (order!=null) {
			order.setAuditTime(new Date());
			order.setStatus(LuOrder.ADUIT_FAIL);
			orderService.update(order);
			for (LuOrderDetail detail : odetailList) {
				detail.setStatus(LuOrder.ADUIT_FAIL);
				odetailService.update(detail);
			}
			logger.info("用户"+getCurrentUser().getLoginName()+"审核订单ID="+order.getId()+"不通过，返回提交用户!");
		}
		return list();
	}
	
	public String exportList(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start = null;
			Date end = null;
			if (StringUtils.isNotBlank(beginTime)) {
				start = format.parse(beginTime);
			}
			if (StringUtils.isNotBlank(endTime)) {
				Calendar endtime = Calendar.getInstance();
				endtime.setTime(format.parse(endTime));
				endtime.add(Calendar.DATE, 1);
				end = endtime.getTime();
			}
			if(null!=depId){
				odetailList = odetailService.getOrderDetailsByTimeStatusType(start, end, status, depId);
			}else{
				odetailList = odetailService.getOrderDetailsByTimeAndStatus(start, end, status);
			}
			for (LuOrderDetail detail : odetailList) {
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				detail.setSend(format2.format(detail.getSendTime()));
				LuGoods goods = goodsService.get(detail.getGoodId(), LuGoods.class);
				if (null!=goods) {
					detail.setGoodName(goods.getName());
					detail.setPrice(goods.getPrice()+"元/"+goods.getUnit());
					LuDepartment dep = departmentService.get(goods.getDeptId(), LuDepartment.class);
					if (null!=dep) {
						detail.setDepName(dep.getName());
					}
				}
			}
			//exportXls(odetailList);
		} catch (ParseException e) {
			logger.error("时间格式错误！",e);
		}
		return "success";
	}
	
	/**
	 * 文件下载
	 * @return
	 */
	public InputStream getDownload(){
		InputStream is=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start = null;
			Date end = null;
			if (StringUtils.isNotBlank(beginTime)) {
				start = format.parse(beginTime);
			}
			if (StringUtils.isNotBlank(endTime)) {
				Calendar endtime = Calendar.getInstance();
				endtime.setTime(format.parse(endTime));
				endtime.add(Calendar.DATE, 1);
				end = endtime.getTime();
			}
			if(null!=depId){
				odetailList = odetailService.getOrderDetailsByTimeStatusType(start, end, status, depId);
			}else{
				odetailList = odetailService.getOrderDetailsByTimeAndStatus(start, end, status);
			}
			for (LuOrderDetail detail : odetailList) {
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				detail.setSend(format2.format(detail.getSendTime()));
				LuGoods goods = goodsService.get(detail.getGoodId(), LuGoods.class);
				if (null!=goods) {
					detail.setGoodName(goods.getName());
					detail.setPrice(goods.getPrice()+"元/"+goods.getUnit());
					LuDepartment dep = departmentService.get(goods.getDeptId(), LuDepartment.class);
					if (null!=dep) {
						detail.setDepName(dep.getName());
					}
				}
			}
			is=exportXls(odetailList);
		} catch (ParseException e) {
			logger.error("时间格式错误！",e);
		}
		return is;
	}
	
	public String showXls(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start = null;
			Date end = null;
			if (StringUtils.isNotBlank(beginTime)) {
				start = format.parse(beginTime);
			}
			if (StringUtils.isNotBlank(endTime)) {
				Calendar endtime = Calendar.getInstance();
				endtime.setTime(format.parse(endTime));
				endtime.add(Calendar.DATE, 1);
				end = endtime.getTime();
			}
			if(null!=depId){
				odetailList = odetailService.getOrderDetailsByTimeStatusType(start, end, status, depId);
			}else{
				odetailList = odetailService.getOrderDetailsByTimeAndStatus(start, end, status);
			}
			for (LuOrderDetail detail : odetailList) {
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				detail.setSend(format2.format(detail.getSendTime()));
				LuGoods goods = goodsService.get(detail.getGoodId(), LuGoods.class);
				if (null!=goods) {
					detail.setGoodName(goods.getName());
					detail.setPrice(goods.getPrice()+"元/"+goods.getUnit());
					LuDepartment dep = departmentService.get(goods.getDeptId(), LuDepartment.class);
					if (null!=dep) {
						detail.setDepName(dep.getName());
					}
				}
			}
		} catch (ParseException e) {
			logger.error("时间格式错误！",e);
		}
		return "export";
	}
	
	public String export(){
		//判断当前用户是否为文教部门
		depList = new ArrayList<LuDepartment>();
		List<LuRole> roles = roleService.getRoles(getCurrentUser());
		boolean isTrue = false;
		for (LuRole role:roles) {
			if (LuRole.MANAGER.equals(role.getType())) {
				isTrue = true;
			}
		}
		if (isTrue) {
			depList = departmentService.getByType(LuRole.SCHOOL);		
		}else {
			LuDepartment dep = departmentService.getDepartmentByUser(getCurrentUser());
			if (null!=dep) {
				depList.add(dep);
			}
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		endTime = format.format(new Date());
		Calendar now = Calendar.getInstance();
		now.add(Calendar.WEEK_OF_MONTH, -1);
		beginTime = format.format(now.getTime());
		this.setStatus("");
		odetailList= new ArrayList<LuOrderDetail>();
		return "export";
	}

	
	public InputStream exportXls(List<LuOrderDetail> list){
		fileName = "";
		LuDepartment dep = null;
		if (depId!=null) {
			dep = departmentService.get(depId, LuDepartment.class);
			if (null!=dep) {
				fileName = fileName+dep.getName();
			}
		}
		fileName = fileName+beginTime+"至"+endTime+"采购计划";
		try {
			URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			logger.error("下载文件名转换中文错误！",e1);
		} 
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("采购计划");
		//第一行
		HSSFCellStyle styleRow0 = workbook.createCellStyle();
		Font fontRow0 = workbook.createFont();
		//设置字体
		fontRow0.setBoldweight(Font.BOLDWEIGHT_BOLD);
		fontRow0.setFontName("宋体");
		fontRow0.setFontHeightInPoints((short)24);
		styleRow0.setFont(fontRow0);
		//居中对齐
		styleRow0.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styleRow0.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFRow row0 = sheet.createRow(0);
		row0.setHeightInPoints((float)31.5);
		sheet.addMergedRegion(new Region(0,(short)0,0,(short)4));
		HSSFCell row0Cell0 = row0.createCell(0);
		row0Cell0.setCellStyle(styleRow0);
		row0Cell0.setCellValue(beginTime+"至"+endTime+"采集计划");
		//第二行
		HSSFCellStyle styleRow1 = workbook.createCellStyle();
		Font fontRow1 = workbook.createFont();
		//设置字体
		fontRow1.setFontName("宋体");
		fontRow1.setFontHeightInPoints((short)18);
		styleRow1.setFont(fontRow1);
		HSSFRow row1 = sheet.createRow(1);
		row1.setHeightInPoints((float)20.25);
		HSSFCell row1Cell0 = row1.createCell(0);
		row1Cell0.setCellStyle(styleRow1);
		String xuexiao = "学校：";
		if (null!=dep) {
			xuexiao = xuexiao+dep.getName();
		}else {
			xuexiao = xuexiao+"全部";
		}
		row1Cell0.setCellValue(xuexiao);
		sheet.addMergedRegion(new Region(1, (short)3, 1, (short)4));
		HSSFCell row1Cell3 = row1.createCell(3);
		row1Cell3.setCellStyle(styleRow1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		row1Cell3.setCellValue("日期："+format.format(new Date()));
		//第三行
		HSSFCellStyle styleRow2 = workbook.createCellStyle();
		Font fontRow2 = workbook.createFont();
		//设置字体
		fontRow2.setFontName("宋体");
		fontRow2.setFontHeightInPoints((short)16);
		styleRow2.setFont(fontRow2);
		HSSFRow row2 = sheet.createRow(2);
		row2.setHeightInPoints((float)20.25);
		sheet.addMergedRegion(new Region(2,(short)0,2,(short)4));
		HSSFCell row2Cell0 = row2.createCell(0);
		row2Cell0.setCellStyle(styleRow2);
		row2Cell0.setCellValue("餐厅经理签字：");
		//第四行，标题行
		HSSFCellStyle styleRow3 = workbook.createCellStyle();
		Font fontRow3 = workbook.createFont();
		//设置字体
		fontRow3.setFontName("宋体");
		fontRow3.setFontHeightInPoints((short)18);
		styleRow3.setFont(fontRow3);
		styleRow3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styleRow3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		styleRow3.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		styleRow3.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		styleRow3.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		styleRow3.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		HSSFRow row3 = sheet.createRow(3);
		row3.setHeightInPoints((float)22.5);
		HSSFCell row3Cell0 = row3.createCell(0);
		row3Cell0.setCellValue("采购物品名称");
		row3Cell0.setCellStyle(styleRow3);
		sheet.setColumnWidth(0, 22*256);
		HSSFCell row3Cell1 = row3.createCell(1);
		row3Cell1.setCellValue("数量");
		row3Cell1.setCellStyle(styleRow3);
		sheet.setColumnWidth(1, 17*256);
		HSSFCell row3Cell2 = row3.createCell(2);
		row3Cell2.setCellStyle(styleRow3);
		row3Cell2.setCellValue("单位");
		sheet.setColumnWidth(2, 17*256);
		HSSFCell row3Cell3 = row3.createCell(3);
		row3Cell3.setCellStyle(styleRow3);
		row3Cell3.setCellValue("需送达时间");
		sheet.setColumnWidth(3, 25*256);
		HSSFCell row3Cell4 = row3.createCell(4);
		row3Cell4.setCellStyle(styleRow3);
		row3Cell4.setCellValue("备注");
		sheet.setColumnWidth(4, 20*256);
		int num = list.size();
		for (int i = 0; i < num; i++) {
			LuOrderDetail detail = list.get(i);
			HSSFRow rowi = sheet.createRow(i+4);
			rowi.setHeightInPoints((float)22.5);
			HSSFCell rowiCell0 = rowi.createCell(0);
			rowiCell0.setCellStyle(styleRow3);
			rowiCell0.setCellValue(detail.getGoodName());
			HSSFCell rowiCell1 = rowi.createCell(1);
			rowiCell1.setCellStyle(styleRow3);
			rowiCell1.setCellValue(detail.getGoodNum());
			HSSFCell rowiCell2 = rowi.createCell(2);
			rowiCell2.setCellStyle(styleRow3);
			rowiCell2.setCellValue(detail.getGoodUnit());
			HSSFCell rowiCell3 = rowi.createCell(3);
			Font fonttime = workbook.createFont();
			fonttime.setFontName("宋体");
			fonttime.setFontHeightInPoints((short)12);
			HSSFCellStyle styletime = workbook.createCellStyle();
			styletime.setFont(fonttime);
			rowiCell3.setCellStyle(styletime);
			rowiCell3.setCellValue(detail.getSend());
			HSSFCell rowiCell4 = rowi.createCell(4);
			rowiCell4.setCellStyle(styleRow3);
			rowiCell4.setCellValue(detail.getMemo());
		}
		HSSFRow rowlast = sheet.createRow(4+num);
		HSSFCellStyle styleRowlast = workbook.createCellStyle();
		Font fontRowlast = workbook.createFont();
		//设置字体
		fontRowlast.setFontName("宋体");
		//字体大小
		fontRowlast.setFontHeightInPoints((short)12);
		styleRowlast.setFont(fontRowlast);
		rowlast.setHeightInPoints((float)39);
		styleRowlast.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFCell rowlastCell0 = rowlast.createCell(0);
		rowlastCell0.setCellStyle(styleRowlast);
		rowlastCell0.setCellValue("审批人");
		HSSFCell rowlastCell3 = rowlast.createCell(3);
		rowlastCell3.setCellStyle(styleRowlast);
		rowlastCell3.setCellValue("公章");
		FileOutputStream file;
		/*try {
			file = new FileOutputStream("E://privateWorkSpace//fsp//workbook1.xls");
			workbook.write(file);
			file.close();
		} catch (IOException e) {
			System.err.println("生产xls文件出错");
			e.printStackTrace();
		}*/
		
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			workbook.write(os);// 在内存中把数据写入ByteArrayOutputStream os
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();// 在内存中,得到os的字节数组
		InputStream iss = new ByteArrayInputStream(content);// 用字节数组构造一个输入流
		return iss;
	}
	
	public LuOrder getOrder() {
		return order;
	}

	public List<LuOrder> getOrderList() {
		return orderList;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrder(LuOrder order) {
		this.order = order;
	}

	public void setOrderList(List<LuOrder> orderList) {
		this.orderList = orderList;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<LuOrderDetail> getOdetailList() {
		return odetailList;
	}

	public OrderDetailService getOdetailService() {
		return odetailService;
	}

	public void setOdetailList(List<LuOrderDetail> odetailList) {
		this.odetailList = odetailList;
	}

	public void setOdetailService(OrderDetailService odetailService) {
		this.odetailService = odetailService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public List<LuGoods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<LuGoods> goodsList) {
		this.goodsList = goodsList;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Map<Integer, LuDepartment> getGoodDept() {
		return goodDept;
	}

	public void setGoodDept(Map<Integer, LuDepartment> goodDept) {
		this.goodDept = goodDept;
	}

	public Map<Integer, LuGoods> getGoodMap() {
		return goodMap;
	}

	public void setGoodMap(Map<Integer, LuGoods> goodMap) {
		this.goodMap = goodMap;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<LuRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<LuRole> roleList) {
		this.roleList = roleList;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LuDepartment> getDepList() {
		return depList;
	}

	public void setDepList(List<LuDepartment> depList) {
		this.depList = depList;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

}
