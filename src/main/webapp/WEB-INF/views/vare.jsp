<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!-- noter med classer tilsvarende classene i modellen, slik at det kan bruked igjen.-->

<div id="doc" class="yui-t7">
	<div class="bd">
		<div id="yui-main">
			<div class="yui-b">
				<div class="yui-gd">
					<div class="yui-u first">
						<div class="content">
							<c:if test="${not empty vare}">
								<a href="vare?textfield=${vare.vareNummer}">
									<div id="vareType">
										VareType:
										<c:out value="${vare.vareType}" />
									</div>
									<div id="vareNavn">
										VareNavn:
										<c:out value="${vare.navn}" />
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
										Alko:
										<c:out value="${vare.alkoholProsent}" />
										%
									</div>
									<div id="landOgDistrikt">
										Land/Distrikt:
										<c:out value="${vare.land}" />
										<%-- 									<c:out value="${vare.distrikt}" /> --%>
									</div>
									<div id="passerTil">
										Passert til:
										<c:forEach var="mat" items="${vare.passerTil}">
											(<c:out value="${mat}" />)
										</c:forEach>
									</div>
									<div id="karakteristikk">
										Karakteristikk: </br>
										<c:if test="${vare.soedme != null}">
										Sødme: <c:out value="${vare.soedme}" />
										</c:if>
										<c:if test="${vare.friskhet != null}">
										Friskhet: <c:out value="${vare.friskhet}" />
										</c:if>
										<c:if test="${ vare.garvestoffer != null}">
										Garvestoffer: <c:out value="${vare.garvestoffer}" />
										</c:if>
										<c:if test="${ vare.bitterhet != null}">
										Bitterhet: <c:out value="${vare.bitterhet}" />
										</c:if>
										<c:if test="${ vare.fylde != null}">
										Fylde: <c:out value="${vare.fylde}" />
										</c:if>
									</div>
									</a> 
							</c:if>
						</div>
					</div>
					<div class="yui-u">
						<div class="content">
							DBPedia
							<div id="artikkelBilde">
								<img src="${artikkel.bilde}" alt="">
							</div>
							<div id="artikkelTittel">
								<c:out value="${artikkel.tittel}" />
							</div>
							<div id="artikkel">
								<c:out value="${artikkel.artikkel}" />
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="yui-b">
				<div id="secondary">
					<div id="secondaryVare">
						<c:if test="${not empty divVarer}">
							<c:forEach var="vare" items="${divVarer}">
							<a href="vare?textfield=${vare.vareNummer}">
								<c:out value="${vare.vareType}" />
								Navn: <c:out value="${vare.navn}" />
								Pris: <c:out value="${vare.pris}" /> kr
								Land: <c:out value="${vare.land}" />
								</br>
							</a>								
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<div id="ft">
			<div id="footer">Footer</div>
		</div>
	</div>

</div>
