<%-- 
    Document   : Createbook
    Created on : Jun 18, 2021, 8:54:05 AM
    Author     : PRREDETOR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="MainController" method="POST">
            Book ID <input type="text" name="bookID" required="true"/><br/>
            ${requestScope.ERROR.bookIDERROR}<br/>  
            
            Book Name <input type="text" name="bookName" required="true"/><br/>
            ${requestScope.ERROR.booknameERROR}<br/>
            
            Author <input type="text" name="author" required="true"/><br/>
            ${requestScope.ERROR.authorERROR}<br/>
            
            Category ID <input type="text" name="cateID" required="true"/><br/>
            ${requestScope.ERROR.cateERROR}<br/>
            
            Description <input type="text" name="descp" required="true"/><br/>
            ${requestScope.ERROR.descriptionERROR}<br/>
            
            Price <input type="text" name="price" required="true"/><br/>
            ${requestScope.ERROR.priceERROR}<br/>
            
            Quantity <input type="text" name="quantity" required="true"/><br/>
            ${requestScope.ERROR.quantityERROR}<br/>
            
            Photo<input type="file" name="photo" /><br/>
             ${requestScope.ERROR.photoERROR}<br/>
             
            
            <input type="submit" name="action" value="Create"/>
            
        </form>
    </body>
</html>
