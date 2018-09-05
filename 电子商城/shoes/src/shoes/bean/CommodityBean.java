package shoes.bean;

import java.sql.Timestamp;

public class CommodityBean {
	private int id;
	private String commodityName;
	private int categoryId;
	private String description;
	private Timestamp createDate;
	private String photo;
	public CommodityBean(int id, String commodityName, int categoryId, String description, Timestamp createDate,
			String photo) {
		super();
		this.id = id;
		this.commodityName = commodityName;
		this.categoryId = categoryId;
		this.description = description;
		this.createDate = createDate;
		this.photo = photo;
	}
	public CommodityBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
