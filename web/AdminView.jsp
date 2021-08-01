<%-- 
    Document   : AdminView
    Created on : Jun 24, 2021, 7:40:11 AM
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
        <h1>Hello  ${sessionScope.LOGIN_USER.name}</h1>
        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>
        <a href="Creatediscountcode.jsp">Create discount code</a>
        <form action="MainController">
            Search Name<input type="text" name="Searchname" value="${param.Searchname}"/>
            <c:set var="cate" value="${sessionScope.Category}"/>
            Category <select name="SearchCate">
                <option value="0">ALL</option>
                <c:forEach var="cateca" items="${cate}">
                    <option value="${cateca.cateid}" 
                            <c:if test="${param.SearchCate==cateca.cateid}">
                                selected=""
                            </c:if>      
                            >
                        ${cateca.catename}
                    </option>
                </c:forEach> 
            </select>
            <input type="submit"  name="action" value="SearchBook"/>
        </form>
        <a href="Createbook.jsp">Create book</a>
         <c:if test="${requestScope.List_Book !=null}">
             <c:if test="${not empty requestScope.List_Book}">
                 <table border="1">
                     <thead>
                         <tr>
                             <th>No</th>
                             <th>Book ID</th>
                             <th>Name</th>
                             <th>author</th>
                             <th>Category ID</th>
                             <th>Category Name</th>
                             <th>Description</th>
                             <th>quantity</th>
                             <th>Price</th>
                             <th>Image</th>
                         </tr>
                     </thead>
                     <tbody>
                         <c:forEach var="book" varStatus="counter" items="${requestScope.List_Book}">                       
                         <form action="MainController">
                             <tr>
                                 <td>${counter.count}</td>
                                 <td>${book.bookID}</td>
                                 <td>${book.bookName}</td>
                                 <td>${book.author}</td>
                                 <td>${book.cateID}</td>
                                 <td>
                                     <c:forEach var="cateid" items="${sessionScope.Category}">
                                        <c:if test="${(cateid.cateid)==(book.cateID)}">
                                            ${cateid.catename}
                                        </c:if>                                       
                                    </c:forEach>
                                     
                                 </td>
                                 <td>${book.description}</td>
                                 <td>${book.quantity}</td>
                                 <td>${book.price}</td>
                                 <td><img src="image/${book.image}" width="200"></td>
                                 <td>
                                     <c:url var="delete" value="MainController">
                                        <c:param name="action" value="Delete"></c:param>                                                                           
                                        <c:param name="bookid" value="${book.bookID}"></c:param>                                                                      
                                    </c:url>
                                    <a href="${delete}">Delete</a>
                                 </td>
                                 <td>
                                     <c:url var="update" value="MainController">
                                        <c:param name="action" value="UpdateBookAdmin"></c:param>                                                                           
                                        <c:param name="bookid" value="${book.bookID}"></c:param> 
                                        <c:param name="bookname" value="${book.bookName}"></c:param> 
                                        <c:param name="author" value="${book.author}"></c:param> 
                                        <c:param name="cateid" value="${book.cateID}"></c:param> 
                                        <c:param name="descp" value="${book.description}"></c:param>
                                        <c:param name="quantity" value="${book.quantity}"></c:param>
                                        <c:param name="price" value="${book.price}"></c:param>
                                        <c:param name="image" value="${book.image}"></c:param>
                                    </c:url>
                                    <a href="${update}">Update</a>
                                 </td>
                             </tr>
                         </form>
                     </c:forEach>             
                     </tbody>
                 </table>

             </c:if>
         </c:if>
    </body>
</html>
