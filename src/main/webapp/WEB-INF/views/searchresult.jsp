<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>

<div class="searchResult">

<p>Er det noe vin her? </p>
<div id="vinNavn"><c:out value="${Vin.navn}"/></div>
<div id="vinPris"><c:out value="${Vin.pris}"/></div>
<div id="vinAlkoholProsent"><c:out value="${Vin.alkoholProsent}"/></div>
<div id="vinBeskrivelse"><c:out value="${Vin.beskrivelse}"/></div>




</div>