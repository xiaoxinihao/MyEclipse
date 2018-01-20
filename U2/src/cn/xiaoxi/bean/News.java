package cn.xiaoxi.bean;

import java.util.Date;

public class News {
	
	private int id;  			// 主键id
	private  String title;  	// 标题
	private  String content;  	// 内容
	private  Date createTime;   // 创建时间
	private  String img;        //保存图片路径
	
	public News(){
		
		
	}
	/**
	 * @param id
	 * @param title
	 * @param content
	 * @param createTime
	 * @param img
	 */
	public News(int id, String title, String content, Date createTime,
			String img) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
