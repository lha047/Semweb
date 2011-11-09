<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<div id="doc" class="yui-t7">
	<div class="bd">
		<div id="yui-main">
			<div class="yui-b">
				<div class="yui-gd">
					<div class="yui-u first">
						<div class="content">
							<div id="vareType">
								VareType:
								<c:out value="${vare.vareType}" />
							</div>
							<div id="vareNavn">
								VareNavn:
								<c:out value="${vare.navn}" />
							</div>
							<div id="aargang">
								Aargang:
								<c:out value="${vare.aargang}" />
							</div>
							<div id="vareNr">
								VareNr:
								<c:out value="${vare.vareNummer}" />
							</div>
							<div id="pris">
								Pris:
								<c:out value="${vare.pris}" />
							</div>
							<div id="alkoholhlprosent">
								Alko%:
								<c:out value="${vare.alkoholProsent}" />
								%
							</div>
							<div id="landOgDistrikt">
								Land/Distrikt:
								<c:out value="${vare.land}" />
								<c:out value="${vare.distrikt}" />
							</div>
							<div id="passerTil">
								Passert til:
								<c:forEach var="mat" items="${vare.passerTil}">
										(<c:out value="${mat}" />)
									</c:forEach>
							</div>
							<div id="karakteristikk">
								Karakteristikk: </br>
								<c:if test="${vare.soedme != -1}">
										S�dme: <c:out value="${vare.soedme}" />
								</c:if>
								<c:if test="${vare.friskhet != -1}">
										Friskhet: <c:out value="${vare.friskhet}" />
								</c:if>
								<c:if test="${vare.garvestoffer != -1}">
										Garvestoffer: <c:out value="${vare.garvestoffer}" />
								</c:if>
								<c:if test="${vare.bitterhet != -1}">
										Bitterhet: <c:out value="${vare.bitterhet}" />
								</c:if>
								<c:if test="${vare.fylde != -1}">
										Fylde: <c:out value="${vare.fylde}" />
								</c:if>
							</div>
						</div>
					</div>
					<div class="yui-u">
						<div class="content">DBPedia
							<div id="artikkelTittel">
								<c:out value="${artikkel.tittel}"/>
							</div>
							<div id="artikkel" >
								<c:out value="${artikkel.artikkel}" />
							</div>
						
						</div>
					</div>
				</div>
			</div>
			<div class="yui-b">
				<div id="secondary">
					<c:forEach var="vare" items="${divVarer}">
						<c:out value="${vare.vareType}" />
						<c:out value="${vare.navn}" />
						<c:out value="${vare.pris}" /> kr
						<c:out value="${vare.land}" /></br>
					</c:forEach>
				
				</div>
			</div>
		</div>
		<div id="ft">
			<div id="footer">Footer</div>
		</div>
	</div>

</div>