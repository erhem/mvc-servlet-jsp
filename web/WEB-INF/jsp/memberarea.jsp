<%-- 
    Document   : memberarea
    Created on : Jun 15, 2015, 10:50:00 AM
    Author     : Arinda
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<c:choose>
    <c:when test="${sessionScope.sessionlogin == null  &&  empty sessionScope.sessionlogin}">
        <c:redirect url="MemberArea"/>
    </c:when>
</c:choose>
</head>
<body>
<div class="container-luar">
        <!--HEADER-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" style="height:70px">
                <tr>
                    <td width="50%"><a href="#"><img src="resources/css/images/rajajobs-logo.png" style="padding-top:9px; padding-left: 9px;"></a></td>
                    <td width="50%">
                    	<table width="78%" align="right" border="0" cellpadding="0" cellspacing="0" style="height:70px">
                			<tr>
                                
                            	<td class="width-menu border-left">
                                	<a href="MemberArea" class="menu-utama active">
                                    <table border="0" align="center" cellpadding="0" cellspacing="0" style="height:66px; width:43%">
                                    	<tr>
                                            <td width="4%"><img src="resources/css/images/home-icon.png" /></td>
                                            <td width="96%" class="white-font">&nbsp;Home</td>                                        
                                        </tr>
                                    </table>
                                    </a>
                                </td>
                            	<td class="width-menu border-right">                                
                                	<a href="EditProfile" class="menu-utama">
                                    <table border="0" align="center" cellpadding="0" cellspacing="0" style="height:66px; width:74%">
                                    	<tr>
                                            <td width="4%"><img src="resources/css/images/edit-profile-icon.png" /></td>
                                            <td width="96%" class="white-font">&nbsp;Edit Profile</td>                                        
                                        </tr>
                                    </table>
                                    </a>
                                </td>
                            	<td class="width-menu border-right">
                                	<a href="Logout" class="menu-utama">
                                    <table border="0" align="center" cellpadding="0" cellspacing="0" style="height:66px; width:43%">
                                    	<tr>
                                            <td width="4%"><img src="resources/css/images/logout-icon.png" /></td>
                                            <td width="96%" class="white-font">&nbsp;Logout</td>                                        
                                        </tr>
                                    </table>
                                    </a></td>
                            </tr>
                        </table>
                    </td>
				</tr>
        </table>
        <!--end HEADER-->
   
  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bg-content" align="center">
    <tr>
        <td height="10px">
            <div style="font-size: 13px;">
                <c:choose>
                    <c:when test="${success == 1}">
                        <h4 style="color: green; ">${msg}</h4>
                    </c:when>
                    <c:otherwise>
                        <h4 style="color: red;">${msg}</h4>
                    </c:otherwise>
                </c:choose> 
                        
            </div>
        </td>
    </tr>
    <tr>
      <td align="center"><img src="resources/css/images/welcome-team-activity.jpg" /></td>
    </tr>
    <tr>
      <td valign="top"><table align="center" width="83%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="33%" valign="top"><span class="name-welcome" style="color:#333; font-family:arial; font-size:21px">${member.firstName} ${member.lastName}</span><br />
              <span class="address-welcome">${member.city}, ${member.state} , ${member.country}</span> </td>
            <td width="67%" valign="top"><table align="left" width="97%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="29%" class="bdr-bottom-welcome"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="3%"><img src="resources/css/images/username-icon.png" /></td>
                        <td width="97%" class="content-font" style="text-align:left">&nbsp; ${member.username}</td>
                      </tr>
                    </table></td>
                  <td width="31%" class="bdr-bottom-welcome"><table width="85%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <fmt:formatDate value="${member.birthDate}" var="formattedDate"
                        type="date" pattern="dd MMM yyyy" />
                        <td width="3%"><img src="resources/css/images/birth-icon.png" /></td>
                        <td width="97%" class="content-font" style="text-align:left">&nbsp; ${formattedDate} </td>
                      </tr>
                    </table></td>
                  <td width="40%" class="bdr-bottom-welcome"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="3%"><img src="resources/css/images/gender-icon.png" /></td>
                        <td width="97%" class="content-font" style="text-align:left">&nbsp;
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
                    </table></td>
                </tr>
                <tr>
                  <td class="bdr-top-welcome bdr-bottom-welcome"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="3%"><img src="resources/css/images/ipk-icon.png" /></td>
                        <td width="97%" class="content-font" style="text-align:left">&nbsp;${member.gpa}</td>
                      </tr>
                    </table></td>
                  <td class="bdr-top-welcome bdr-bottom-welcome"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="3%"><img src="resources/css/images/skill-icon.png" /></td>
                        <td width="97%" class="content-font" style="text-align:left">&nbsp;
                            <c:choose>
                                <c:when test="${member.skill_Asp == '1'}">
                                    ASP
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${member.skill_Java == '1'}">
                                    Java
                                </c:when>
                            </c:choose>
                            <c:choose>
                                <c:when test="${member.skill_Php == '1'}">
                                    PHP
                                </c:when>
                            </c:choose>
                        </td>
                      </tr>
                    </table></td>
                  <td class="bdr-top-welcome bdr-bottom-welcome">&nbsp;</td>
                </tr>
              </table>
              
              <!--kontak-->
              <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="29%" style="padding:13px 0 7px 0"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="3%"><img src="resources/css/images/telephone.icon.png" /></td>
                        <td width="97%" class="content-font" style="text-align:left">&nbsp; ${member.phoneNumber} </td>
                      </tr>
                    </table></td>
                </tr>                
                <tr>
                  <td width="31%"><table width="85%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="3%"><img src="resources/css/images/email-icon.png" /></td>
                        <td width="97%" class="content-font" style="text-align:left">&nbsp; ${member.email} </td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              <!--end kontak-->
             </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</div>

        <!--FOOTER-->
        <%@include file="footer.jsp" %>
        <!--end FOOTER-->
</body>
</html>
