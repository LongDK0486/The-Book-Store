<%-- 
    Document   : History
    Created on : Jun 27, 2021, 5:16:27 PM
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
        <h1>Welcome : ${sessionScope.LOGIN_USER.name}</h1>
         
        <form action="MainController">          
            Search by date<input type="date" name="Date" value="${param.Date}"placeholder="enter day follow format yyyy-MM-dd" size="50"/>
             <input type="hidden" name="id" value="${sessionScope.LOGIN_USER.id}"/>
             <input type="submit" name="action" value="SearchDay"/>
        </form>
       
             <c:if test="${requestScope.List_History !=null}">
            <c:if test="${not empty requestScope.List_History}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Book Name</th>
                            <th>Price</th>
                            <th>quantity</th>
                            <th>Total of book</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" varStatus="counter" items="${requestScope.List_History}">                       
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    <c:forEach var="bookid" items="${sessionScope.Book}">
                                        <c:if test="${(bookid.bookID)==(book.bookID)}">
                                            ${bookid.bookName}
                                        </c:if>                                       
                                    </c:forEach>
                                    
                                </td>
                                <td>
                                    ${book.price}
                                </td>                               
                                <td>
                                    ${book.quantity}
                                </td>
                                <td>${book.total}</td>
                                <td>${book.oderdate}</td>
                                
                            </tr>

                        </form>
                    </c:forEach>                                                   
                </tbody>
            </table>

        </c:if>
    </c:if>
             <a href="Shoppingpage1.jsp">Continue Shopping</a>
    </body>
</html>
