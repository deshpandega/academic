<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forgot Password</title>
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
			<div class="mdl-layout__tab-panel is-active" style="height: 87%;">
				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width: 50%; float:right; width: 100%; height: 100%;">
					<div class="mdl-card mdl-cell mdl-cell--12-col" style="text-align: -webkit-center;height: auto;" onload="eventEnhance()">
						<form:form action="loginForgotPassword.vm" commandName="loginPojo" method="POST" id="loginForm" style="text-align: -webkit-center;">
							<div class="mdl-card__title">
    							<h2 class="mdl-card__title-text" style="display: inline-table; margin: 16px auto;">Forgot Password</h2>
  							</div>
							<div class="mdl-card__supporting-text">
								<h4>Enter Your Husky Email and Registered Password</h4>
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<form:input class="mdl-textfield__input" type="text" path="username" id="username" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/>
                                    <label class="mdl-textfield__label" for="username">Username</label>
                                </div>
                                <span class="error"> <form:errors path="username"/> </span>
                                
                                <div style="padding-top: 18px;">
                                	<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent redButton" style="margin-top: 0px;margin-bottom: 5px;">
  										Submit
									</button>
                                </div>
                                <div>
                                	<c:out value="${requestScope.errorLogin}" />
                                </div>
							</div>
						</form:form>
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