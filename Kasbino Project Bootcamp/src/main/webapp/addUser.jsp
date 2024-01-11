<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Add Person</title>
</head>
<body>
<h2>Add Person</h2>
<form action="AddPersonServlet" method="post">
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name" required><br>

  <label for="family">Family:</label><br>
  <input type="text" id="family" name="family" required><br><br>

  <input type="submit" value="Submit">
</form>
</body>
</html>
