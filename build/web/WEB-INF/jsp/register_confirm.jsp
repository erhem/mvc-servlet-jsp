<%-- 
    Document   : register_confirm
    Created on : Jul 22, 2015, 1:32:22 PM
    Author     : Arinda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team Activity</title>               
        <link rel="stylesheet" href="resources/css/team-activity.css" type="text/css" media="screen" /> 
    </head>
    <body>
    	<div class="container-luar">        
        <!--HEADER-->
        <%@include file="includeHead.jsp" %>
        <!--end HEADER-->
        
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bg-content">
        		<tr><td height="50px"></td></tr>
                <tr><td valign="top" align="center" style="height:45px">   
               		 <table width="100%" border="0" cellpadding="0" cellspacing="0">
                     	<tr>
                        	<td width="50%"><h1 class="title-login margin-left-02 reg-confirm">Registration Confirmation</h1></td>
                       </tr>
                     </table>
                </td></tr>
                <tr>
                    <td valign="top" align="center">
                        <form name="form" method="post" action="RegistrationConfirm">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="400" class="content-font break01">
                                        Username :                                    
                                    </td>
                                    <td width="474" class="break01">
                                        ${biodata.username}
                                    </td>
                          </tr>
                                <tr>
                                    <td class="content-font break01">
                                        First Name :
                                    </td>
                                    <td class="break01">
                                        ${biodata.firstName}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Last Name :
                                    </td>
                                    <td class="break01">
                                        ${biodata.lastName}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Birth Date :
                                    </td>
                                    <td class="break01">
                                        <%--${biodata.birthDate}--%>
                                        <fmt:formatDate value="${biodata.birthDate}" var="formattedDate"
                                        type="date" pattern="dd MMMMM yyyy" />
                                        ${formattedDate}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Gender :
                                    </td>
                                    <td class="break01">
                                        <c:choose>
                                            <c:when test="${biodata.gender == 'M'}">
                                                Male
                                            </c:when>
                                            <c:when test="${biodata.gender == 'F'}">
                                                Female
                                            </c:when>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Phone Number :
                                    </td>
                                    <td class="break01">
                                        ${biodata.phoneNumber}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        City :
                                    </td>
                                    <td class="break01">
                                        ${biodata.city}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        State :
                                    </td>
                                    <td class="break01">
                                        ${biodata.state}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Country :
                                    </td>
                                    <td class="break01">
                                        <%-- ${biodata.country} --%>
                                        ${biodata.country}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        GPA :<!-- numerik -->
                                    </td>
                                    <td class="break01">
                                        ${biodata.gpa}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Email :
                                    </td>
                                    <td class="break01">
                                        ${biodata.email}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Programming Language :
                                    </td>
                                    <td class="break01">
                                        <c:choose>
                                            <c:when test="${biodata.skill_Asp == '1'}">
                                                ASP
                                            </c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${biodata.skill_Java == '1'}">
                                                Java
                                            </c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${biodata.skill_Php == '1'}">
                                                PHP
                                            </c:when>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        
                                    </td>
                                    <td>&nbsp;
                                        
                                    </td>
                                </tr>
                                <tr>
                                    <input type="hidden" name="userName" value="${biodata.username}" />
                                    <input type="hidden" name="firstName" value="${biodata.firstName}" />
                                    <input type="hidden" name="lastName" value="${biodata.lastName}" />
                                    <input type="hidden" name="birthDate" value="${biodata.birthDate}" />
                                    <input type="hidden" name="gender" value="${biodata.gender}" />
                                    <input type="hidden" name="phoneNumber" value="${biodata.phoneNumber}" />
                                    <input type="hidden" name="city" value="${biodata.city}" />
                                    <input type="hidden" name="state" value="${biodata.state}" />
                                    <input type="hidden" name="country" value="${biodata.country}" />
                                    <input type="hidden" name="gpa" value="${biodata.gpa}" />
                                    <input type="hidden" name="email" value="${biodata.email}" />
                                    <input type="hidden" name="password" value="${biodata.password}" />
                                    <input type="hidden" name="skill_asp" value="${biodata.skill_Asp}" />
                                    <input type="hidden" name="skill_java" value="${biodata.skill_Java}" />
                                    <input type="hidden" name="skill_php" value="${biodata.skill_Php}" />
                               <!-- <input type="hidden" name="createDate" value="" /> 
                                    <input type="hidden" name="updateDate" value="" /> -->
                                    <td colspan="2" align="center" style="padding-right: 65px;">                                    
                                    <input name="submit" type="submit" value="Register" class="button-login"> <button name="goback" type="button" value="Back" onClick="history.back();" class="button-login" style="width:77px"/>Back</button></td>
                                </tr>
                            </table>
                                    </form>
                    
                    </td>
                </tr>
        </table>
        </div>
                
        
        <!--FOOTER-->
        <%@include file="footer.jsp" %>
        <!--end FOOTER-->
    </body>
</html>
