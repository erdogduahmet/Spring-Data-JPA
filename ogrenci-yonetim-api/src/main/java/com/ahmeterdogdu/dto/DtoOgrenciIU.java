package com.ahmeterdogdu.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoOgrenciIU {

	@NotEmpty(message = "firstName alanı boş geçilemez")
	@Size(min = 3,max = 10,message = "firstName alanı 3-10 karakter arasında olmalıdır")
	private String firstName;
	
	@NotEmpty(message = "lastName alanı boş geçilemez")
	@Size(min = 3,max = 20,message = "lastName alanı 3 ve 20 karakter arasında olmalıdır")
	private String lastName;
	
	@Min(value = 1,message = "age en az 1 olmalıdır")
	@Max(value = 110,message = "age en fazla 110 olabilir")
	private int age;

}
