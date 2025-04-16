package br.com.gunthercloud.project.entities.pk;

import java.util.Objects;

import br.com.gunthercloud.project.entities.Product;
import br.com.gunthercloud.project.entities.Sale;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SaleItemPK {
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;

	public SaleItemPK() {
		
	}
		
	public SaleItemPK(Product product, Sale sale) {
		this.product = product;
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, sale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleItemPK other = (SaleItemPK) obj;
		return Objects.equals(product, other.product) && Objects.equals(sale, other.sale);
	}
	
}
