package cn.xiaoxi.bean;

import java.util.Date;


public class User_Address {
	
	private int id;          //主键id 
	private int userId;      //用户主键
	private String address;  // 用户地址
	private Date createTime; // 创建时间
	private int isDefault;   //是否是默认地址（1:是 0否）
	private String remark;   //备注
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public User_Address(){
		
		
	}
	
	/**
	 * @param id
	 * @param userId
	 * @param address
	 * @param createTime
	 * @param isDefault
	 * @param remark
	 */
	public User_Address(int id, int userId, String address, Date createTime,
			int isDefault, String remark) {
		super();
		this.id = id;
		this.userId = userId;
		this.address = address;
		this.createTime = createTime;
		this.isDefault = isDefault;
		this.remark = remark;
	}
}
