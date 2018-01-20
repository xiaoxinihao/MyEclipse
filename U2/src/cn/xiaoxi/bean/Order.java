package cn.xiaoxi.bean;

import java.util.Date;

public class Order {

	private int id;            //主键id
	private int userId;        //用户id
	private String loginName;  //用户登录名
	private String userAddress;//用户地址
	private Date createTime;   //订单创建时间
	private float cost;        //用户总消费
	private String serialNumber;//订单号
	
	public Order(){
		
	}
	
	/**
	 * @param id
	 * @param userId
	 * @param loginName
	 * @param userAddress
	 * @param createTime
	 * @param cost
	 * @param serialNumber
	 */
	public Order(int id, int userId, String loginName,
			String userAddress, Date createTime, float cost, String serialNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.serialNumber = serialNumber;
	}

	
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	

}
