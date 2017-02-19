<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user eq null}">
	<jsp:forward page="../../errorPage.vm"/>
</c:if>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
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
			<div class="mdl-layout__tab-panel is-active">
				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width: 70%; width: 100%; height:auto;margin-top: 2%;">
					<div class="mdl-card mdl-cell mdl-cell--12-col"
						style="text-align: -webkit-center; height: auto;">
						<form:form action="eventcreate.htm" commandName="createEventObject" method="POST" enctype="multipart/form-data">
							<div class="mdl-card__title" style="padding: 16px; display: block;">
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin: 0px; width: 100%;">
									<form:input class="mdl-textfield__input" type="text" path="eventName" id="eventName" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32' />
									<label class="mdl-textfield__label" for="eventName">Event Name</label>
								</div>
								<div class="errorEvents" style="margin-left: 0;"> <form:errors path="eventName"/> </div>
							</div>
							<div class="mdl-card__supporting-text" style="padding-top: 0px;">
								<div class="eventImageDiv">
									<div class="fileUpload" id="fileUpload">
										<i class="material-icons" style="font-size: 100px; padding-top: 8%;">insert_photo</i>
									</div>
									<div class="filePreview" id="filePreview">
										<span id="imageUploaded"></span>
									</div>
									<div >
										<i class="material-icons" style="position: relative;top: 16px;right: -37px;z-index: 1;color: white;">backup</i>
										<form:input type="file" path="eventPhoto" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent redButton uploadButton" />
									</div>
								</div>
								<div class="errorEvents"> <form:errors path="eventPhoto"/> </div>
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs" style="margin-top: 20px;">
									<form:textarea class="mdl-textfield__input" type="text" rows="5" path="eventDescription" id="eventDescription" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32' />
									<label class="mdl-textfield__label" for="eventDescription">Event Description</label>
								</div>
								<div class="errorEvents"> <form:errors path="eventDescription"/> </div>

								<div class="body-row">
									<span class="four-colomn">
										<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs">
											<form:input class="mdl-textfield__input" type="date" path="eventDate" id="eventDate" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32' />
											<label class="mdl-textfield__label mdl-textfield__label_white_color" for="eventDate">Event Date</label>
										</div>
										<div class="errorEvents"> <form:errors path="eventDate"/> </div>
									</span> 
									<span class="four-colomn">
										<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs">
											<form:input class="mdl-textfield__input" type="time" path="eventTime" id="eventTime" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32' />
											<label class="mdl-textfield__label mdl-textfield__label_white_color" for="eventTime">Event Time</label>
										</div>
										<div class="errorEvents"> <form:errors path="eventTime"/> </div>
									</span> 
								</div>
								
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs">
									<form:input class="mdl-textfield__input" type="text" path="addressLine1" id="addressLine1" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32' />
									<label class="mdl-textfield__label" for="addressLine1">Address Line 1</label>
								</div>
								<div class="errorEvents"> <form:errors path="addressLine1"/> </div>
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs">
									<form:input class="mdl-textfield__input" type="text" path="addressLine2" id="eventaddressLine2Name" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32' />
									<label class="mdl-textfield__label" for="addressLine2">Address Line 2</label>
								</div>
								<div class="errorEvents"> <form:errors path="addressLine2"/> </div>
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs">
									<form:input class="mdl-textfield__input" type="text" path="city" id="city" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32' />
									<label class="mdl-textfield__label" for="city">City</label>
								</div>
								<div class="errorEvents"> <form:errors path="city"/> </div>
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs">
									<form:input class="mdl-textfield__input" type="text" path="state" id="state" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32' />
									<label class="mdl-textfield__label" for="state">State</label>
								</div>
								<div class="errorEvents"> <form:errors path="state"/> </div>
								
								<div style="padding-top: 18px; float: left; margin-left: 10%;">
                                	<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent redButton" style="margin-top: 0px;margin-bottom: 5px;">
  										Create Event
									</button>
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
