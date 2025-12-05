/**
 * 
 */
package no.hvl.dat152.rest.ws.controller;


import no.hvl.dat152.rest.ws.model.Author;
import no.hvl.dat152.rest.ws.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 */
@RestController
@RequestMapping("/elibrary/api/v1")
public class AuthorController {

	// TODO
    @Autowired
    AuthorService authorService;

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> findAuthor (@PathVariable int id){

       Author author =  authorService.findById(id);

       return ResponseEntity.ok(author);

    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> findAllAuthors(){

        List<Author> listOfAuthors = authorService.getAllAuthors();

        return ResponseEntity.ok(listOfAuthors);

    }

    @PostMapping("/authors")
    public ResponseEntity<Author> createNewAuthor(@RequestBody Author author){

        Author newAuthor = authorService.createNewAuthor(author);


        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);

    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable int id) throws Exception {

        authorService.deleteAuthor(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }









}
