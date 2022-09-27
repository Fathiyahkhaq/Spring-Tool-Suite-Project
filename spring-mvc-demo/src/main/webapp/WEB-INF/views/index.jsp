<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fathiyah"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Welcome to Database Connector with Spring MVC</p>  
	<p> Test <fathiyah:out value="${greeting}"/></p>
	<h1>Hello, silakan pilih aktivitas yang ingin kamu kerjakan</h1>
	<ul>
	<li> <a href="form.html">Input data diri</a>
	<li> <a href="http://localhost:8081/FormulirProject/select">Melihat tabel Mahasiswa</a>
</body>
</html>