<%-- 
    Document   : Shoppingpage1
    Created on : Jun 30, 2021, 10:17:21 AM
    Author     : PRREDETOR
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="Css/Shopping.css"/>
         <link rel="stylesheet" href="Css/Button.css"/>
        <title>Shopping Page</title>
    </head>
    <body>
        
        <form action="MainController">
            <h1>Hello  ${sessionScope.LOGIN_USER.name}</h1>
            <button type="submit" name="action" value="Logout" class="btn btn-danger btn-lg btn3d"><span class="glyphicon glyphicon-off"></span> Logout</button>            
            </br>
            </br>
        </form>
        <form action="MainController">
            <button type="submit" name="action" value="History" class="btn btn-primary btn-lg btn3d"><span class="glyphicon glyphicon-cloud"></span> History</button>          
            <input type="hidden" name="UserID" value="${sessionScope.LOGIN_USER.id}" />
            </br>
            </br>
        </form>

        <form action="MainController">
            <button type="submit"  name="action" value="login" class="btn btn-success btn-lg btn3d"><span class="glyphicon glyphicon-ok"></span> Login</button>
            </br>
            </br>
        </form>

        <form action="MainController">
            <button type="submit"  name="action" value="Viewcart" class="btn btn-info btn-lg btn3d"><span class="glyphicon glyphicon-shopping-cart"></span> View Cart</button>
            </br>
            </br>
        </form>

        
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
              Search Price<input type="text" name="Searchprice" value="${param.Searchprice}"/>
              <p>
                  <button type="submit" name="action" value="Search" class="btn btn-default btn-lg btn3d">Search</button>
              </p>
             
        </form>              
              <div class="container">
                  <div class="row">
                      <div class="col-md-12">
                          <c:if test="${requestScope.List_Item !=null}">
                              <c:if test="${not empty requestScope.List_Item}">
                                  <c:forEach var="book" varStatus="counter" items="${requestScope.List_Item}">
                                      <form action="MainController">
                                          <div class="col-xs-12 col-sm-6 col-md-3">
                                              <div class="thumbnail" >
                                                  <img src="image/${book.image}" class="img-responsive">
                                                  <div class="caption">
                                                      <div class="row">
                                                          <h3>${book.bookName}</h3>
                                                          <h4>
                                                              Category:<c:forEach var="cateid" items="${sessionScope.Category}">
                                                                  <c:if test="${(cateid.cateid)==(book.cateID)}">
                                                                      ${cateid.catename}
                                                                  </c:if>                                       
                                                              </c:forEach>
                                                          </h4>
                                                          <h4>Write by:${book.author}</h4>
                                                          <h5>Description: ${book.description}</h5>
                                                          <div class="col-md-4 col-sm-4 col-xs-4 price">
                                                              <h3 style="margin:6px auto;"><label>${book.price}</label></h3>
                                                          </div>
                                                          <div class="col-md-8 col-sm-8 col-xs-8">
                                                              <c:url var="add" value="MainController">
                                                                  <c:param name="action" value="Addtocart"></c:param>                                                                           
                                                                  <c:param name="Bookid" value="${book.bookID}"></c:param> 
                                                                  <c:param name="Bookname" value="${book.bookName}"></c:param> 
                                                                  <c:param name="CateID" value="${book.cateID}"></c:param> 
                                                                  <c:param name="price" value="${book.price}"></c:param> 
                                                                  <c:param name="image" value="${book.image}"></c:param>
                                                              </c:url>                                            
                                                              <a href="${add}" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
                                                          </div>
                                                      </div>

                                                      <p> </p>
                                                  </div>
                                              </div>
                                          </div>
                                      </form>
                                  </c:forEach>
                              </c:if>
                          </c:if>
                      </div>
                  </div>
              </div>
                        
             
         
    </body>
</html>
