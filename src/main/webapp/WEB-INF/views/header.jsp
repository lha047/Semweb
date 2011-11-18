<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<div id="hd">
	<div class="header">
		<div id="headerImg" ><a href="<c:url value="/"/>"><img id="logo" src="resources/images/vin.jpg" alt="Semantisk web vin app" /> </a></div>
		<div class="search">
			<div id="altInput">
<!-- 				<div id="left"> -->
<!-- 				<form action="" > -->
<!-- 					<select name="vareType"> -->
<!-- 					<option value="roedvin">Rødvin</option> -->
<!-- 					<option value="hvitvin">Hvitvin</option> -->
<!-- 					<option value="oel" selected="selected">Øl</option> -->
<!-- 					<option value="rosevin">Rosevin</option> -->
<!-- 					<option value="brennevin" selected="selected">Brennevin</option> -->
<!-- 					</select> -->
<!-- 				</form> -->
<!-- 				</div> -->
<!-- 				<div id="rigth"> -->
<!-- 				<form action=""> -->
<!-- 					<select name="egenskap"> -->
<!-- 					<option value="kommerFra">kommer fra</option> -->
<!-- 					<option value="koster">koster</option> -->
<!-- 					<option value="karakterisikk">karakteristikk</option> -->
<!-- 					<option value="alkoholprosent">alkoholprosent</option> -->
<!-- 					<option value="passerTil" selected="selected">passer til</option> -->
<!-- 					</select> -->
<!-- 				</form> -->
				
<!-- 				<input name="b"	type="image" src="resources/images/search.gif"  -->
<!-- 						class="button" /> -->
<!-- 				</div> -->
			</div>
			<form id="searchbox" name="searchbox" method="get" action="search" >
				<span> 
					<input name="textfield" size="50" type="text" class="keywords"
						id="textfield" maxlength="50" value="Search..." /> 
					<input name="b"	type="image" src="resources/images/search.gif" 
						class="button" /> 
				</span>
			</form>
			
		</div>
	</div>
</div>