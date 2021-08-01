<%-- 
    Document   : UpdateBook
    Created on : Jun 24, 2021, 9:55:42 AM
    Author     : PRREDETOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController">
            Book ID<input type="text" name="BookID" value="${param.bookid}"readonly=""/>
            Book Name<input type="text" name="BookName" value="${param.bookname}"required="true"/>
            Author<input type="text" name="Author" value="${param.author}"required="true"/>
            Category ID <input type="text" name="CateID" value="${param.cateid}"required="true"/>
            Description<input type="text" name="Descp" value="${param.descp}"required="true"/>
             Quantity<input type="text" name="Quantity" value="${param.quantity}"required="true"/>
            Price<input type="text" name="Price" value="${param.price}"required="true"/>
            Picture<input type="file" name="picture" value="${param.image}"required="true"/>
            <input type="hidden" name="search" value="${param.search}"required="true">
            <input type="submit" name="action" value="Confirm"/> 
        </form>      
    </body>
</html>
