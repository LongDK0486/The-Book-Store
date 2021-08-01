<%-- 
    Document   : CreateAccount
    Created on : Jun 25, 2021, 8:25:56 AM
    Author     : PRREDETOR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/register.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container register-form">
            <div class="form">
                <div class="note">
                    <p>Register Account</p>
                </div>

                <div class="form-content">
                    <form action="MainController" method="POST">

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your UserID *" name="userID" />
                                ${requestScope.ERROR.userIDERROR}<br/>
                            </div>
                            
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Name *" name="fullName"/>
                                ${requestScope.ERROR.fullnamERROR}<br/>
                            </div>                            
                        </div>                      
                        
                         <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Phone number *" name="phone"/>
                                ${requestScope.ERROR.phoneERROR}<br/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your email *" name="email"/>
                                 ${requestScope.ERROR.emailERROR}<br/>
                            </div>
                         </div>
                            
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Your Password *" name="password"/>
                                ${requestScope.ERROR.passwordERROR}<br/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Confirm Password *" name="confirm"/>
                                ${requestScope.ERROR.confirmERROR}<br/>
                                
                            </div>
                        </div>
                    </div>
                   <input type="submit" name="action" value="CreateAccount"class="btnSubmit"/>
                     </form>
                </div>
            </div>
        </div>
        
       
    </body>
</html>
