package com.xxs.utils;

import java.util.List;

public class PageInfo {
	private Integer pageSize=5;//每页的数据大小,并且设置初始大小为5
	private Integer pageNum;//当前页
	private Integer total;//总页数
	private List<?> list;//数据集合
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", pageNum=" + pageNum + ", total=" + total + ", list=" + list + "]";
	}

	
	
}
