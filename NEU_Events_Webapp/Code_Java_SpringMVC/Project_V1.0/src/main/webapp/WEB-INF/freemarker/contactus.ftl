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
		<#include "header.ftl">
		<main class="mdl-layout__content">
			<div class="mdl-layout__tab-panel is-active" style="height: 100%;">
				<div class="mapWidget">
					<script src='https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCz5Cz43v2eMq8JtIgEMlJYuDLybQ4Xm0I'></script><div style='overflow:hidden;height:100%;width:100%;'><div id='gmap_canvas' style='height:100%;width:100%;'></div><style>#gmap_canvas img{max-width:none!important;background:none!important}</style></div> <a href='http://maps-website.com/'>maps-website</a> <script type='text/javascript' src='https://embedmaps.com/google-maps-authorization/script.js?id=72964a893b23486c1577ee87839d26e6d4dbb105'></script><script type='text/javascript'>function init_map(){var myOptions = {zoom:16,center:new google.maps.LatLng(42.3390615986602,-71.09304285819701),mapTypeId: google.maps.MapTypeId.ROADMAP};map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(42.3390615986602,-71.09304285819701)});infowindow = new google.maps.InfoWindow({content:'<strong>Northeastern University</strong><br>Huntington Ave<br>02115 Boston<br>'});google.maps.event.addListener(marker, 'click', function(){infowindow.open(map,marker);});infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);</script>
				</div>
				<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width:30% ; float:right; width: 100%; height: 100%;">
					<div class="mdl-card mdl-cell mdl-cell--12-col" style="height: auto;">
						<fieldset>
						<form action="footerContactus.ftl" method="POST" id="contactUsForm" style="text-align: -webkit-center;">
							<div class="mdl-card__title">
    							<h2 class="mdl-card__title-text" style="display: inline-table; margin: 10px auto;">Contact Us</h2>
  							</div>
							<div class="mdl-card__supporting-text">
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<input required = "true" class="mdl-textfield__input" type="text" name="email"  id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"/>
                                    <label class="mdl-textfield__label" for="username">Email ID</label>
                                </div>
                                <span class="error" id="emailError"> </span>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<input required = "true" class="mdl-textfield__input" type="text" name="subject" id="subject" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || event.charCode == 32'/> 
                                    <label class="mdl-textfield__label" for="subject">Subject</label>
                                </div>
                                <span class="error" id="subjectError"> </span>
                                
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label eventDivs" style="margin-top: 20px;margin: auto;width: 275px;">
									<textarea required = "true" class="mdl-textfield__input" name="message" type="text" rows="4" id="message" onkeypress='return (event.charCode >= 65 && event.charCode <= 90) || (event.charCode >= 97 && event.charCode <= 122) || (event.charCode >= 48 && event.charCode <= 57) || event.charCode == 32' ></textarea>
									<label class="mdl-textfield__label" for="message">Message</label>
								</div>
								<div class="error" id="messageError"> </div>
                                
                                <div style="padding-top: 18px;">
	                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent redButton" style="margin-top: 0px;margin-bottom: 5px;">
  										Submit
									</button>
								</div>
								
								<div>
									<#if Request.response??>
                                		${Request.response}
                                	<#else>
                                		
                                	</#if>
                                </div>
                                <div class="socialMedia">
                                	<span class="socialIcons"><input type="button" class="facebookIcon"/></span>
                                	<span class="socialIcons"><input type="button" class="instagramIcon"/></span>
                                	<span class="socialIcons"><input type="button" class="gplusIcon"/></span>
                                	<span class="socialIcons"><input type="button" class="twitterIcon"/></span>
                                	<span class="socialIcons"><input type="button" class="youtubeIcon"/></span>
                                	<span class="socialIcons"><input type="button" class="linkedInIcon"/></span>
                                </div>
							</div>
						</form>
						</fieldset>
					</div>
				</section>
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
