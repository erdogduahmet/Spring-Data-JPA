package com.ahmeterdogdu.controller;

import java.util.List;

import com.ahmeterdogdu.dto.DtoBook;
import com.ahmeterdogdu.dto.DtoBookIU;

public interface IBookController {
	
	public DtoBook saveBook(DtoBookIU dtoBookIU);
	public List<DtoBook> getAllBooks();
	public DtoBook getBookById(Integer id);
	public void deleteBook(Integer id);
	public DtoBook updateBook(Integer id,DtoBookIU updatedDtoBookIU);

}
