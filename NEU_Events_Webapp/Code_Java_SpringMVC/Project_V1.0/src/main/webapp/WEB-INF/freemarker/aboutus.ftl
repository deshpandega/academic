<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>NU Events</title>
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
		<#include "header.ftl">
		<main class="mdl-layout__content">
			<div class="mdl-layout__tab-panel is-active" style="height: 100%;">
				<div class="mdl-layout__tab-panel is-active" style="margin: 0px 8px;">
				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width: 100%; width: 800px; height:90%; margin-top: 8px;">
					<div class="mdl-card mdl-cell mdl-cell--12-col" style="text-align: left; height: auto; padding: 0px 8px;">
						<div class="mdl-card__title" style="padding: 0px 16px; display: block; margin: 0px 70px;">
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin: 0px; width: 100%;">
								<h3 style="margin: 10px 0px;">About Us</h3><h4 style="margin: 0px; position: relative;right: -110px;top: -43px;">It's Nice to Meet You!</h4><hr style="position: relative;top: -50px;"/>
							</div>
						</div>
						<div class="mdl-card__supporting-text" style="padding-top: 0px; position: relative;top: -50px;">
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs">
								Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
							</div>
						</div>
						<div class="ourTeam">
							<div style="text-align: center;padding: 15px;font-size: 100px;width: 32%;margin: 0px 80px;height: 150px;border-radius: 50%;background-color: white;">
								<div class="teamMember"></div>
							</div>
							<div style="float: right;top: -130px;position: relative;margin-right: 80px;">
								<div><h3 style="margin: 5px 0px;">Gaurang Deshpande</h3></div>
								<div><h4 style="margin: 5px 0px;">001647112</h4></div>
								<div><h4 style="margin: 5px 0px;">Graduate Student at Northeastern University</h4></div>
							</div>
						</div>
					</div>
				</section>
				</div>
			</div>
		</main>
		<#include "footer.ftl">
	</div>
</div>
<script src="resources/js/ISWebsite.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="resources/js/material.min.js"></script>
</body>
</html>