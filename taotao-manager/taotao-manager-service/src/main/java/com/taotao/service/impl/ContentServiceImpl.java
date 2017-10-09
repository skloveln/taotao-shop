package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.pojo.TbItem;
import com.taotao.service.ContentService;

/**
 * 内容管理Service
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年8月19日上午11:20:03
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public TaotaoResult insertContent(TbContent content) {
		try {
			//补全字段
			content.setUpdated(new Date());
			content.setCreated(new Date());
			//插入数据
			contentMapper.insert(content);
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		return TaotaoResult.ok();
	}
	
	@Override
	public EasyUIDataGridResult getContentList(Integer page, Integer rows, Long categoryId) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		//设置查询条件
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		//取total
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		
		//创建返回值对象
		EasyUIDataGridResult result = new EasyUIDataGridResult(total, list);
		
		return result;
	}
	
	@Override
	public TaotaoResult updateContent(TbContent content) {
		
		content.setUpdated(new Date());
		TbContent record = contentMapper.selectByPrimaryKey(content.getId());
		content.setCreated(record.getCreated());
		contentMapper.updateByPrimaryKey(content);
		
		return TaotaoResult.ok();
	}
	
	@Override
	public TaotaoResult deleteContent(Long ids) {
		
		contentMapper.deleteByPrimaryKey(ids);
		
		return TaotaoResult.ok();
	}

}
