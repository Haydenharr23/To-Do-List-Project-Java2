<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To DO LIST</title>
</head>
<body>
<p> 
${taskList.getName()} <br />
${taskList.getDescription()} <br />
</p>
           
<a href="index.jsp">Add another task</a>
       
</body>
</html>