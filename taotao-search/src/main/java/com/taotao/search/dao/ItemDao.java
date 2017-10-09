package com.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.taotao.common.pojo.SearchResult;

public interface ItemDao {
	
	/**
	 * 前台系统站内搜索查询商品
	 * @param solrQuery
	 * @return
	 * @throws Exception
	 */
	SearchResult searchItem(SolrQuery solrQuery) throws Exception;
}
