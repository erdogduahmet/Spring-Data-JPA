package com.ahmeterdogdu.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmeterdogdu.controller.IBookController;
import com.ahmeterdogdu.dto.DtoBook;
import com.ahmeterdogdu.dto.DtoBookIU;
import com.ahmeterdogdu.services.IBookService;

import jakarta.validation.Valid;

@RequestMapping("/rest/api/book")
@RestController
public class BookControllerImpl implements IBookController {

	@Autowired
	private IBookService bookService;
	
	@PostMapping(path ="/save" )
	@Override
	public DtoBook saveBook(@RequestBody @Valid DtoBookIU dtoBookIU) {
		return bookService.saveBook(dtoBookIU);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoBook> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoBook getBookById(@PathVariable(name = "id",required = true)Integer id) {
		return bookService.getBookById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteBook(@PathVariable(name = "id",required = true)Integer id) {
		bookService.deleteBook(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoBook updateBook(@PathVariable(name = "id",required = true) Integer id, 
						   @RequestBody DtoBookIU updatedDtoBookIU) {
		return bookService.updateBook(id, updatedDtoBookIU);
	}

}
