<%-- 
    Document   : editprofile
    Created on : Jun 17, 2015, 10:43:10 AM
    Author     : Arinda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Team Activity</title>
        <link rel="stylesheet" href="resources/css/team-activity.css" type="text/css" media="screen" />
        <script type="text/javascript" src="resources/js/jquery-1.11.3.js"></script>
        <script type="text/javascript" src="resources/js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
        <link rel="stylesheet" href="resources/js/jquery-ui-1.11.4.custom/jquery-ui.css" />
        <fmt:formatDate value="${member.birthDate}" var="formattedDate" type="date" pattern="dd/MM/yyyy" />
        <c:set var="gender" value="${fn:toLowerCase(member.gender)}" />
        <script>
            $(function() {
              $( "#birthDate" ).datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true,
                    yearRange: "1950:2015" 
              });
            });
            
            window.onload = function(){
                document.getElementById("userName").value = "${member.username}";
                document.getElementById("password").value = "${member.password}";
                document.getElementById("firstName").value = "${member.firstName}";
                document.getElementById("lastName").value = "${member.lastName}";
                document.getElementById("birthDate").value = "${formattedDate}";
                document.getElementById("gender_${gender}").checked = true;
                document.getElementById("phoneNo").value = "${member.phoneNumber}";
                document.getElementById("city").value = "${member.city}";
                document.getElementById("state").value = "${member.state}";
                document.getElementById("country").selectedIndex = 1;
                document.getElementById("gpa").value = "${member.gpa}";
                document.getElementById("email").value = "${member.email}";
                document.getElementById("emailConfirm").value = "${member.email}";
                validate();
                
                document.getElementById("userName_taken").value = false;
                document.getElementById("email_taken").value = false;
            };
            
            function validate() {
                if("${member.skill_Asp}" == 1) {
                    document.getElementById("skill_asp").checked = true;
                } 
                if("${member.skill_Java}" == 1) {
                    document.getElementById("skill_java").checked = true;
                } 
                if("${member.skill_Php}" == 1) {
                    document.getElementById("skill_php").checked = true;
                }
            }
            
            
            var xmlHttp;
            function check_username(inputString) {
                if(inputString.length == 0) {
                    document.getElementById("").innerHtml = "";
                    return;
                }
                try {
                    if(window.XMLHttpRequest) {
                        xmlHttp = new XMLHttpRequest();
                        
                    } else if(window.ActiveXObject) {
                        xmlHttp = new ActiveObject("Microsoft.XMLHTTP");
                    }
                    if(!xmlHttp || xmlHttp == null) {
                        return;
                    }
                    var url = "Validation?userName=" + inputString + "&status=3&currentuserName=${member.username}" ;
                    xmlHttp.onreadystatechange = StateChanged1;
                    xmlHttp.open("GET",url,false); //Synchronous
                    xmlHttp.send();
                } catch (e) {
                    document.getElementById("userNameMessage").innerHTML = "ERROR occured";
                }
            }
            
            function StateChanged1() {
                //alert("response = " + xmlHttp.responseText)
                
                if((xmlHttp.readyState == 4) && (xmlHttp.status == 200)) {
                    //document.getElementById("userNameMessage").innerHTML = xmlHttp.responseText;
                    if(xmlHttp.responseText == 1) {
                        document.getElementById("userName_taken").value = true;
                        document.getElementById("userName_msg").innerHTML = "Sorry, that username already taken";
                    } else {
                        document.getElementById("userName_taken").value = false;   
                    }
                }
                
            }
            
            
            
            function check_email(inputString) {
                if(inputString.length == 0) {
                    document.getElementById("").innerHtml = "";
                    return;
                }
                try {
                    if(window.XMLHttpRequest) {
                        xmlHttp = new XMLHttpRequest();
                        
                    } else if(window.ActiveXObject) {
                        xmlHttp = new ActiveObject("Microsoft.XMLHTTP");
                    }
                    if(!xmlHttp || xmlHttp == null) {
                        return;
                    }
                    var url = "Validation?email=" + inputString + "&status=4&currentemail=${member.email}";
                    xmlHttp.onreadystatechange = StateChanged2;
                    xmlHttp.open("GET",url,false);   //Synchronous
                    xmlHttp.send();
                } catch (e) {
                    document.getElementById("userNameMessage").innerHTML = "ERROR occured";
                }
            }
            
            function StateChanged2() {
                //alert("response = " + xmlHttp.responseText)
                if((xmlHttp.readyState == 4) && (xmlHttp.status == 200)) {
                    //document.getElementById("userNameMessage").innerHTML = xmlHttp.responseText;
                    if(xmlHttp.responseText == 1) {
                        document.getElementById("email_taken").value = true;
                        document.getElementById("email_msg").innerHTML = "Sorry, that email already taken";
                    } else {
                        document.getElementById("email_taken").value = false;   
                    }
                }
            }
            
            
            
            function submitting(){
                var userName = document.getElementById("userName").value;
                var password = document.getElementById("password").value;
                var firstName = document.getElementById("firstName").value;
                var lastName = document.getElementById("lastName").value;
                var birthDate = document.getElementById("birthDate").value;
                var gender_m = document.getElementById("gender_m").checked;
                var gender_f = document.getElementById("gender_f").checked;
                var phoneNo = document.getElementById("phoneNo").value;
                var city = document.getElementById("city").value;
                var state = document.getElementById("state").value;
                var country = document.getElementById("country").value;
                var gpa = document.getElementById("gpa").value;
                var email = document.getElementById("email").value;
                var emailConfirm = document.getElementById("emailConfirm").value;
                var skill_php = document.getElementById("skill_php").checked;
                var skill_java = document.getElementById("skill_java").checked;
                var skill_asp = document.getElementById("skill_asp").checked;
                
                var userName_taken = document.getElementById("userName_taken").value;
                var email_taken = document.getElementById("email_taken").value;

                check_username(userName);
                check_email(email);
                
                //alert("username = " + userName);
                //alert("username_taken = " + userName_taken);
                //alert("email = " + email);
                //alert("email_taken = " + email_taken);
                
                var status = true;
                if(userName === "") {
                    status = false;
                    document.getElementById("userName_msg").innerHTML = "Username must be filled";
                } else if(userName_taken) {
                    status = false;
                    document.getElementById("userName_msg").innerHTML = "Sorry,that username already taken";
                }
                
                if(password === "") {
                    status = false;
                    document.getElementById("password_msg").innerHTML = "Password must be filled";
                }
                
                if(firstName === "") {
                    status = false;
                    document.getElementById("firstName_msg").innerHTML = "First Name must be filled";
                }
                
                if(lastName === "") {
                    status = false;
                    document.getElementById("lastName_msg").innerHTML = "Last Name must be filled";
                }
                
                if(birthDate === "") {
                    status = false;
                    document.getElementById("birthDate_msg").innerHTML = "Birth Date must be filled";
                }
                
                if(gender_m === false && gender_f === false) {
                    status = false;
                    document.getElementById("gender_msg").innerHTML = "Gender must be choosen";
                }
                
                if(phoneNo === "") {
                    status = false;
                    document.getElementById("phoneNo_msg").innerHTML = "Phone Number must be filled";
                }
                
                if(city === "") {
                    status = false;
                    document.getElementById("city_msg").innerHTML = "City must be filled";
                }
                
                if(state == 0) {
                    status = false;
                    document.getElementById("state_msg").innerHTML = "State must be choosen";
                }
                
                if(country == 0) {
                    status = false;
                    document.getElementById("country_msg").innerHTML = "Country must be choosen";
                }
                
                if(gpa === "") {
                    status = false;
                    document.getElementById("gpa_msg").innerHTML = "GPA must be filled";
                }
                
                if(email === "") {
                    status = false;
                    document.getElementById("email_msg").innerHTML = "Email must be filled";
                } else if(email_taken) {
                    status = false;
                    document.getElementById("email_msg").innerHTML = "Sorry,that email already taken";
                }
                
                if(emailConfirm === "") {
                    status = false;
                    document.getElementById("emailConfirm_msg").innerHTML = "Email Confirm must be filled";
                } else {
                    if(email !== emailConfirm) {
                        status = false;
                        document.getElementById("emailConfirm_msg").innerHTML = "Email & Confirm Email have to be equal";
                    }
                }
                
                if(skill_php == false && skill_asp == false && skill_java == false) {
                    status = false;
                    document.getElementById("skill_msg").innerHTML = "Programming Language must be choosen";
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
                var firstName = document.getElementById("firstName");
                var lastName = document.getElementById("lastName");
                var birthDate = document.getElementById("birthDate");
                var gender_m = document.getElementById("gender_m");
                var gender_f = document.getElementById("gender_f");
                var phoneNo = document.getElementById("phoneNo");
                var city = document.getElementById("city");
                var state = document.getElementById("state");
                var country = document.getElementById("country");
                var gpa = document.getElementById("gpa");
                var email = document.getElementById("email");
                var emailConfirm = document.getElementById("emailConfirm");
                var skill_php = document.getElementById("skill_php");
                var skill_java = document.getElementById("skill_java");
                var skill_asp = document.getElementById("skill_asp");
                
                //yang belum validasi username uda ada di database
                
                if(userName == delete_id) {
                    message = document.getElementById("userName_msg");
                } else if(password == delete_id) {
                    message = document.getElementById("password_msg");
                } else if(firstName == delete_id) {
                    message = document.getElementById("firstName_msg");
                } else if(lastName == delete_id) {
                    message = document.getElementById("lastName_msg");
                } else if(birthDate == delete_id) {
                    message = document.getElementById("birthDate_msg"); 
                } else if(gender_m == delete_id || gender_f == delete_id) {
                    message = document.getElementById("gender_msg");
                } else if(phoneNo == delete_id) {
                    message = document.getElementById("phoneNo_msg");
                } else if(city == delete_id) {
                    message = document.getElementById("city_msg");
                } else if(state == delete_id) {
                    message = document.getElementById("state_msg");
                } else if(country == delete_id) {
                    message = document.getElementById("country_msg");
                } else if(gpa == delete_id) {
                    message = document.getElementById("gpa_msg");
                } else if(email == delete_id) {
                    message = document.getElementById("email_msg");
                } else if(emailConfirm == delete_id) {
                    message = document.getElementById("emailConfirm_msg");
                } else if(skill_php == delete_id || skill_asp == delete_id || skill_java == delete_id) {
                    message = document.getElementById("skill_msg");
                }
                //document.getElementById("req_msg").innerHTML = "";
                
                message.innerHTML = msg;
            }
        </script>
        
        <c:if test="${alert!=null && not empty alert}">
            <script> 
            alert('${alert}');
           </script>
        </c:if>
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
                                	<a href="MemberArea" class="menu-utama">
                                    <table border="0" align="center" cellpadding="0" cellspacing="0" style="height:66px; width:43%">
                                    	<tr>
                                            <td width="4%"><img src="resources/css/images/home-icon.png" /></td>
                                            <td width="96%" class="white-font">&nbsp;Home</td> 
                                        </tr>
                                    </table>
                                    </a>
                                </td>
                            	<td class="width-menu">                                
                                	<a href="EditProfile" class="menu-utama active">
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
        
        
        
        
        
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bg-content">
        		<tr><td height="50px"></td></tr>
                <tr><td valign="top" align="center">   
               		 <table width="100%" border="0" cellpadding="0" cellspacing="0">
                     	<tr>
                       	  <td width="38%"><h1 class="title-login" style="text-align:right">Edit Profile</h1></td>
                        	<td width="39%" class="team-activity-01">Team Activity&nbsp;&nbsp; </td>
                          <td width="23%">&nbsp;</td>
                       </tr>
                     </table>
                </td></tr>
                <tr>
                    <td valign="top" align="center">
                            <form name="form" id="form" method="post" action="EditProfile">
                                <input type="hidden" name="idNo" value="${member.idNo}" />
                                <input type="hidden" name="createDate" value="${member.createDate}" />
                            <table border="0" width="100%" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="40%" class="content-font">
                                        Username                       
                                    </td>
                                    <td width="60%">
                                        <input name="userName" type="text" class="form textfield-register margin-bottom-01" id="userName" 
                                        tabindex="1" size="20" maxlength="20" onfocus="delete_msg(this);" onblur="check_username(this.value);"  />
                                        <span id="userName_taken"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="userName_msg"></span><td>
                                </tr>
                                <tr>
                                    <td width="40%" class="content-font">
                                        Password                  
                                    </td>
                                    <td width="60%">
                                        <input name="password" type="password" class="form textfield-register margin-bottom-01" id="password" tabindex="1" size="20" maxlength="20" onfocus="delete_msg(this);"  />
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="password_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        First Name 
                                    </td>
                                    <td>
                                        <input name="firstName" type="text" class="form textfield-register margin-bottom-01" id="firstName" tabindex="4" size="20" maxlength="20" onfocus="delete_msg(this);" />
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="firstName_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        Last Name
                                    </td>
                                    <td>
                                         <input name="lastName" type="text" class="form textfield-register margin-bottom-01" id="lastName" tabindex="5" size="20" maxlength="20" onfocus="delete_msg(this);" />
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="lastName_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        Birth Date
                                    </td>
                                    <td>
                                        <input name="birthDate" type="text" class="form textfield-register margin-bottom-01" id="birthDate" tabindex="6" size="20" maxlength="20" onfocus="delete_msg(this);"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="birthDate_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        Gender
                                    </td>
                                    <td>
                                        <input type="radio" name="gender" id="gender_m" value="M" tabindex="7" onfocus="delete_msg(this);"><span class="content-font" >Male</span>
                                        <input type="radio" name="gender" id="gender_f" value="F" tabindex="8" onfocus="delete_msg(this);"><span class="content-font" >Female</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="gender_msg"></span><td>
                                </tr>
                         		<tr><td height="6px"></td></tr>
                                <tr>
                                    <td class="content-font">
                                        Phone Number
                                    </td>
                                    <td>
                                        <input name="phoneNo" type="text" class="form textfield-register margin-bottom-01" id="phoneNo" tabindex="9" size="20" maxlength="20" onfocus="delete_msg(this);"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="phoneNo_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        City
                                    </td>
                                    <td>
                                        <input type="text" id="city" name="city" tabindex="10" class="textfield-register margin-bottom-01" onfocus="delete_msg(this);"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="city_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        State
                                    </td>
                                    <td>
                                        <select id="state" name="state" tabindex="11" class="input-register margin-bottom-01" onfocus="delete_msg(this);">
                                            <option value="0">----------</option>
                                            <option value="D.I Aceh">D.I Aceh</option>
                                            <option value="Sumatera Utara">Sumatera Utara</option>
                                            <option value="Sumatera Barat">Sumatera Barat</option>
                                            <option value="Riau">Riau</option>
                                            <option value="Jambi">Jambi</option>
                                            <option value="Sumatera Selatan">Sumatera Selatan</option>
                                            <option value="Bengkulu">Bengkulu</option>
                                            <option value="Lampung">Lampung</option>
                                            <option value="Bangka Belitung">Bangka Belitung</option>
                                            <option value="Kepulauan Riau">Kepulauan Riau</option>
                                            <option value="DKI Jakarta">DKI Jakarta</option>
                                            <option value="Jawa Barat">Jawa Barat</option>
                                            <option value="Jawa Tengah">Jawa Tengah</option>
                                            <option value="D.I. Yogyakarta">D.I. Yogyakarta</option>
                                            <option value="Jawa Timur">Jawa Timur</option>
                                            <option value="Banten">Banten</option>
                                            <option value="Bali">Bali</option>
                                            <option value="Nusa Tenggara Barat">Nusa Tenggara Barat</option>
                                            <option value="Nusa Tenggara Timur">Nusa Tenggara Timur</option>
                                            <option value="Kalimantan Barat">Kalimantan Barat</option>
                                            <option value="Kalimantan Tengah">Kalimantan Tengah</option>
                                            <option value="Kalimantan Selatan">Kalimantan Selatan</option>
                                            <option value="Kalimantan Timur">Kalimantan Timur</option>
                                            <option value="Sulawesi Utara">Sulawesi Utara</option>
                                            <option value="Sulawesi Tengah">Sulawesi Tengah</option>
                                            <option value="Sulawesi Selatan">Sulawesi Selatan</option>
                                            <option value="Sulawesi Tenggara">Sulawesi Tenggara</option>
                                            <option value="Gorontalo">Gorontalo</option>
                                            <option value="Sulawesi Barat">Sulawesi Barat</option>
                                            <option value="Maluku">Maluku</option>
                                            <option value="Maluku Utara">Maluku Utara</option>
                                            <option value="Papua Barat">Papua Barat</option>
                                            <option value="Papua">Papua</option>
                                            <option value="Kalimantan Utara">Kalimantan Utara</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="state_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        Country
                                    </td>
                                    <td>
                                        <select id="country" name="country" tabindex="12" class="input-register margin-bottom-01" onfocus="delete_msg(this);">
                                            <option value="0">----------</option>
                                            <option value="1">Indonesia</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="country_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        GPA <!-- numerik -->
                                    </td>
                                    <td>
                                        <input name="gpa" type="text" class="form textfield-register margin-bottom-01" id="gpa" tabindex="13" size="20" maxlength="20" onfocus="delete_msg(this);"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="gpa_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        Email
                                    </td>
                                    <td>
                                        <input name="email" type="text" class="form textfield-register margin-bottom-01" id="email" 
                                        tabindex="14" size="30" maxlength="30" onfocus="delete_msg(this);" onblur="check_email(this.value);" />
                                        <span id="email_taken"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="email_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        Confirm Email
                                    </td>
                                    <td>
                                        <input name="emailConfirm" type="text" class="form textfield-register margin-bottom-01" id="emailConfirm" tabindex="15" size="30" maxlength="30" onfocus="delete_msg(this);"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="emailConfirm_msg"></span><td>
                                </tr>
                                <tr>
                                    <td class="content-font">
                                        Programming Language
                                    </td>
                                    <td>                                        
                                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                    	<tr>
                                        	<td width="14%">
                                            	<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
                                                        <td width="2%"><input type="checkbox" name="skill_asp" id="skill_asp" value="1" tabindex="16" onfocus="delete_msg(this);"></td>
                                                        <td width="88%">&nbsp;<span class="content-font">ASP</span></td>
                                                  </tr>
                                              </table>
                                          </td>
                                        	<td width="14%">                                            
                                           	  <table width="42%" border="0" cellpadding="0" cellspacing="0">
                                              <tr>
                                                        <td width="2%"><input type="checkbox" name="skill_java" id="skill_java" value="1" tabindex="17" onfocus="delete_msg(this);"></td>
                                                        <td width="88%">&nbsp;<span class="content-font">Java</span></td>
                                                  </tr>
                                                </table>
                                          </td>
                                       	  <td width="72%">
               	  <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                    <tr>
                                                        <td width="5%"><input type="checkbox" name="skill_php" id="skill_php" value="1" tabindex="18" onfocus="delete_msg(this);"></td>
                                                      <td width="95%">&nbsp;<span class="content-font">PHP</span></td>
                                    </tr>
                                              </table>
                                          </td>
                                      </tr>
                                       
                                        
                                        

                                    </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2"><span class="error_msg_reg" id="skill_msg"></span><td>
                                </tr>
                                <tr>
                                    <td height="30px">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td><input name="btnSubmit" class="button-login" type="button" value="Submit" onClick="submitting();"></td>
                                </tr>
                                
                                <tr>
                                    <td height="130px">&nbsp;</td>
                                </tr>
                            </table>
                                
                            </form>
                    </td>
                </tr>
        </table>
        </div>
        
        <!--FOOTER-->
        <%@include file="footer-reg-editprofile.jsp" %>
        <!--end FOOTER-->
    </body>
</html>
