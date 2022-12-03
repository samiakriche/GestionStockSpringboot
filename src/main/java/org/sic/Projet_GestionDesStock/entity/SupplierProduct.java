package org.sic.Projet_GestionDesStock.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JsonBackReference(value = "product")
	private Product product;
	@ManyToOne
	@JsonBackReference(value = "supplier")
	private Supplier supplier;
	private double price;
	private int quantity;
	@CreationTimestamp
	private Date operationDate;

	public SupplierProduct(Product product, Supplier supplier, double price, int quantity, Date operationDate) {
		this.product = product;
		this.supplier = supplier;
		this.price = price;
		this.quantity = quantity;
		this.operationDate = operationDate;
	}

}
