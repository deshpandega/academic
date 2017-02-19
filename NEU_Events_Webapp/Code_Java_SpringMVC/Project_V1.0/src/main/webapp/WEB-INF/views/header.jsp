<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="mdl-layout__header mdl-layout__header--scroll mdl-color--primary">
	<div class="mdl-layout--large-screen-only mdl-layout__header-row"><h2>Events @NU</h2>
		<nav class="mdl-navigation">
			<a class="mdl-navigation__link" href="index.vm"><i class="material-icons">dashboard</i>Home</a>
			<c:if test="${sessionScope.name ne null}">
				<a class="mdl-navigation__link" href="event.htm"><i class="material-icons">add_box</i>Event</a>
			</c:if>
		</nav>
		<div class="mdl-layout-spacer"></div>
		<c:choose>
			<c:when test="${sessionScope.name ne null}">
				<span class="loggedInUser">
					<button id="demo-menu-lower-right" class="mdl-button mdl-js-button mdl-button--icon" style="margin-top: 0px;">
      					<i class="material-icons">account_box</i>
    				</button>
    				<c:out value="${sessionScope.name}"/>
    			</span>
    			<ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="demo-menu-lower-right">
	      			<a href="logout.htm"><li class="mdl-menu__item">Logout</li></a>
    			</ul>
			</c:when>
			<c:otherwise>
				<a class="mdl-navigation__link loginLink mdl-js-ripple-effect" href="login.vm"><i class="material-icons">account_box</i>Login</a>
			</c:otherwise>
		</c:choose>
	</div>
</header>