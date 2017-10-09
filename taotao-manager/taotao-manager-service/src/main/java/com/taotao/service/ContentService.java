package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	
	/**
	 * 增加内容
	 * @param content
	 * @return
	 */
	TaotaoResult insertContent(TbContent content);
	
	/**
	 * 获取内容列表
	 * @return
	 */
	EasyUIDataGridResult getContentList(Integer page, Integer rows, Long categoryId);
	
	/**
	 * 更新内容
	 * @param content
	 * @return
	 */
	TaotaoResult updateContent(TbContent content);
	
	/**
	 * 删除内容
	 * @param content
	 * @return
	 */
	TaotaoResult deleteContent(Long ids);
	
}
