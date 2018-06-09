package com.demo.javacore.connection.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树形数据结构实体
 * @author ycn
 */
public class TreeNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前节点ID;主键
	 */
	private Integer cid;
	
	/**
	 * 节点名称
	 */
	private String cname;
	
	/**
	 * 父节点
	 */
	private Integer pid;
	
	List<TreeNode> nodes = new ArrayList<>();
	
	public TreeNode() {
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<TreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeNode> nodes) {
		this.nodes = nodes;
	}
	
}
