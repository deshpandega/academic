<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Reset Password</title>
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
<body onload="getPasswordString()">
<div class="mdl-layout__container">
	<div class="mdl-layout mdl-layout--fixed-header mdl-js-layout mdl-color--grey-100 has-tabs is-upgraded" data-upgraded=",MaterialLayout">
		<jsp:include page="../views/header.jsp" />
		<main class="mdl-layout__content">
			<div class="mdl-layout__tab-panel is-active" style="height: 87%;">
				<form action="loginRetrivePassword.vm" method="POST" id="retrivePassword" style="text-align: -webkit-center;">
					<div class="mdl-card__title">
    					<h2 class="mdl-card__title-text" style="display: inline-table; margin: 16px auto;">Redirecting!</h2>
  					</div>
					<input type="hidden" id="passwordLink" name="passwordLink"/>
				</form>
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