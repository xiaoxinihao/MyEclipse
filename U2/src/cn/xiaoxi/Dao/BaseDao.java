package cn.xiaoxi.Dao;

public interface BaseDao<T> {
	
	//新增的方法
	public int add(T t);
	
	//修改
	public int dele(T t);
	
	//删除
	public int update(T t);
	
}
