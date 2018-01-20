package cn.xiaoxi.bean;

public class Product_Category {
	
	
	private int id;   //自己的id
	private String name;  //名称
	private int parentId ;  // 父级目录id
	private int type;  // 级别(1:一级 2：二级 3：三级)
	private String iconClass;  // 图标 
	
	
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param parentId
	 * @param type
	 * @param iconClass
	 */
	
	public Product_Category(){
		
	}
	public Product_Category(int id, String name, int parentId, int type,
			String iconClass) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
	}
	@Override
	public String toString() {
		return "Product_Category [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", type=" + type + ", iconClass=" + iconClass
				+ "]";
	}	


}
