package com.codingdojo.library.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.library.models.Book;

@Service
public class BookService {

    // initialize the books variable with values
    private List<Book> books = new ArrayList(Arrays.asList(
    		new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
    		new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
    		new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
    		new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
    		new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
    		));
    
    // returns all the books
    public List<Book> allBooks() {
        return books;
    }

	// return one book according to index in list
    public Book getBook(int idx) {
		if (idx < books.size()) {
			return books.get(idx);
		} else {
			return null;
		}
	}
    
    public void addBook(Book book) {
    		books.add(book);
    }
    
    public void editBook(int idx, Book book) {
    		if (idx < books.size()) {
    			books.set(idx, book);
    		}
    }
    
    public void deleteBook(int idx) {
        if (idx < books.size()){
            books.remove(idx);
        }
    }
}