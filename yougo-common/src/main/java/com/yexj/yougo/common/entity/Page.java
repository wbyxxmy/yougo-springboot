package com.yexj.yougo.common.entity;



import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页实体类
 * @param <T>
 */
public class Page<T> implements Serializable{
	/***************************************************
	 * 传入参数
	 ***************************************************/
	private int page;//当前页数
	private int rows;//每页显示行数

		private int currentPageIndex;//当前查询页索引
	private String id;
	private String oper;//操作类型
	private String sord;
	private String sidx;
	private String filters;
	private transient  Map<String,Object> paramMap=new HashMap<>();//map入参
	/***************************************************
	 * 输出参数
	 ***************************************************/
	private int totalPage;//总页数
	private int totalRecordsCount;//总记录条数
	private List<T> resultList;//结果集


	public Page(){
		this.rows = 10;
		paramMap=new HashMap<String,Object>();
	}

	public int getPage() {
		return page==0?1:page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotalPage() {

		if(totalRecordsCount%rows==0)
			totalPage = totalRecordsCount/rows;
		else
			totalPage = totalRecordsCount/rows+1;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecordsCount() {
		return totalRecordsCount;
	}

	public void setTotalRecordsCount(int totalRecordsCount) {
		this.totalRecordsCount = totalRecordsCount;
	}

	public int getCurrentPageIndex() {
		currentPageIndex=(page-1)*rows;
		if(currentPageIndex<0)
			currentPageIndex = 0;
		return currentPageIndex;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public Map getParamMap() {
//		if(filters!=null && !"".equals(filters)){
//			JSONObject filterObject= JSONObject.parseObject(this.filters);
//			JSONArray filterRules=filterObject.getJSONArray("rules");
//			for(int i=0;i<filterRules.size();i++){
//				JSONObject paramData=filterRules.getJSONObject(i);
//				//{"field":"dictType","op":"true","data":"2"}
//				this.paramMap.put((String)paramData.get("field"),paramData.get("data"));
//			}
//		}
//		if(!StringTools.isEmpty(sidx)){
//			String sidxStr=StringTools.convertStringAddChar(sidx,"_");
//			this.sidx=sidxStr;
//			//this.paramMap.put("sidx",sidxStr);
//		}

		return paramMap;
	}

	public void setParamMap(Map<String,Object> paramMap) {
		this.paramMap = paramMap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
}
