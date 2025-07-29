package com.ahmeterdogdu.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmeterdogdu.entities.Book;
import com.ahmeterdogdu.repository.BookRepository;
import com.ahmeterdogdu.services.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		Optional<Book> optional= bookRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteBook(Integer id) {
		if (getBookById(id)!=null) {
			bookRepository.delete(getBookById(id));
		}
		
	}

	@Override
	public Book updateBook(Integer id,Book updateBook) {
		Book dbBook=getBookById(id);
		if (dbBook!=null) {
			dbBook.setAuthor(updateBook.getAuthor());
			dbBook.setPublishDate(updateBook.getPublishDate());
			dbBook.setTitle(updateBook.getTitle());
			return bookRepository.save(dbBook);
		}
		return null;
	}

}
