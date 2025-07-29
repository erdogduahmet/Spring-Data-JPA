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
import com.ahmeterdogdu.entities.Book;
import com.ahmeterdogdu.services.IBookService;

@RequestMapping("/rest/api/book")
@RestController
public class BookControllerImpl implements IBookController {

	@Autowired
	private IBookService bookService;
	
	@PostMapping(path ="/save" )
	@Override
	public Book saveBook(@RequestBody Book book) {
		// TODO Auto-generated method stub
		return bookService.saveBook(book);
	}

	@GetMapping(path = "/list")
	@Override
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public Book getBookById(@PathVariable(name = "id",required = true)Integer id) {
		return bookService.getBookById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteBook(@PathVariable(name = "id",required = true)Integer id) {
		bookService.deleteBook(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public Book updateBook(@PathVariable(name = "id",required = true) Integer id, 
						   @RequestBody Book updateBook) {
		return bookService.updateBook(id, updateBook);
	}

}
