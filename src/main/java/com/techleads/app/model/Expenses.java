package com.techleads.app.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Expenses {

	private Integer id;
	private String itemName;
	private String category;
	private double price;
	
	private LocalDate dateOfExpense;
}
