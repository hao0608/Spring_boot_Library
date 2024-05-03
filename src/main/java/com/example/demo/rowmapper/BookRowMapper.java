package com.example.demo.rowmapper;

import com.example.demo.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book>{
     @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setBookId(resultSet.getInt("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setImageUrl(resultSet.getString("image_url"));
        book.setPrice(resultSet.getInt("price"));
        book.setPublishedDate(resultSet.getTimestamp("published_date"));
        book.setCreatedDate(resultSet.getTimestamp("created_date"));
        book.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return book;
    }
}
