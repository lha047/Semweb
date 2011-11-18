<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>

<div class="searchResult">

	<c:forEach var="vare" items="${varer}">
		<a href="vare?textfield=${vare.vareNummer}"> 
			<c:out value="${vare.vareType}" /> 
			Navn: <c:out value="${vare.navn}" />
			Pris: <c:out value="${vare.pris}" /> kr 
			Land: <c:out value="${vare.land}" /></br> 
		</a>
	</c:forEach>



</div>