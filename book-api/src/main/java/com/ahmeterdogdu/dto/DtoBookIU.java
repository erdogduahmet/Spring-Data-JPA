package com.ahmeterdogdu.dto;

import java.util.Date;

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
public class DtoBookIU {

	@NotEmpty(message = "title alanı boş bırakılamaz")
	@Size(min = 3,max = 30,message = "title 3-30 karakter arasında olmalıdır")
	private String title;
	
	@NotEmpty(message = "author alanı boş bırakılamaz")
	@Size(min = 3,max = 20,message = "author 3-20 karakter arasında olmalıdır")
	private String author;
	
	private Date publishDate;
}
