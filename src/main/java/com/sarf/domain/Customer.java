package com.sarf.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customerId")
	private Integer customerId;
	
	@Column(name = "customerName")
	private String customerName;
	
	@OneToMany(mappedBy="customer")
	private Set<Address> customerAddressSet;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Address> getCustomerAddressSet() {
		return customerAddressSet;
	}

	public void setCustomerAddressSet(Set<Address> customerAddressSet) {
		this.customerAddressSet = customerAddressSet;
	}
	
	
	
	
	
}
