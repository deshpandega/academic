<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Releasing Soon!</title>
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
		<header class="mdl-layout__header mdl-layout__header--scroll mdl-color--primary">
			<div class="mdl-layout--large-screen-only mdl-layout__header-row"><h2>Releasing Soon!</h2>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="home.htm"><i class="material-icons">dashboard</i>Clear</a>
			</nav>
		</header>
		<main class="mdl-layout__content">
			<div class="mdl-layout__tab-panel is-active" style="height: 87%;">
				<div class="mdl-layout__tab-panel is-active" style="margin: 0px 8px;">
					<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width: 100%; width: 90%; height:auto; margin-top: 8px;margin-left: 6%;float: left;">
						<div class="mdl-card mdl-cell mdl-cell--12-col" style="text-align: -webkit-center; height: auto; padding: 0px 8px;">
							<form action="findMovie.htm" >
							<div class="mdl-card__supporting-text" style="padding-top: 0px;">
								<h4></h4>
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
										<input class="mdl-textfield__input" type="text" name="movieName" id="movieName"/>
                                		<label class="mdl-textfield__label" for="username">Movie name</label>
                                	</div>
								</div>
							</div>
							<div>
                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent redButton" style="margin-top: 0px;margin-bottom: 5px;">
  									Check
								</button>
                            </div>
							</form>
						</div>
					</section>
					<c:if test="${movieObject.movieName ne null}">
						<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width: 100%; width: 90%; height:auto; margin-top: 8px;margin-left: 6%;float: left;">
							<div class="mdl-card mdl-cell mdl-cell--12-col" style="text-align: -webkit-center; height: auto; padding: 0px 8px;">
								<div class="mdl-card__supporting-text" style="padding-top: 0px;">
									<h3>Movie Name : <c:out value="${movieObject.movieName}" /></h3>
								</div>
								
								<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width: 100%; width: 95%; height:auto; margin-top: 8px;margin-left: 0%;float: left;">
									<div class="mdl-card mdl-cell mdl-cell--12-col" style="text-align: -webkit-center; height: auto; padding: 0px 8px; background-color: #3b5998;color: white;">
										<div class="mdl-card__supporting-text" style="padding-top: 0px;text-align: left;">
											<h3 style="text-align: left;"> Facebook</h3>
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<div>Likes:- <c:out value="${movieObject.fanCount}" /></div>
												<div>People talking about:- <c:out value="${movieObject.trendingCount}" /></div>
												<div>Genre:- <c:out value="${movieObject.genre}" /></div>
											</div>
										</div>
									</div>
								</section>
								
								<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width: 100%; width: 95%; height:auto; margin-top: 8px;margin-left: 0%;float: left;">
									<div class="mdl-card mdl-cell mdl-cell--12-col" style="text-align: -webkit-center; height: auto; padding: 0px 8px; background-color: #55ACEE;color: white;">
										<div class="mdl-card__supporting-text" style="padding-top: 0px;text-align: left;">
											<h3 style="text-align: left;">Twitter</h3>
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<div>Followers:- <c:out value="${movieObject.tweetFollowers}" /></div>
												<div>Genre:- <c:out value="${movieObject.genre}" /></div>
											</div>
										</div>
									</div>
								</section>
								
								<section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--16dp" style="max-width: 100%; width: 95%; height:auto; margin-top: 8px;margin-left: 0%;float: left;">
									<div class="mdl-card mdl-cell mdl-cell--12-col" style="text-align: -webkit-center; height: auto; padding: 0px 8px; background-color:#f3ce13 ;color:#343434;">
										<div class="mdl-card__supporting-text" style="padding-top: 0px;text-align: left;">
											<h3 style="text-align: left;">IMDB</h3>
											<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
												<div>Year of Release:- <c:out value="${movieObject.year}" /></div>
												<div>IMDB rating:- <c:out value="${movieObject.imdbRating}" /></div>
												<div>Rated:- <c:out value="${movieObject.type}" /></div>
												<div>Actors:- <c:out value="${movieObject.actors}" /></div>
												<div>Director:- <c:out value="${movieObject.director}" /></div>
												<div>Writer:- <c:out value="${movieObject.writer}" /></div>
											</div>
										</div>
									</div>
								</section>
							</div>
						</section>
					</c:if>
				</div>
			</div>
		</main>
	</div>
</div>
<script src="resources/js/ISWebsite.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="resources/js/material.min.js"></script>
</body>
</html>
