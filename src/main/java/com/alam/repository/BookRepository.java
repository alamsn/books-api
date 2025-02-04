package com.alam.repository;

import com.alam.model.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BookRepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<Book> listAll() {
		return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}

	@Transactional
	public void addBooks(Book book) {
		entityManager.persist(book);
	}

	@Transactional
	public void addAllBooks(List<Book> books) {
		books.forEach(entityManager::persist);
	}

	@Transactional
	public void deleteAllBooks() {
		entityManager.createQuery("DELETE FROM Book").executeUpdate();
	}
}
