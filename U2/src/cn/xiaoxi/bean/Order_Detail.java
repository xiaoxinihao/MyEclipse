package cn.xiaoxi.bean;

public class Order_Detail {
	
	private int id;         // 主键 
	private int orderId;    //订单主键
	private int productId;  //商品主键
	private int quantity;   //数量
	private float cost;     //消费
	
	/**
	 * @param id
	 * @param orderId
	 * @param productId
	 * @param quantity
	 * @param cost
	 */
	public Order_Detail(int id, int orderId, int productId, int quantity,
			float cost) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public Order_Detail(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	

}
