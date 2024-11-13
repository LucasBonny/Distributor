package br.com.gunthercloud.project.entities.pk;

import java.util.Objects;

import br.com.gunthercloud.project.entities.Product;
import br.com.gunthercloud.project.entities.Supplier;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DeliveryGoodsPK {
	
	@ManyToOne
	@JoinColumn(name = "tb_supplier")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "tb_product")
	private Product product;
	
	public DeliveryGoodsPK() {
		
	}

	public DeliveryGoodsPK(Supplier supplier, Product product) {
		this.supplier = supplier;
		this.product = product;
	}


	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, supplier);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryGoodsPK other = (DeliveryGoodsPK) obj;
		return Objects.equals(product, other.product) && Objects.equals(supplier, other.supplier);
	}

	
}
