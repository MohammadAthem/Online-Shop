package application;

public class Product {
	private String Category;
	private String Brand;
	private String Name;
	private double Price;
	private String imgFileName;
	private String selectedSize;
	private String selectedColor;

	public Product() {
	}

	public Product(String category, String brand, String name, double price) {
		this.Category = category;
		this.Brand = brand;
		this.Name = name;
		this.Price = price;
	}

	public Product(String category, String brand, String name, double price, String imgFileName) {
		super();
		this.Category = category;
		this.Brand = brand;
		this.Name = name;
		this.Price = price;
		this.imgFileName = imgFileName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getSelectedSize() {
		return selectedSize;
	}

	public void setSelectedSize(String selectedSize) {
		this.selectedSize = selectedSize;
	}

	public String getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

}
