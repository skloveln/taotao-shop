package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * 内容管理
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年8月19日上午11:24:41
 * @version 1.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	private TaotaoResult saveContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}
	
	@RequestMapping("/query/list")
	@ResponseBody
	private EasyUIDataGridResult queryList(@RequestParam(defaultValue="1") Integer page, 
			@RequestParam(defaultValue="30") Integer rows, Long categoryId){
		
		EasyUIDataGridResult result = contentService.getContentList(page, rows, categoryId);
		
		return result;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	private TaotaoResult editContent(TbContent content){
		TaotaoResult result = contentService.updateContent(content);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	private TaotaoResult deleteContent(Long ids){
		TaotaoResult result = contentService.deleteContent(ids);
		return result;
	}
}
