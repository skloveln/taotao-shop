package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

public interface ContentService {
	
	/**
	 * 获取内容列表
	 * @param categoryId
	 * @return
	 */
	TaotaoResult getContentList(long categoryId);

}
