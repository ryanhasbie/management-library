package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.BorrowBook;
import com.ryan.managementlibrary.models.dto.BorrowBookDto;
import com.ryan.managementlibrary.models.mappers.BorrowBookMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BorrowBookRepositoryImpl implements BorrowBookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BorrowBookRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<BorrowBookDto> getAll() throws Exception {
        try {
            String sqlGetAll = "SELECT * FROM t_user tu " +
                    "LEFT JOIN t_borrow_book tbw " + "ON tu.user_id = tbw.user_id " + "LEFT JOIN t_book tb "
                    + "ON tbw.book_id = tb.book_id";
            return jdbcTemplate.query(sqlGetAll, new BorrowBookMapper());
        } catch (DataAccessException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public BorrowBook create(BorrowBook borrowBook) throws Exception {
        try {
            String sqlInsertBorrow = "INSERT INTO t_borrow_book(date, user_id, book_id, status_borrow) VALUES(?,?,?,?)";
            int result = jdbcTemplate.update(sqlInsertBorrow, borrowBook.getDate(), borrowBook.getUserId(), borrowBook.getBookId(), borrowBook.getStatus());
            if (result <= 0) {
                throw new Exception("Failed to create borrow book!");
            }
            return borrowBook;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<BorrowBookDto> findById(Integer id) throws Exception {
        try {
            String sqlFindById = "SELECT * FROM t_borrow_book WHERE borrowbook_id = ?";
            BorrowBookDto borrowBookDto = jdbcTemplate.queryForObject(sqlFindById, new BorrowBookMapper(), new Object[]{id});
            return Optional.ofNullable(borrowBookDto);
        } catch (DataAccessException e) {
            throw new Exception("Id borrow a book not found!");
        }
    }

    @Override
    public Optional<BorrowBook> get(Integer id) throws Exception {
        try {
            String sqlGet = "SELECT * FROM t_borrow_book WHERE borrowbook_id = ?";
            BorrowBook borrowBook = jdbcTemplate.queryForObject(sqlGet, new Object[]{id}, new RowMapper<BorrowBook>() {
                @Override
                public BorrowBook mapRow(ResultSet rs, int rowNum) throws SQLException {
                    BorrowBook borrowBookMapper = new BorrowBook();
                    borrowBookMapper.setBorrowBookid(rs.getInt("borrowbook_id"));
                    borrowBookMapper.setDate(rs.getDate("date"));
                    borrowBookMapper.setUserId(rs.getInt("user_id"));
                    borrowBookMapper.setBookId(rs.getInt("book_id"));
                    borrowBookMapper.setStatus(rs.getString("status_borrow"));
                    return borrowBookMapper;
                }
            });
            return Optional.ofNullable(borrowBook);
        } catch (DataAccessException e) {
            throw new Exception("Id borrow a book not found!");
        }
    }

    @Override
    public void update(BorrowBook borrowBook, Integer id) throws Exception {
        try {
            String sqlUpdate = "UPDATE t_borrow_book SET date = ?, user_id = ?, book_id = ?, status_borrow = ? WHERE borrowbook_id = ?";
            jdbcTemplate.update(sqlUpdate, borrowBook.getDate(), borrowBook.getUserId(), borrowBook.getBookId(), borrowBook.getStatus(), id);
        } catch (DataAccessException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            String sqlDelete = "delete from t_borrow_book where borrowbook_id = ?";
            jdbcTemplate.update(sqlDelete, id);
        } catch (DataAccessException e) {
            throw new Exception(e.getMessage());
        }
    }
}
