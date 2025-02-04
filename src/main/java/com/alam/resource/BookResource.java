package com.alam.resource;

import com.alam.client.BookApiClient;
import com.alam.dto.BookDTO;
import com.alam.model.Book;
import com.alam.repository.BookRepository;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.context.ManagedExecutor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

	@RestClient
	BookApiClient bookApiClient;
	BookRepository bookRepository;
	ManagedExecutor executor;

	public BookResource(BookRepository bookRepository, ManagedExecutor executor) {
		this.bookRepository = bookRepository;
		this.executor = executor;
	}

	@GET
	@Path("/ext-api")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookDTO> getBooksFromExtApi() {
		return bookApiClient.getBooks();
	}

	@POST
	@Path("/import-all")
	public CompletionStage<Void> importAllBookAsync() {
		return executor.runAsync(this::saveBooks);
	}

	@Transactional
	void saveBooks() {
		List<BookDTO> books = bookApiClient.getBooks();
		List<Book> allBooks = books.stream().map(Book::new).toList();
		bookRepository.addAllBooks(allBooks);
	}

	@GET
	@Path("")
	public List<Book> getAllBooks() {
		return bookRepository.listAll();
	}

	@DELETE
	@Path("/remove-all")
	public void removeAllBooks() {
		bookRepository.deleteAllBooks();
	}

}
