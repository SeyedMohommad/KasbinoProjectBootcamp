package com.example.kasbinoprojectbootcamp;

import com.example.kasbinoprojectbootcamp.common.JDBC;
import com.example.kasbinoprojectbootcamp.entity.Person;
import com.example.kasbinoprojectbootcamp.service.PersonService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;

@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet {
    private Connection connection;
    private Properties configProps;


    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        JDBC.loadConfiguration(context);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String family = request.getParameter("family");
        Person person = new Person(name, family);
        try {
            PersonService.getPersonService().save(person);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
