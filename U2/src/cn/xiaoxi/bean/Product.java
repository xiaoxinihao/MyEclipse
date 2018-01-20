package cn.xiaoxi.bean;

import cn.xiaoxi.util.PageUtil;

public class Product {
	
	private int   	id;            //  主键id
	private String  name;      //   名称
	private String  description ;    // 商品描述
	private float   price;             // 价格
	private int     stock;               // 库存
	private int     categoryLevel1Id;   // 分类1
	private int     categoryLevel2Id;  // 分类2
	private int     categoryLevel3Id;  //分类3
	private String 	fileName;        //文件名称
	private int     isDelete ;    //是否删除(1：删除 0：未删除)
	
	private PageUtil util; // 分页的工具类
	
	public PageUtil getUtil() {
		return util;
	}
	public void setUtil(PageUtil util) {
		this.util = util;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryLevel1Id() {
		return categoryLevel1Id;
	}
	public void setCategoryLevel1Id(int categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}
	public int getCategoryLevel2Id() {
		return categoryLevel2Id;
	}
	public void setCategoryLevel2Id(int categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}
	public int getCategoryLevel3Id() {
		return categoryLevel3Id;
	}
	public void setCategoryLevel3Id(int categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
	public Product(){
		
	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param price
	 * @param stock
	 * @param categoryLevel1Id
	 * @param categoryLevel2Id
	 * @param categoryLevel3Id
	 * @param fileName
	 * @param isDelete
	 */
	public Product(int id, String name, String description, float price,
			int stock, int categoryLevel1Id, int categoryLevel2Id,
			int categoryLevel3Id, String fileName, int isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryLevel1Id = categoryLevel1Id;
		this.categoryLevel2Id = categoryLevel2Id;
		this.categoryLevel3Id = categoryLevel3Id;
		this.fileName = fileName;
		this.isDelete = isDelete;
	}
	
	

	
	
	
}
