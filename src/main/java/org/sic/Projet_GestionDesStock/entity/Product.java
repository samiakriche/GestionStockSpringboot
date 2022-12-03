package org.sic.Projet_GestionDesStock.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 25)
	private String name;
	@Lob
	private String description;
	private double price;
	@CreationTimestamp
	private Date createDate;
	@UpdateTimestamp
	private Date updateDate;
	private int quantityStock;
	@ManyToOne()
	@JsonBackReference
	@JoinColumn(name = "category_id")
	private Category category;
	@JsonIgnore
	@OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
	private List<OrderProduct> orderProducts;
	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<SupplierProduct> supplierProducts;

}
