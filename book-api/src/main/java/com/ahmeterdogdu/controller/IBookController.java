package com.ahmeterdogdu.controller;

import java.util.List;

import com.ahmeterdogdu.entities.Book;

public interface IBookController {
	
	public Book saveBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(Integer id);
	public void deleteBook(Integer id);
	public Book updateBook(Integer id,Book updateBook);

}
