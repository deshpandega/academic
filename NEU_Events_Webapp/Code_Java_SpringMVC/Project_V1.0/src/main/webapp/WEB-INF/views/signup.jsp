<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sign Up</title>
	<link rel="stylesheet" href="resources/css/material.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="resources/css/read.css">
    <style>
		#view-source {
        	position: fixed;
        	display: block;
        	right: 0;
        	bottom: 0;
        	margin-right: 40px;
        	margin-bottom: 40px;
			z-index: 900;
        }
    </style>
</head>
<body>
<div class="mdl-layout__container">
	<div class="mdl-layout mdl-layout--fixed-header mdl-js-layout mdl-color--grey-100 has-tabs is-upgraded" data-upgraded=",MaterialLayout">
		<jsp:include page="../views/header.jsp" />
		<main class="mdl-layout__content">
			<div class="mdl-layout__tab-panel is-active" style="height: 100%;">
				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width:50% ; float:right; width: 100%; height: 100%;">
					<div class="mdl-card mdl-cell mdl-cell--12-col" style="height: auto;">
						<form:form action="loginsignup.vm" commandName="loginPojo" method="POST" id="signUpForm" style="text-align: -webkit-center;">
							<div class="mdl-card__title">
    							<h2 class="mdl-card__title-text" style="display: inline-table; margin: 10px auto;">Sign Up</h2>
  							</div>
							<div class="mdl-card__supporting-text">
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<form:input class="mdl-textfield__input" id="firstName" type="text" path="person.firstName"  onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32'/> <%-- required="true" --%>
                                    <label class="mdl-textfield__label" for="firstName">First Name</label>
                                </div>
                                <span class="error" id="firstNameErrorField"> <form:errors path="person.firstName"/> </span>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<form:input class="mdl-textfield__input" type="text" path="person.lastName" id="lastName" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32'/> <%-- required="true" --%>
                                    <label class="mdl-textfield__label" for="lastName">Last Name</label>
                                </div>
                                <span class="error" id="lastNameErrorField"> <form:errors path="person.lastName"/> </span>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<form:input class="mdl-textfield__input" type="text" path="neuID" onkeyup="checkNUID()" id="neuID" onblur="checkNUIDValue()" onkeypress='return (event.charCode >= 48 && event.charCode <= 57)'/> <%-- required="true"  --%>
                                    <label class="mdl-textfield__label" for="neuID">NU ID</label>
                                </div>
                                <span class="error" id="nuIDErrorField"> <form:errors path="neuID"/> </span>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<form:input class="mdl-textfield__input" type="text" path="person.phoneNumber"  id="phoneNumber" onkeypress='return (event.charCode >= 48 && event.charCode <= 57)'/><%-- required="true" --%>
                                    <label class="mdl-textfield__label" for="phoneNumber">Mobile Number</label>
                                </div>
                                <span class="error" id="phoneErrorField"> <form:errors path="person.phoneNumber"/> </span>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<form:input class="mdl-textfield__input" type="text" path="username" onkeyup="checkEmail()" onblur="checkEmailValue()" id="username" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/><%-- required="true" --%>
                                    <label class="mdl-textfield__label" for="username">Husky Email ID</label>
                                </div>
                                <span class="error" id="emailErrorField"> <form:errors path="username"/> </span>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<form:input class="mdl-textfield__input" type="password" path="password"  id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/><%-- required="true" --%>
                                    <label class="mdl-textfield__label" for="password">Password</label>
                                </div>
                                <span class="error" id="passwordErrorField"> <form:errors path="password"/> </span>
                                
                                <div style="padding-top: 18px;">
	                                <button onclick="return checkSignUpInput()" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent redButton" style="margin-top: 0px;margin-bottom: 5px;">
  										Sign Up
									</button>
								</div>
								<div>
                                	<c:out value="${requestScope.error}" />
                                </div>
							</div>
						</form:form>
						<div class="hover_center">
							Already have an account? 
							<a class="navigation__link" href="login.vm">
  								Login here
							</a>
						</div>
					</div>
				</section>
			</div>
			<jsp:include page="../views/footer.jsp" />
		</main>
	</div>
</div>
<script src="resources/js/ISWebsite.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="resources/js/material.min.js"></script>
</body>
</html>
