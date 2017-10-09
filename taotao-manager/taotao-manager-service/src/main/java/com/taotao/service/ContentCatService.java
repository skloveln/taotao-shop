package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;

/**
 * 广告内容分类服务
 * @author KaKa
 *
 */
public interface ContentCatService {

	/**
	 * 获取广告内容分类列表
	 * @param parentId
	 * @return
	 */
	List<TreeNode> getContentCatList(long parentId);
	
	/**
	 * 创建分类节点
	 * @param parentId
	 * @param name
	 * @return
	 */
	TaotaoResult createNode(long parentId, String name);
	
	/**
	 * 修改分类节点
	 * @param parentId
	 * @param name
	 * @return
	 */
	TaotaoResult updateNode(long Id, String name);
	
	/**
	 * 删除分类节点
	 * @param parentId
	 * @param name
	 * @return
	 */
	TaotaoResult deleteNode(long id);
}
