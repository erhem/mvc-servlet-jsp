<%-- 
    Document   : editprofile_confirm
    Created on : Jul 22, 2015, 1:32:44 PM
    Author     : Arinda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/team-activity.css" type="text/css" media="screen" /> 
        <title>JSP Page</title>
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
                        	<td width="50%"><h1 class="title-login margin-left-02 reg-confirm">Edit Profile Confirmation</h1></td>
                        </tr>
                     </table>
                </td></tr>
                <tr>
                    <td valign="top" align="center">
                        <form name="form" method="post" action="EditProfileConfirm">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="397" class="content-font break01">
                                        Username :                                    </td>
                                    <td width="477" class="break01">
                                        ${member.username}                                    </td>
                          </tr>
                                <tr>
                                    <td width="397" class="content-font break01">
                                        Password :                                    </td>
                                    <td width="477" class="break01">
                                        ${member.password}                                    </td>
                          </tr>
                                <tr>
                                    <td class="content-font break01">
                                        First Name :
                                    </td>
                                    <td class="break01">
                                        ${member.firstName}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Last Name :
                                    </td>
                                    <td class="break01">
                                        ${member.lastName}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Birth Date :
                                    </td>
                                    <td class="break01">
                                        ${member.birthDate}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Gender :
                                    </td>
                                    <td class="break01">
                                        <c:choose>
                                            <c:when test="${member.gender == 'M'}">
                                                Male
                                            </c:when>
                                            <c:when test="${member.gender == 'F'}">
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
                                        ${member.phoneNumber}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        City :
                                    </td>
                                    <td class="break01">
                                        ${member.city}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        State :
                                    </td>
                                    <td class="break01">
                                        ${member.state}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Country :
                                    </td>
                                    <td class="break01">
                                        ${member.country}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        GPA :<!-- numerik -->
                                    </td>
                                    <td class="break01">
                                        ${member.gpa}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Email :
                                    </td>
                                    <td class="break01">
                                        ${member.email}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="content-font break01">
                                        Programming Language :
                                    </td>
                                    <td class="break01">
                                        <c:choose>
                                            <c:when test="${member.skill_Asp=='1'}">
                                                ASP
                                            </c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${member.skill_Java=='1'}">
                                                Java
                                            </c:when>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${member.skill_Php=='1'}">
                                                PHP
                                            </c:when>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="hidden" name="userName" value="${member.username}" />
                                        <input type="hidden" name="password" value="${member.password}" />
                                        <input type="hidden" name="firstName" value="${member.firstName}" />
                                        <input type="hidden" name="lastName" value="${member.lastName}" />
                                        <input type="hidden" name="birthDate" value="${member.birthDate}" />
                                        <input type="hidden" name="gender" value="${member.gender}" />
                                        <input type="hidden" name="phoneNumber" value="${member.phoneNumber}" />
                                        <input type="hidden" name="email" value="${member.email}" />
                                        <input type="hidden" name="skill_asp" value="${member.skill_Asp}" />
                                        <input type="hidden" name="skill_java" value="${member.skill_Java}" />
                                        <input type="hidden" name="skill_php" value="${member.skill_Php}" />
                                        <input type="hidden" name="gpa" value="${member.gpa}" />
                                        <input type="hidden" name="country" value="${member.country}" />
                                        <input type="hidden" name="state" value="${member.state}" />
                                        <input type="hidden" name="city" value="${member.city}" />
                                        <input type="hidden" name="idNo" value="${member.idNo}" />
                                        <input type="hidden" name="createDate" value="${member.createDate}" />
                                   <!-- <input type="hidden" name="currentDate" value="" /> -->
                                        
                                                                              
                                        
                                    </td>
                                    <td>&nbsp;
                                        
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center" style="padding-right: 71px;">                                    
                                    <input name="submit" type="submit" value="Submit" class="button-login"> <button name="goback" type="button" value="Back" onClick="history.back();" class="button-login" style="width:77px"/>Back</button></td>
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
