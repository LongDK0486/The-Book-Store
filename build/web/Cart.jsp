<%-- 
    Document   : Cart
    Created on : Jun 22, 2021, 8:30:39 AM
    Author     : PRREDETOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.Cart ==null}">
            <h1>Cart empty</h1>
            <a href="Shoppingpage1.jsp"> Continue Shopping</a>
        </c:if>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-10 col-md-offset-1">
                         <c:if test="${sessionScope.Cart !=null}">
                <c:if test="${not empty sessionScope.Cart}">
                    <table  class="table table-hover">
                        <thead>
                            <tr>                                            
                                <th>Product</th>
                                <th>Quantity</th>
                                <th class="text-center">Price</th
                                <th class="text-center">Total price of each product</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="Total" value="${0}"/>                      
                            <c:set var="cac" value="${sessionScope.Cart}"/> 
                            <c:forEach var="book" items="${cac.cart}">
                                <c:set var="Total" value="${Total+(book.value.price)*(book.value.quantity)}"/>
                            <form action="MainController">                        
                                <tr>
                                    <td class="col-sm-8 col-md-6">
                                        <div class="media">
                                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="image/${book.value.image}" style="width: 72px; height: 72px;"> </a>
                                            <div class="media-body">
                                                <h4 class="media-heading"><a href="#">${book.key}</a></h4>
                                                <h5 class="media-heading"> Book Name: <a href="#">${book.value.bookName}</a></h5>
                                            </div>
                                        </div>

                                    </td>

                                    <td class="col-sm-1 col-md-1" style="text-align: center">
                                        <input type="number" name="quantity" value="${book.value.quantity}"required="true" class="form-control" id="exampleInputEmail1"/>
                                    </td>
                                    <td class="col-sm-1 col-md-1 text-center">${book.value.price}</td>
                                    <td class="col-sm-1 col-md-1 text-center">
                                        ${(book.value.price)*(book.value.quantity)}
                                    </td>

                                    <td class="col-sm-1 col-md-1">  
                                        
                                            <span class="glyphicon glyphicon-remove">
                                               
                                            </span>  <c:url var="deletecart" value="MainController">
                                                    <c:param name="action" value="DeleteCart"/>
                                                    <c:param name="bookid" value="${book.key}"/>
                                                </c:url>
                                                <a href="${deletecart}">Delete</a> 
                                            
                                                                                                               
                                    </td>
                                    <td class="col-sm-1 col-md-1">
                                        <input type="submit" name="action" value="UpdateBook"/>
                                        <input type="hidden" name="Bookid" value="${book.key}"/>                                
                                    </td>

                                </tr>
                            </form>
                        </c:forEach>  
                        <tr>

                            <td>   </td>
                            <td>   </td>
                            <td>   </td>
                            <td><h3>Total</h3></td>
                            <td class="text-right"><h3><strong><c:out value="${Total}"/></strong></h3></td>

                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td>   </td>
                            <td>
                                
                                    <span class="glyphicon glyphicon-shopping-cart">
                                        
                                    </span> <a href="Shoppingpage1.jsp"> Continue Shopping</a>
                           </td>
                            <td>
                               
                                    <span class="glyphicon glyphicon-play">
                                       
                                    </span> <c:url var="checkout" value="MainController">
                                            <c:param name="action" value="Checkout"/>                           
                                        </c:url>
                                        <a href="${checkout}">Check out</a> 
                            </td>
                        </tr>
                    </tbody>
                </table> 
          </c:if>
    </c:if>
                    </div>
                </div>
            </div>    
           
                        
</body>
</html>
