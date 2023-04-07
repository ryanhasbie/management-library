package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.mappers.BookMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository{

    private final JdbcTemplate jdbcTemplate;

    public BookRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Book> getAll() throws Exception {
        try {
            String SqlGetAll = "SELECT * FROM t_book";
            return jdbcTemplate.query(SqlGetAll, new BookMapper());
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Book create(Book book) throws Exception {
        try {
            String SqlInsert = "INSERT INTO t_book(title, author, publisher, status) VALUES (?,?,?,?)";
            int result = jdbcTemplate.update(SqlInsert, book.getTitle(), book.getAuthor(), book.getPublisher(), book.getStatus());
            if (result<= 0) {
                throw new Exception("Failed create book!");
            }
            return book;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Book> findById(Integer id) throws Exception {
        try {
            String sqlFindById = "SELECT * FROM t_book WHERE book_id = ?";
            Book book = jdbcTemplate.queryForObject(sqlFindById, new BookMapper(), new Object[]{id});
            return Optional.ofNullable(book);
        } catch (DataAccessException e) {
            throw new Exception("Id Book Not Found!");
        }
    }

    @Override
    public void update(Book book, Integer id) throws Exception {
        try {
            String SqlUpdate = "UPDATE t_book SET title = ?, author = ?, publisher = ?, status = ? WHERE book_id = ?";
            jdbcTemplate.update(SqlUpdate, book.getTitle(), book.getAuthor(), book.getPublisher(), book.getStatus(), id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            String SqlDelete = "DELETE FROM t_book WHERE book_id = ?";
            jdbcTemplate.update(SqlDelete, id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void updateStatusOnly(Book book, Integer id) throws Exception {
        try {
            String SqlUpdateStatus = "UPDATE t_book SET status = ? WHERE book_id = ?";
            jdbcTemplate.update(SqlUpdateStatus, book.getStatus(), id);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
