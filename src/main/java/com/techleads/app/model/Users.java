package com.techleads.app.model;

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
public class Users {
	
	private Integer id;
	private String name;
	private String location;
	private String cardType;
	private String cardNumber;
	private String cvvNumber;

}
