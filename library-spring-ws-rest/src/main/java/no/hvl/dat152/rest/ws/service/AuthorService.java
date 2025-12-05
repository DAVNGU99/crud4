/**
 * 
 */
package no.hvl.dat152.rest.ws.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat152.rest.ws.model.Author;
import no.hvl.dat152.rest.ws.repository.AuthorRepository;

import java.util.List;

/**
 * 
 */
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Author findById(int id) {
		
		return authorRepository.findById(id).get();
	}


    public List<Author> getAllAuthors(){
        return (List<Author>) authorRepository.findAll();
    }

    public Author createNewAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor(int id) throws Exception {

        Author authorToBeDeleted = authorRepository.findById(id).orElse(null);

        if(authorToBeDeleted == null){
            throw new Exception("Finnes ingen author med denne ID");
        }

        authorRepository.delete(authorToBeDeleted);


    }


    public Author updateExistingAuthor(Author updatedAuthor, int id) throws Exception {

        Author authorToBeReplaced = authorRepository.findById(id).orElse(null);

        if(authorToBeReplaced == null){
            throw new Exception("Finnes ingen med denne ID");
        }

        authorToBeReplaced.setFirstname(updatedAuthor.getFirstname());
        authorToBeReplaced.setLastname(updatedAuthor.getLastname());
        authorToBeReplaced.setBooks(updatedAuthor.getBooks());

        return authorRepository.save(authorToBeReplaced);

    }



}
