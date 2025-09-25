package com.ahmeterdogdu.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmeterdogdu.dto.DtoBook;
import com.ahmeterdogdu.dto.DtoBookIU;
import com.ahmeterdogdu.entities.Book;
import com.ahmeterdogdu.repository.BookRepository;
import com.ahmeterdogdu.services.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public DtoBook saveBook(DtoBookIU dtoBookIU) {
		DtoBook dtoBook=new DtoBook();
		Book book=new Book();
		BeanUtils.copyProperties(dtoBookIU, book);
		Book bookDb=bookRepository.save(book);
		BeanUtils.copyProperties(bookDb, dtoBook);
		return dtoBook;
	}

	@Override
	public List<DtoBook> getAllBooks() {
		List<Book> bookList=bookRepository.findAll();
		List<DtoBook> dtoBookList=new ArrayList<>();
		for (Book book : bookList) {
			DtoBook dtoBook=new DtoBook();
			BeanUtils.copyProperties(book, dtoBook);
			dtoBookList.add(dtoBook);
		}
		return dtoBookList;
	}

	@Override
	public DtoBook getBookById(Integer id) {
		Optional<Book> optional =bookRepository.findById(id);
		if (optional.isPresent()) {
			DtoBook dtoBook=new DtoBook();
			Book dbBook=optional.get();
			BeanUtils.copyProperties(dbBook, dtoBook);
			return dtoBook;
		}
		return null;
	}

	@Override
	public void deleteBook(Integer id) {
		Optional<Book> optional=bookRepository.findById(id);
		if (optional.isPresent()) {
			bookRepository.delete(optional.get());
		}
	}

	@Override
	public DtoBook updateBook(Integer id,DtoBookIU updatedDtoBookIU) {
		Optional<Book> optional=bookRepository.findById(id);
		if (optional.isPresent()) {
			Book dbBook=optional.get();
			BeanUtils.copyProperties(updatedDtoBookIU, dbBook);
			dbBook.setAuthor(updatedDtoBookIU.getAuthor());
			dbBook.setPublishDate(updatedDtoBookIU.getPublishDate());
			dbBook.setTitle(updatedDtoBookIU.getTitle());
			Book updatedBook=bookRepository.save(dbBook);
			DtoBook dtoBook=new DtoBook();
			BeanUtils.copyProperties(updatedBook, dtoBook);
			return dtoBook;
		}
		return null;
	}

}
