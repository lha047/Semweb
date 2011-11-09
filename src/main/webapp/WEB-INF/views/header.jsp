<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<div id="hd">
	<div class="header">
		<a href="<c:url value="/" />"><img
			src="resources/images/vinApp.png" alt="Semantisk web vin app" /> </a>
		<div class="search">
			<form id="form" name="form" method="post" action="#" >
				<span> <input name="q" size="50" type="text" class="keywords"
					id="textfield" maxlength="50" value="Search..." /> <input name="b"
					type="image" src="resources/images/search.gif" class="button" /> </span>
			</form>
		</div>
	</div>
</div>