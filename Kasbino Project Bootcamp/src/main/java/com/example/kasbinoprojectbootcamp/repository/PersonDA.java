package com.example.kasbinoprojectbootcamp.repository;



import com.example.kasbinoprojectbootcamp.common.JDBC;
import com.example.kasbinoprojectbootcamp.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA() throws Exception {
        connection = JDBC.getConnection();
    }

    public void insert(Person person) throws SQLException {
        String insertSQL = "INSERT INTO persons (name, family) VALUES (?, ?)";

        preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());

        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            long newId = rs.getLong(1);
            person.setId(newId);
        }
    }




    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
