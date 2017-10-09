package com.taotao.common.pojo;

import java.util.List;

/**
 * 站内搜索查询结果 
 * @author KaKa
 *
 */
public class SearchResult {

	private List<SolrItem> itemList;  	// 查询商品结果的列表
	private long pageCount;				// 查询结果的总页数
	private long page;					// 查询的当前页数
	private long total;					// 查询结果的总记录数
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<SolrItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<SolrItem> itemList) {
		this.itemList = itemList;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	
	
}
