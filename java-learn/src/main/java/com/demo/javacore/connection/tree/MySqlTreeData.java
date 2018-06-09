package com.demo.javacore.connection.tree;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.javacore.connection.MySqlConnection;

/**
 * mysql树形数据
 * @author ycn
 */
public class MySqlTreeData {

	/**
	 * 通过cid获取节点
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public TreeNode getNodeByCid(Integer cid){
		Connection conn = null;
		Statement st = null;
		TreeNode node = new TreeNode();
		try {
			conn = MySqlConnection.getConnection();
			st = MySqlConnection.getStatement(conn);
			String sql = "select * from tb_tree t where t.cid = '"+cid+"' ";
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			int resultCount = rs.getRow();
			rs.beforeFirst();
			if(resultCount > 1)
				throw new Exception("主键id重复！");
			while(rs.next()) {			
				node.setCid(rs.getInt("cid"));
				node.setCname(rs.getString("cname"));
				node.setPid(rs.getInt("pid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.closeConnection(st, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return node;
	}
	
	/**
	 * 通过cid获取cid下所有的子节点
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> getChildNodeByCid(Integer cid) {
		List<TreeNode> nodes = null;
		Connection conn = null;
		Statement st = null;
		try {
			conn = MySqlConnection.getConnection();
			st = MySqlConnection.getStatement(conn);
			String sql = "select * from tb_tree t where t.pid = '"+cid+"' ";
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			int resultCount = rs.getRow();
			rs.beforeFirst();
			if(resultCount > 0) {
				nodes = new ArrayList<>();
				while(rs.next()) {
					TreeNode node = new TreeNode();
					node.setCid(rs.getInt("cid"));
					node.setCname(rs.getString("cname"));
					node.setPid(rs.getInt("pid"));
					nodes.add(node);
				}
				return nodes;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.closeConnection(st, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return nodes;
	}
	
	/**
	 * 所有节点
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> getAllNode() {
		List<TreeNode> nodes = null;
		Connection conn = null;
		Statement st = null;
		try {
			conn = MySqlConnection.getConnection();
			st = MySqlConnection.getStatement(conn);
			String sql = "select * from tb_tree ";
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			int resultCount = rs.getRow();
			rs.beforeFirst();
			if(resultCount > 0) {
				nodes = new ArrayList<>();
				while(rs.next()) {
					TreeNode node = new TreeNode();
					node.setCid(rs.getInt("cid"));
					node.setCname(rs.getString("cname"));
					node.setPid(rs.getInt("pid"));
					nodes.add(node);
				}
				return nodes;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				MySqlConnection.closeConnection(st, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return nodes;
	}
	
	/**
	 * 递归查询数据结构
	 * 缺点:多次请求数据库
	 * @param cid
	 * @return
	 * @throws Exception
	 */
	public TreeNode recursiveTree(Integer cid) throws Exception {
		TreeNode node = getNodeByCid(cid);
		List<TreeNode> nodes = getChildNodeByCid(cid);
		if(null == node)
			throw new Exception("当前节点不存在！");
		//遍历子节点
		if(nodes != null) {
			for(TreeNode child : nodes){
				TreeNode n = recursiveTree(child.getCid()); //递归
				node.getNodes().add(n);
			}
		}
		return node;
	}
	
	/**
	 * 双层循环转换树形数据
	 * @return
	 * @throws Exception
	 */
	public List<TreeNode> conversionTreeData() throws Exception {
		List<TreeNode> result = new ArrayList<>();
		List<TreeNode> allNode = getAllNode();
		for (TreeNode treeNode : allNode) {  
            if (treeNode.getPid() == 0 || treeNode.getPid() == null)//根节点
                result.add(treeNode);  
            for (TreeNode it : allNode) {  
                if (it.getPid() == treeNode.getCid()) {  
                    if (treeNode.getNodes() == null)
                        treeNode.setNodes(new ArrayList<TreeNode>());  
                    treeNode.getNodes().add(it);  
                }  
            }  
        }
		return result;
	}
	
	/**
	 * 递归展示所有节点及其子节点
	 * @param node
	 * @throws Exception
	 */
	public void writNodeInfo(TreeNode node) throws Exception{
		System.out.println(node.getCid()+" -- "+node.getCname()+" -- "+node.getPid());
		List<TreeNode> childNodes = node.getNodes();
		if(childNodes.size() > 0) {
			for (TreeNode treeNode : childNodes) {
				writNodeInfo(treeNode);
			}
		}
	}
	
	public static void main(String[] args) {
		MySqlTreeData mstd = new MySqlTreeData();
		try {
			TreeNode node = mstd.recursiveTree(1);
			mstd.writNodeInfo(node);
			
			System.out.println("============================");
			
			List<TreeNode> treeData = mstd.conversionTreeData();
			for (TreeNode treeNode : treeData)
				mstd.writNodeInfo(treeNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
