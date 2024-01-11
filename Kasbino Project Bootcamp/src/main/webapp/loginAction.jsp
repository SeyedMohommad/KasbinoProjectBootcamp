<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Action</title>
</head>
<body>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.IOException" %>
<%
  String path = "/WEB-INF/config.properties";
  Properties properties = new Properties();
  try {
    properties.load(new FileInputStream(path));
  }catch (IOException e){
    e.printStackTrace();
  }
  String username = properties.getProperty("username");
  String password = properties.getProperty("password");
  Boolean isValidUser = false;
  if(username == username && password == password) {
    isValidUser = true;
  }

  if(isValidUser) {
    response.sendRedirect("addUser.jsp");
  } else {
    out.println("<script type='text/javascript'>");
    out.println("alert('User or password incorrect');");
    out.println("location='login.jsp';");
    out.println("</script>");
  }

%>
</body>
</html>
