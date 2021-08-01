<%-- 
    Document   : LoginAdmin
    Created on : Jun 17, 2021, 8:42:24 AM
    Author     : PRREDETOR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/Login.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper fadeInDown zero-raduis">
  	  <div id="formContent">
  	    <!-- Tabs Titles -->

  	    <!-- Icon -->
  	    <div class="fadeIn first">
  	      <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" /> 
  	      <h2 class="my-5">Sign In</h2>
  	    </div>
  	    <!-- Login Form -->
  	    <form  action="MainController" method="POST">
  	      <input type="text" id="email" class="fadeIn second zero-raduis" name="userID" placeholder="User  ID">
              <input type="password" id="password" class="fadeIn third zero-raduis" name="password" placeholder="password">
		      <div id="formFooter">
  	      	<a class="underlineHover" href="#">Forgot Password?</a>
  	      </div>
              <input type="submit" class="fadeIn fourth zero-raduis" name="action"  value="Login">
  	      <h2>You don't have a account ?</h2>
  	      <a href="CreateAccount.jsp"  class="fadeIn fourth zero-raduis pc">Create account</a>
  	    </form>
  	    

  	  </div>
  </div>
        
       
    </body>
</html>
