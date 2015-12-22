<%-- 
    Document   : index
    Created on : Jun 15, 2015, 9:52:07 AM
    Author     : Arinda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team Activity</title>               
        <link rel="stylesheet" href="resources/css/team-activity.css" type="text/css" media="screen" /> 
        <c:if test="${alert!=null && not empty alert}">
            <script> 
            alert('${alert}');
           </script>
        </c:if>
        <script>
            function submitting() {
                var userName = document.getElementById("userName").value;
                var password = document.getElementById("password").value;
                
                var status = true;
                if(userName === "") {
                    status = false;
                    document.getElementById("userName_msg").innerHTML = "Username must be filled";
                }
                
                if(password === "") {
                    status = false;
                    document.getElementById("password_msg").innerHTML = "Password must be filled";
                }
                
                if(!status) {
                    alert("Please check your data");
                } else {
                    document.getElementById("form").submit();
                }
            }
            
            function delete_msg(delete_id) {
                var msg = "";
                var message ;
                var userName = document.getElementById("userName");
                var password = document.getElementById("password");
                
                if(userName == delete_id) {
                    message = document.getElementById("userName_msg");
                } else if(password == delete_id) {
                    message = document.getElementById("password_msg");
                }
                document.getElementById("req_msg").innerHTML = "";
                
                message.innerHTML = msg;
            }
        </script>
        <c:choose>
            <c:when test="${sessionScope.sessionlogin != null  && not empty sessionScope.sessionlogin}">
                <c:redirect url="MemberArea"/>
            </c:when>
        </c:choose>
    </head>
    <body>
    	<div class="container-luar">
        <!--HEADER-->
        <%@include file="includeHead.jsp" %>
        <!--end HEADER-->
                
                
                
                
                
                
                
                
                
                
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bg-content">
        		<tr><td height="50px"></td></tr>
                <tr>
                    <td valign="top" align="center">
                    <h1 class="title-login margin-left-01">Team Activity Login</h1>
                    <div align="center">
                        <form name="form" id="form" method="post" action="LoginServlet">
                        <table align="center" width="40%" border="0" cellpadding="0" cellspacing="0">
                            <tr><td colspan="2" height="9px"></td></tr>
                            <tr>
                                <td class="content-font">
                                    Username
                                </td>
                                <td>
                                    <input name="userName" type="text" class="form textfield-css" id="userName" tabindex="1" size="20" maxlength="20" onfocus="delete_msg(this);"/>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td colspan="2"><span class="error_msg_reg" id="userName_msg"></span><td>
                            </tr>
                            <tr><td colspan="2" height="5px"></td></tr>
                            <tr>
                                <td class="content-font">
                                    Password
                                </td>
                                <td>
                                    <input name="password" type="password" class="form textfield-css" id="password" tabindex="2" size="20" maxlength="20" onfocus="delete_msg(this);" />
                                </td>
                            </tr>   
                            <tr>
                                <td></td>
                                <td colspan="2"><span class="error_msg_reg" id="password_msg"></span><td>
                            </tr>
                            <tr><td colspan="2" height="15px"></td></tr>
                            <tr>
                                <td>
                                    
                                </td>
                                <td>
                                    <input name="btnSubmit" type="button" value="Login" class="button-login" onClick="submitting();"> &nbsp;<span class="batas">|</span>&nbsp;<a href="Registration" class="register-font">Register</a>
                                </td>
                            </tr>
                        </table>
                        </form>
                        <c:choose>
                            <c:when test="${not empty requestScope.msg}">
                                <c:choose>
                                    <c:when test="${requestScope.from == register}">
                                        <div id="req_msg"><h4 style="color: green;">${requestScope.msg}</h4></div>
                                     </c:when>
                                     <c:otherwise>
                                        <div id="req_msg"><h4 style="color: red;">${requestScope.msg}</h4></div>
                                     </c:otherwise>
                                </c:choose>
                            </c:when>
                        </c:choose>
                    </div>
                    </td>
                </tr>
        </table>        
        
        
        
        
        
        </div>
        
        <!--FOOTER-->
        <%@include file="footer.jsp" %>
        <!--end FOOTER-->
                

    </body>
</html>
