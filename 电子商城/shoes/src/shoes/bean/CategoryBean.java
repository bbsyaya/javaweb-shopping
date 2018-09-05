package shoes.bean;

public class CategoryBean {
	private Integer id;
	private String categoryName;
	private String description;
	private int sort;
	
	public CategoryBean(Integer id, String categoryName, String description, int sort) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.sort = sort;
	}
	
	
	public int getSort() {
		return sort;
	}


	public void setSort(int sort) {
		this.sort = sort;
	}


	public CategoryBean() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
