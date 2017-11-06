package com.codingdojo.library.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.library.models.Book;
import com.codingdojo.library.services.BookService;

@Controller
public class BooksController {

	// declares bookService
	private BookService bookService;
	
	// controller constructor that initializes bookService
	public BooksController(BookService bookService){
	    this.bookService = bookService;
	}
	
	// instantiates book list and adds to view
	@RequestMapping("/")
    public String getAllBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
        return "index";
    }
	
	// get one book by index in list, or redirect if out of bounds
	// out of bounds is determined in bookService via books.size()
	@RequestMapping("/{idx}")
	public String getBook(Model model, @PathVariable("idx") int idx) {
		Book book = bookService.getBook(idx);
		if (book != null) {
			model.addAttribute("book", book);
			model.addAttribute("idx", idx);
			return "book";
		} else {
			return "redirect:/";
		}
	}
	
	// instantiate new Book type and binding to a form in our view!
	@RequestMapping("/add")
	public String getBookForm(@ModelAttribute("book") Book book) {
		return "add";
	}
	
	@PostMapping("/add")
	public String submitBook(
		@Valid @ModelAttribute("book") Book book,
		// inject the BindingResult following the @Valid param
		BindingResult result) {
		
		if (result.hasErrors()) {
			return "add";
		} else {
			bookService.addBook(book);
			return "redirect:/";
		}
	}
	
    @RequestMapping("/{idx}/edit")
    public String getEditForm(@PathVariable("idx") int idx, Model model) {
        Book book = bookService.getBook(idx);
        if (book != null){
            model.addAttribute("book", book);
            return "edit";
        }else{
            return "redirect:/";
        }
    }
    
    @PostMapping("/{idx}/edit")
    public String submitBookEdit(
    		@PathVariable("idx") int idx,
    		@Valid @ModelAttribute("book") Book book,
    		BindingResult result) {
    	
        if (result.hasErrors()) {
            return "edit";
        } else {
            bookService.editBook(idx, book);
            return "redirect:/{idx}";
        }
    }
    
    @RequestMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") int idx) {
        bookService.deleteBook(idx);
        return "redirect:/";
    }
	
}