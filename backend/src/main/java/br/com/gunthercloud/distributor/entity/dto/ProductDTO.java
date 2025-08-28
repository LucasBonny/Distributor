package br.com.gunthercloud.distributor.entity.dto;

public class ProductDTO {
	
	private Long id;
	private Long barCode;
	private String name;
	private double price;
	private int stock;
	private String imgUrl;
	
	public ProductDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBarCode() {
		return barCode;
	}

	public void setBarCode(Long barCode) {
		this.barCode = barCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", barCode=" + barCode + ", name=" + name + ", price=" + price + ", stock="
				+ stock + ", imgUrl=" + imgUrl + "]";
	}
	
}
