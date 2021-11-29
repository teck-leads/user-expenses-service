package com.techleads.app.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Builder
public class Users {
	
	private Integer id;
	private String name;
	private String location;
	private String cardType;
	private String cardNumber;
	private String cvvNumber;
	private List<Expenses> expenses;
	private Double totalExpenditure;
	
	public Users() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public List<Expenses> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expenses> expenses) {
		this.expenses = expenses;
	}
	public Double getTotalExpenditure() {
		return totalExpenditure;
	}
	public void setTotalExpenditure(Double totalExpenditure) {
		this.totalExpenditure = totalExpenditure;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", location=" + location + ", cardType=" + cardType
				+ ", cardNumber=" + cardNumber + ", cvvNumber=" + cvvNumber + ", expenses=" + expenses
				+ ", totalExpenditure=" + totalExpenditure + "]";
	}
	

}
