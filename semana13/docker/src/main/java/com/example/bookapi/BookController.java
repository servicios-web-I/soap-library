package com.example.bookapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    // Obtener todos los libros
    @GetMapping
    public List<Book> getAll() {
        return repository.findAll();
    }

    // Crear un libro
    @PostMapping
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

    // Actualizar un libro (PUT)
    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return repository.save(book);
    }

    // Eliminar un libro (DELETE)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
