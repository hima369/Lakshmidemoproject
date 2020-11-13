package com.wellsfargo.sba2.cpk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="kits")
public class kit implements Serializable {
	
	@Id
	@Column(name="kitID")
	@NotNull(message="kitID can not be omitted")
	@Min(value=1, message="kitID can't be zero ro negative")
	private Integer kitID;
	
	@Column(name="productname")
	@NotNull(message = "ProductName can not be omitted")
	@NotBlank(message = "ProductName can not be omitted")
	@Size(min = 5,max=20,message = "Productname must be of 5 to 20 chars in length")
	private String productname;
	
	@Column(name="cost")
	@NotNull(message = "Cost Price can not be omitted")
	@Min(value = 1,message = "Cost Price can not be zero or negative")
	private Double cost;
	
	@Column(name="productdescription")
	@NotNull(message = "productdescription can not be omitted")
	@NotBlank(message = "productdescription can not be omitted")
	@Size(min = 5,max=20,message = "productdescription must be of 5 to 20 chars in length")
	private String productdescription;

	
	
	public Integer getKitID() {
		return kitID;
	}

	public void setKitID(Integer kitID) {
		this.kitID = kitID;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	

	@Override
	public String toString() {
		return "kit [kitID=" + kitID + ", productitem=" + productname + ", cost=" + cost + ", productdescription="
				+ productdescription + "]";
	}
	
		
}
