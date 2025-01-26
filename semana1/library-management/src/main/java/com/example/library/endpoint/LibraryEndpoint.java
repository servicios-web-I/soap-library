package com.example.library.endpoint;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import com.example.soap.library.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LibraryEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soap/library";

    @Autowired
    private BookService bookService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublicationYear(request.getYear());
        
        Book savedBook = bookService.addBook(book);
        
        AddBookResponse response = new AddBookResponse();
        response.setBook(convertToBookType(savedBook));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {
        Book book = bookService.getBook(request.getId());
        GetBookResponse response = new GetBookResponse();
        response.setBook(convertToBookType(book));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBooksRequest")
    @ResponsePayload
    public GetAllBooksResponse getAllBooks(@RequestPayload GetAllBooksRequest request) {
        GetAllBooksResponse response = new GetAllBooksResponse();
        bookService.getAllBooks().forEach(book -> response.getBooks().add(convertToBookType(book)));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBookRequest")
    @ResponsePayload
    public UpdateBookResponse updateBook(@RequestPayload UpdateBookRequest request) {
        Book book = new Book();
        book.setId(request.getBook().getId());
        book.setTitle(request.getBook().getTitle());
        book.setAuthor(request.getBook().getAuthor());
        book.setIsbn(request.getBook().getIsbn());
        book.setPublicationYear(request.getBook().getYear());
        book.setAvailable(request.getBook().isAvailable());
        
        Book updatedBook = bookService.updateBook(book);
        
        UpdateBookResponse response = new UpdateBookResponse();
        response.setBook(convertToBookType(updatedBook));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBookRequest")
    @ResponsePayload
    public DeleteBookResponse deleteBook(@RequestPayload DeleteBookRequest request) {
        DeleteBookResponse response = new DeleteBookResponse();
        response.setSuccess(bookService.deleteBook(request.getId()));
        return response;
    }

    private com.example.soap.library.Book convertToBookType(Book book) {
        com.example.soap.library.Book bookType = new com.example.soap.library.Book();
        bookType.setId(book.getId());
        bookType.setTitle(book.getTitle());
        bookType.setAuthor(book.getAuthor());
        bookType.setIsbn(book.getIsbn());
        bookType.setYear(book.getPublicationYear());
        bookType.setAvailable(book.isAvailable());
        return bookType;
    }
}