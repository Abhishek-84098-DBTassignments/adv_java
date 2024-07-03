package com.sunbeam.dto;
/*
 * firstName,lastName,dob,regAmount
 */

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetails {
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private double regAmount;
}
