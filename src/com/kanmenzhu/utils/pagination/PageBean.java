package com.kanmenzhu.utils.pagination;

/**
 * 分页bean
 * @author w_ch
 *
 */
public class PageBean {
	
	public static String CUR_PAGE="pb.cp";

	/**上一页*/
	private String baseUrl;
	
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	private int total;
	private int startRow;
	private int endRow;
	private int pageSize=15;
	
	private int curPage;
	
		
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStartRow() {
		curPage=curPage==0?1:curPage;
		return (curPage-1)*pageSize;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		if(curPage>1){
			return pageSize*curPage-1;
		}
		return pageSize*curPage;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public String getPrevUrl() {
		if(0==curPage||1==curPage){
			return getFirstUrl();
		}
		return getUrl("pb.cp="+(curPage-1));
	}
	public String getNextUrl() {
		int tp=total/pageSize;
		if(curPage<=tp){
			return getUrl("pb.cp="+(curPage+1));
		}
		return  getUrl("pb.cp="+(curPage));
	}
	public String getFirstUrl() {
		return getUrl("pb.cp=1");
	}
	public String getLastUrl() {
		int tp=total/pageSize;
		if(tp*pageSize<total){
			return getUrl("pb.cp="+(tp+1));
		}
		return getUrl("pb.cp="+tp);
	}
	
	private String getUrl(String params){
		if(null!=baseUrl){
			if(baseUrl.endsWith("&")||baseUrl.endsWith("?")){
				return baseUrl+params;
			}else if(baseUrl.endsWith("shtml")){
				return baseUrl+"?"+params;
			}else{
				return baseUrl+"&"+params;
			}
		}
		return "./";
	}
	public int getTotalPage(){
		int tp=total/pageSize;
		if(tp<total){
			tp=tp+1;
		}
		return tp;
	}
	
	public void setCp(String s){
		
	}
	public void setCp(String[] s){
		
	}
	public void setCp(int s){
		
	}
}
